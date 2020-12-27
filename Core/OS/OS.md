

# 操作系统

Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [1. 操作系统内核图](#1-操作系统内核图)
* [2. 操作系统四大特征](#2-操作系统四大特征)
* [3. Process Life Cycle](#3-process-life-cycle)
* [4. 算法调度评价指标](#4-算法调度评价指标)
* [5. 进程调度算法](#5-进程调度算法)
   * [5.1 交互式系统：时间片轮转调度算法](#51-交互式系统时间片轮转调度算法)
   * [5.2 交互式系统：优先级调度算法](#52-交互式系统优先级调度算法)
      * [5.2.1 非抢占式](#521-非抢占式)
      * [5.2.2 抢占式](#522-抢占式)
   * [5.3 交互式系统：多级反馈队列调度算法](#53-交互式系统多级反馈队列调度算法)
* [6. 进程同步](#6-进程同步)
* [7. 进程互斥](#7-进程互斥)
* [8. 信号量机制：记录型信号量](#8-信号量机制记录型信号量)
* [9. 信号量机制实现进程互斥](#9-信号量机制实现进程互斥)
* [10. 信号量机制实现进程同步](#10-信号量机制实现进程同步)
* [11. Producer–consumer problem](#11-producerconsumer-problem)
* [References](#references)


## Brainstorming

<div align="center"> <img src="os.svg" width="100%"/> </div><br>

## 1. 操作系统内核图

<div align="center"> <img src="image-20201226132040321.png" width="80%"/> </div><br>

## 2. 操作系统四大特征

- 并发：计算机系统同时存在着多个运行的程序
- 共享：系统资源可供内存中多个并发的进程共同使用
- 虚拟：将物理实体映射成多个逻辑实体
- 异步：并发下，进程的执行不是一步到底，而是走走停停



## 3. Process Life Cycle

<div align="center"> <img src="process-life-cycle.png" width="80%"/> </div><br>

- `new` -> `ready`：操作系统完成进程创建工作
- `ready` -> `running`：进程准备就绪，等待 `CPU` 调度
- `running` -> `ready`：`CPU` 时间片到 / 有优先级很高的进程抢占调度
- `running` -> `blocked`：等待系统调度 / 等待某事件（**主动**）
- `blocked` -> `ready`：资源分配已到位 / 等待的时间已发生（**被动**）
- `running` -> `terminated`：进程运行结束 / 运行过程中遇到不可修复错误



## 4. 算法调度评价指标

- `CPU` 利用率：忙碌的时间 / 总时间
- 系统吞吐量：完成的总作业数 / 总时间
- 周转时间：作业完成时间 - 作业提交时间
- 等待时间：作业等待调度时间总和
- 响应时间：首次相应与提交请求时间差



## 5. 进程调度算法

### 5.1 交互式系统：时间片轮转调度算法

<div align="center"> <img src="image-20201226192757466.png" width="40%"/> </div><br>

当时间片为 2 时：

<div align="center"> <img src="image-20201226193253039.png" width="60%"/> </div><br>



当时间片为 5 时：

<div align="center"> <img src="image-20201226200320011.png" width="60%"/> </div><br>

**注意：**

- 在时间片内，若进程执行完毕，会主动放弃 `CPU`（进行下一次调度）
- 时间片过大：退化成 `first come first serve`；时间片过小：进程切换太频繁





### 5.2 交互式系统：优先级调度算法


<div align="center"> <img src="image-20201226202248271.png" width="50%"/> </div><br>

#### 5.2.1 非抢占式

每次调度已到达队列且优先级最高的进程，当进程主动放弃 `CPU` 时发生调度

<div align="center"> <img src="image-20201226221547720.png" width="60%"/> </div><br>


#### 5.2.2 抢占式

与非抢占式相比，抢占式在**就绪队列发生改变时**也会判断是否需要抢占

<div align="center"> <img src="image-20201226222621070.png" width="60%"/> </div><br>



### 5.3 交互式系统：多级反馈队列调度算法

<div align="center"> <img src="image-20201226225925784.png" width="40%"/> </div><br>

设置**多级就绪队列**，优先级从高到低，时间片从小到大

<div align="center"> <img src="image-20201226230030071.png" width="70%"/> </div><br>

## 6. 进程同步

多个进程因合作产生一定的制约关系，需要一定执行顺序

## 7. 进程互斥

每次只有一个进程才能访问资源临界区

<div align="center"> <img src="image-20201226231428173.png" width="80%"/> </div><br>

## 8. 信号量机制：记录型信号量



<div align="center"> <img src="image-20201227183752235.png" width="30%"/> </div><br>

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



## 9. 信号量机制实现进程互斥

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



## 10. 信号量机制实现进程同步

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



## 11. Producer–consumer problem

<div align="center"> <img src="producer-consumer.png" width="60%"/> </div><br>

### Constraints

- 只有缓冲区没满时，`producer` 才能把产品放入缓冲区，否则必须等待
- 只有缓冲区不空时，`consumer` 才能从中取出产品，否则必须等待
- 缓冲区是临界资源，各进程必须互斥地访问



### Explained

**Q1: 为什么缓冲区是临界资源？**

**A1:** 并发条件下，若两个进程同时将各自的产品放入缓冲区**同一个位置**，会出现 “数据覆盖” 的现象，所以缓冲区需视为临界资源



**Q2: 如何利用信号量机制实现 producer / consumer 进程的功能？**

**A2: **

## References

- [趣谈Linux操作系统](https://time.geekbang.org/column/intro/164)
- [Process Life Cycle](https://zitoc.com/process-life-cycle/#:~:text=The%20process%20life%20cycle%20can,process%20control%20block%20(PCB).)
- [CS-Notes](https://github.com/CyC2018/CS-Notes/blob/master/notes/%E8%AE%A1%E7%AE%97%E6%9C%BA%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F%20-%20%E7%9B%AE%E5%BD%95.md)

