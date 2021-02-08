# 进程管理

Table of Contents
-----------------

* [1. Blueprint](#1-blueprint)
* [2. States](#2-states)
* [3. System call](#3-system-call)
* [4. Scheduling](#4-scheduling)
* [5. Semaphore](#5-semaphore)
   * [5.1 记录型信号量](#51-记录型信号量)
   * [5.2 进程互斥](#52-进程互斥)
   * [5.3 进程同步](#53-进程同步)
   * [5.4 Producer–Consumer Problem](#54-producerconsumer-problem)
   * [5.5 Readers-Writers Problem](#55-readers-writers-problem)
   * [5.6 Dining Philosophers Problem（待补充）](#56-dining-philosophers-problem待补充)
* [6. Deadlock](#6-deadlock)
   * [6.1 产生的必要条件](#61-产生的必要条件)
   * [6.2 死锁避免](#62-死锁避免)
      * [6.2.1 背景](#621-背景)
      * [6.2.2 安全状态](#622-安全状态)
      * [6.2.3 单个资源的银行家算法](#623-单个资源的银行家算法)
      * [6.2.4 多个资源的银行家算法](#624-多个资源的银行家算法)
   * [6.3 死锁检测 &amp; 恢复](#63-死锁检测--恢复)
      * [6.3.1 单个资源](#631-单个资源)
      * [6.3.2 多个资源](#632-多个资源)


## 1. Blueprint

**Process**

<div align="center"> <img src="process.png" width="80%"/> </div><br>



**Thread**

<div align="center"> <img src="thread.png" width="40%"/> </div><br>





**Parallelism VS Concurrency**

<div align="center"> <img src="concurrency.png" width="90%"/> </div><br>

**schedule()**

```c
schedule() {
  pNew = getNext(ReadyQueue);
  switch_to(pCur, pNew);
}
```



## 2. States

<div align="center"> <img src="process-life-cycle.png" width="70%"/> </div><br>



## 3. System call

<div align="center"> <img src="system-call.png" width="70%"/> </div><br>

**Linux 下主要的系统调用**

|   Task   |          Commands           |
| :------: | :-------------------------: |
| 进程控制 |   fork(); exit(); wait();   |
| 进程通信 |  pipe(); shmget(); mmap();  |
| 文件操作 |  open(); read(); write();   |
| 设备操作 |  ioctl(); read(); write();  |
| 信息维护 | getpid(); alarm(); sleep(); |
|   安全   | chmod(); umask(); chown();  |



## 4. Scheduling









## 5. Semaphore

```cpp
do {
  
  // 对请求的资源上锁
  entry section;
  critical section;
  // 释放该资源的锁
  exit section;
  remainder section;
  
} while (true);
```



### 5.1 记录型信号量

**struct.cpp**

```cpp
typedef struct {
  int value;  // 剩余资源数
  struct process *L;  // 等待队列
} semaphore;
```

**wait(S)**

```cpp
void wait (semaphore S) {
  // 请求一个单位的资源
  S.value--;
  // 当前没有资源可用
  if (S.value < 0) {
    // running -> blocked
    // 主动加入等待队列, 实现"让权等待"
    block (S.L);  
  }
}
```

**signal(S)**

```cpp
void signal (semaphore S) {
  // 释放一个单位的资源
  S.value++;
  // 仍有进程在等待队列等待
  if (S.value <= 0) {
    // blocked -> ready
    // 使用 wakeup 原语唤醒等待队列中的一个进程
    wakeup(S.L);
  }
}
```

**注意：**

- `wait(S)` 和 `signal(S)` 设计为原语，一气呵成，不可分割（重要！！！）
- `wait(S)` 和 `signal(S)` 也称 `PV` 操作，需成对出现



### 5.2 进程互斥

**核心思想：**

1. 初始化互斥信号量为 1
2. `P` 操作（原语）
3. 临界区操作
4. `V` 操作（原语）

```cpp
// 初始化互斥信号量为 1（因为临界资源区最多只能一个进程访问）
semaphore mutex = 1;

P1() {
  ...;
  // 加锁
  P(mutex);
  // 临界区代码段 
  Do something;
  // 释放锁
  V(mutex);
  ...;
}

P2() {
  ...;
  // 加锁
  P(mutex);
  // 临界区代码段 
  Do something;
  // 释放锁
  V(mutex);
  ...;
}
```



### 5.3 进程同步

**核心思想：**

1. 初始化同步信号量为 0
2. "前操作"
3. `V` 操作（原语）
4. `P` 操作（原语）
5. “后操作”


```cpp
// 初始化同步信号量为 0
semaphore S = 0;

P1() {
  // Code block 1
  Do something;
  V(S);
  // Code block 2
  Do Something;
}

P2() {
  P(S);
  // Code block 3
  Do Something;
}
```

保证了 `Code block 3` 一定在 `Code block 1` 之后执行



### 5.4 Producer–Consumer Problem

<div align="center"> <img src="producer-consumer.png" width="60%"/> </div><br>

**Constraints**

- 只有缓冲区没满时，`producer` 才能把产品放入缓冲区，否则必须等待
- 只有缓冲区不空时，`consumer` 才能从中取出产品，否则必须等待
- 缓冲区是临界资源，各进程必须互斥地访问（因为并发条件下，若两个进程同时将各自的产品放入缓冲区同一个位置，会出现 “数据覆盖” 的现象）



**Explained**

- Semaphore Q: 用来保证缓冲区进程互斥，初始值为 1（Q 代表 queue）
- Semaphore E: 初始值为 n（E 代表 empty，缓冲区空闲的位置）
- Semaphore F: 初始值为 0（F 代表 filled，缓冲区已占用的位置）



**Producer**

```java
void producer() {
  while (T) {
    // 生产数据
    produce();
    // 是否有空闲的位置可以投放
    wait(E);
    // 当前缓冲区是否被占用
    wait(Q);
    // 投放数据
    append();
    // 释放缓冲区
    signal(Q);
    // 更新缓冲区已占用的数量
    signal(F);
  }
}
```



**Consumer**

```java
void consumer() {
  while (T) {
    // 缓冲区是否有数据可以被消费
    wait(F);
    // 缓冲区是否被占用
    wait(Q);
    // 从缓冲区拿数据
    take();
    // 释放缓冲区的资源
    signal(Q);
    // 缓冲区空闲位置增加
    signal(E);
    // 消费数据
    consume();
  }
}
```





### 5.5 Readers-Writers Problem

<div align="center"> <img src="the-readers-writers-problem.jpg" width="60%"/> </div><br>

**Contraints**

两种场景（针对同一时刻）：

1. 一个 `writer`
2. 多个 `reader`



**Explained**

- Semaphore W: 写操作是互斥的，初始值为 1（W 代表 write）
- readCount: 当前 `reader` 的数量（普通变量），初始值为 0
- Semaphore mutex: 用来互斥地增减 `readCount` 的值，初始值为 1



**Writer**

```java
void write() {
  // 是否有其他进程在写数据
  wait(W);
  // 写入数据
  writing();
  // 释放资源
  signal(W);
}
```



**Reader**

```java
void read() {
  
  // 互斥地增加 readCount 数量
  wait(mutex);
  readCount++;
  //当第一个 reader 进来时, 给 writer 上锁
  if (readCount == 1) {
    wait(W);
  }
  signal(mutex);
  
  // 进行读操作
  reading();
  
  // 互斥地减少 readCount 数量
  wait(mutex);
  readCount--;
  // 当没有 reader 进程时, 释放 writer 锁
  if (readCount == 0) {
    signal(W);
  }
  signal(mutex);
  
}
```



### 5.6 Dining Philosophers Problem（待补充）

<div align="center"> <img src="dining_phil.png" width="40%"/> </div><br>



**Background**

At any instant, a philosopher is either eating or thinking. When a philosopher wants to eat, he uses two chopsticks - one from their left and one from their right. When a philosopher wants to think, he keeps down both chopsticks at their original place





## 6. Deadlock

死锁是指多个进程在执行过程中互相等待对方的资源而造成全部阻塞的情况

<div align="center"> <img src="image-20201228212139674.png" width="70%"/> </div><br>

### 6.1 产生的必要条件

产生死锁**必须同时满足以下四个条件**（联想哲学家进餐问题）



<div align="center"> <img src="dining-philosophers-problem-2.png" width="50%"/> </div><br>

1. 互斥：若资源是共享的，则可避免死锁
2. Hold and wait：若放弃手里的 / 不去等待其他资源，则可避免死锁
3. 非抢占式：若其他进程可以抢夺，则可避免死锁
4. 循环等待



### 6.2 死锁避免

#### 6.2.1 背景

银行家算法（Banker's Algorithm）是一个避免死锁的著名算法（算法中银行家好比操作系统，资金好比系统资源，申请的客户好比进程）



在银行中：

- 客户申请贷款数量有限，每个客户在第一次申请时要声明最大资金量
- 在满足贷款要求后，客户应及时归还
- 银行家应尽量满足客户需要



#### 6.2.2 安全状态

若没有发生死锁，并且即使所有进程突然请求对资源的最大需求，也仍然存在**某种调度次序能够使得每一个进程运行完毕**，则称该状态是安全的



<div align="center"> <img src="bank-algo-1.png" width="70%"/> </div><br>

- `Has`：表示已分配的资源
- `Max`：表示所需的最大资源



分配流程：从图 a 开始出发，先让 B 拥有所需的资源（如图 b），等 B 运行结束后释放所有资源（如图 C）；再依次分配给 C（如图 d） 和 A（如图 e）



#### 6.2.3 单个资源的银行家算法

<div align="center"> <img src="bank-algo-2.png" width="70%"/> </div><br>

第一次请求后：“银行家” 仅剩 2 个单位的资源

第二次请求后：”银行家“（操作系统）仅剩 1 个单位资源，无法满足任一 “客户” （进程）的最大需求



**因此，算法会拒绝之前的请求，避免进入图 c 的状态**



#### 6.2.4 多个资源的银行家算法

在操作系统中，是

存在多个进程以及资源

<div align="center"> <img src="bank-algo-3.png" width="70%"/> </div><br>

- E: 总资源
- P: 已分配资源
- A: 待分配资源



**检查一个状态是否安全的算法如下：**



1. 查找右边的矩阵（待分配矩阵）是否存在一行小于等于向量 A；若不存在，则系统将会发生死锁，状态是不安全的
2. 若存在，则将该进程标记为终止，并将其已分配资源加到 A 中
3. 重复以上两步骤=。直到所有进程都标记为终止，则状态是安全的



若一个状态是不安全的，则需要拒绝进入这个状态



### 6.3 死锁检测 & 恢复

#### 6.3.1 单个资源

<div align="center"> <img src="deadlocks-handling.png" width="70%"/> </div><br>

图示说明：

- 正方形代表资源，圆形代表进程
- 正方形指向圆形代表资源分配给该进程，圆形指向正方形代表进程请求该资源



**总结**

若有向图存在环，则证明有死锁的存在



#### 6.3.2 多个资源

<div align="center"> <img src="deadlocks-handling-2.png" width="70%"/> </div><br>



图示说明：

- E 向量：资源总量
- A 向量：资源剩余量
- C 矩阵：进程所占有资源数量
- R 矩阵：进程所请求资源数量



**总结**

每个进程最开始都不被标记。当算法结束时，任何没有被标记的进程都是死锁进程

1. 寻找一个没有标记的进程 Pi，它所请求的资源小于等于 A
2. 若找到，标记该进程，并将 C 矩阵的第 i 行向量加到 A 中，转第一步
3. 若没找到，算法终止

