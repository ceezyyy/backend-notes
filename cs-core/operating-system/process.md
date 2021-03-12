# Process Management

Table of Contents
-----------------

* [1. Blueprint](#1-blueprint)
* [2. States](#2-states)
* [3. System call](#3-system-call)
* [4. Scheduling](#4-scheduling)
   * [4.1 Strategy](#41-strategy)
      * [4.1.1 FIFO](#411-fifo)
      * [4.1.2 SJF](#412-sjf)
      * [4.1.3 STCF](#413-stcf)
      * [4.1.4 RR](#414-rr)
      * [4.1.5 With IO](#415-with-io)
   * [4.2 Implementation](#42-implementation)
      * [4.2.1 MLFQ](#421-mlfq)
* [5. Synchronization](#5-synchronization)
   * [5.1 Spin Lock](#51-spin-lock)
      * [5.1.1 Test and Set](#511-test-and-set)
      * [5.1.2 CAS](#512-cas)
   * [5.2 Condition Variable](#52-condition-variable)
   * [5.3 Producer / Consumer Problem](#53-producer--consumer-problem)
   * [5.4 Semaphore](#54-semaphore)
   * [5.5 Readers-Writers Problem](#55-readers-writers-problem)
   * [5.6 Dining Philosophers Problem](#56-dining-philosophers-problem)
   * [5.7 Concurrency Problems](#57-concurrency-problems)
      * [5.7.1 Deadlock](#571-deadlock)



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

### 4.1 Strategy

#### 4.1.1 FIFO

<div align="center"> <img src="fifo.jpg" width="80%"/> </div><br>

#### 4.1.2 SJF

<div align="center"> <img src="sjf.jpg" width="80%"/> </div><br>





#### 4.1.3 STCF

<div align="center"> <img src="stcf.jpg" width="40%"/> </div><br>

#### 4.1.4 RR

<div align="center"> <img src="rr.jpg" width="40%"/> </div><br>

#### 4.1.5 With IO

> 一个进程在等待另一个进程的 I/O 完成时使用 CPU

<div align="center"> <img src="combine-io.jpg" width="75%"/> </div><br>



### 4.2 Implementation

#### 4.2.1 MLFQ

**Rule 1**

先执行优先级高的队列



**Rule 2**

对于在相同优先级队列中的任务，采用 `RR` 算法

<div align="center"> <img src="mlfq-1.png" width="35%"/> </div><br>

**Rule 3**

新任务放入最高优先级队列（在最开始的假设是短工作，并赋予最高优先级；如果确实是短工作，很快就会执行完毕；反之，则移动到低优先级的队列中）



<div align="center"> <img src="mlfq-2.png" width="30%"/> </div><br>


<div align="center"> <img src="mlfq-3.png" width="30%"/> </div><br>

**Rule 4**

当任务用完整个时间片后，降低其优先级

**但是**，若任务主动释放 CPU，则优先级不变（让交互型工作快速进行）

<div align="center"> <img src="mlfq-4.png" width="30%"/> </div><br>

**改进版 Rule 4**

一旦工作用完了其在某一队列中的时间配额，无论中间主动放弃了多少次 CPU，都降低其优先级（避免被长作业“愚弄“）



<div align="center"> <img src="mlfq-6.png" width="50%"/> </div><br>



**Rule 5**

经过一段时间 S，就将所有工作重新放入到最高优先级队列中（避免长作业 “饥饿”，甚至饿死）

<div align="center"> <img src="mlfq-5.png" width="50%"/> </div><br>



## 5. Synchronization

### 5.1 Spin Lock

<div align="center"> <img src="spinlock.jpg" width="70%"/> </div><br>

#### 5.1.1 Test and Set

**test-and-set**

```c
typedef struct lock_t { int flag; } lock_t;

void init(lock_t *mutex) {
  // 0 -> lock is available
  // 1 -> held
  mutex->flag = 0;
}


void lock(lock_t *mutex) {
  // TEST the flag
  while (mutex->flag == 1);
  // spin-wait
  // now SET it
  mutex->flag = 1;
}


void unlock(lock_t *mutex) {
  mutex->flag = 0;
}
```

**缺陷**

通过适时的中断，使得两个线程都可以进入临界区



**TestAndSet 原子指令**

```c
int TestAndSet(int *old_ptr, int new) {
  int old = *old_ptr;
  *old_ptr = new;
  return old;
}


void lock(lock_t *mutex) {
  while (TestAndSet(&mutex->flag, 1) == 1);
}

```



#### 5.1.2 CAS

> Compare and Swap

**CompareAndSwap 原子指令**

```c
int CompareAndSwap(int *ptr, int expected, int new) {
  int actual = *ptr;
  if (actual == expected)  // COMPARE
    *ptr = new;  // SWAP
  return actual;
}


void lock(lock_t *mutex) {
  while (CompareAndSwap(&mutex->flag, 0, 1) == 1);
}

```



### 5.2 Condition Variable

```c
// Declaration of thread condition variable 
pthread_cond_t cond = PTHREAD_COND_INITIALIZER; 

// declaring mutex 
pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER; 

// 0 -> unfinished
// 1 -> finished
int done = 1; 

void thr_join() {
  Pthread_mutex_lock(&lock);
  
  while (done == 0) 
    Pthread_cond_wait(&cond, &lock);
  
  Pthread_mutex_unlock(&lock);
}


void thr_exit() {
  Pthread_mutex_lock(&lock);
  
  done = 1;
  Pthread_cond_signal(&cond);
  
  Pthread_mutex_unlock(&lock);
}
```



### 5.3 Producer / Consumer Problem

> 1972 年由 Dijkstra 提出，通过研究此问题，他和他的同事发明了通用的信号量

<div align="center"> <img src="producer-consumer.png" width="50%"/> </div><br>

**ProducerConsumerProblem.c**

```c
cond_t empty, fill;
mutex_t mutex;


void *producer(void *arg) {
  int i;
  for (i = 0; i < loops, i++) {
    
    Pthread_mutex_lock(&mutex);
    
    while (count == MAX)
      // wait for "empty"
      Pthread_cond_wait(&empty, &mutex);
    put(i);
    // signal for "filling"
    Pthread_cond_signal(&fill);
    
    Pthread_mutex_unlock(&mutex);
  
  }
}


void *consumer(void *arg) {
  int i;
  for (i = 0; i < loops, i++) {
    
    Pthread_mutex_lock(&mutex);
    
    while (count == 0)
      // wait for "filling"
      Pthread_cond_wait(&fill, &mutex);
    get();
    // signal for "empty"
    Pthread_cond_signal(&empty);
    
    Pthread_mutex_unlock(&mutex);
  
  }
}
```



### 5.4 Semaphore

> 同步原语

**Semaphore.c**

```c
#include <semaphore.h>
sem_t s;
// 0 -> shared with multi threads
// 1 -> initialize semaphore to 1
sem_init(&s, 0, 1);


// P 操作
int sem_wait(sem_t *s) {
  // decrement the value of semaphore by one
  // wait if value of semaphore s is negative
  // 信号量的值为负数：等待线程的个数
}


// V 操作
int sem_post(sem_t *s) {
  // increment the value of semaphore by one
  // if there are one or more threads waiting, wake up
}

```



**ProducerConsumerProblem.c**

```c
// Implemented producer-consumer-problem by semaphore
// 将获取和释放互斥量的操作紧挨着临界区 -> 减少锁的作用域以避免 deadlock
sem_t empty;
sem_t full;
sem_t mutex;


void *producer(void *arg) {
  int i;
  for (i = 0; i < loops; i++) {
    sem_wait(&empty);
    sem_wait(&mutex);
    put();
    sem_post(&mutex);
    sem_post(&full);
  }
}


void *consumer(void *arg) {
  int i;
  for (i = 0; i < loops; i++) {
    sem_wait(&full);
    sem_wait(&mutex);
    get();
    sem_post(&mutex);
    sem_post(&empty);
  }
}


int main(int argc, char *argv[]) {
  // do something
  sem_init(&empty, 0, MAX);
  sem_init(&full, 0, 0);
  sem_init(&mutex, 0, 1);
}
```



**Zemaphore.c**

```c
typedef struct _Zem_t {
  int value;
  pthread_cond_t cond;
  pthread_mutex_t lock;
} Zem_t;


// Only one thread can call this
void Zem_init(Zem_t *s, int value) {
  s->value = value;
  Cond_init(&s->cond);
  Mutex_init(&s->lock);
}


void Zem_wait(Zem_t *s) {
  Mutex_lock(&s->lock);
  while (s->value <= 0) 
    Cond_wait(&s->cond, &s->lock);
  s->value--;
  Mutex_unlock(&s->lock);
}


void Zem_post(Zem_t *s) {
  Mutex_lock(&s->lock);
  s->value++;
  Cond_signal(&s->cond);
  Mutex_unlock(&s->lock);
}

```



### 5.5 Readers-Writers Problem

<div align="center"> <img src="image-20210219123120526.png" width="60%"/> </div><br>

**ReadersWritersProblem.c**

```c
 typedef struct _rwlock_t {
  sem_t lock;  // basic lock
  sem_t writelock;  // used to allow ONE writer or MANY readers
  int readers;
} rwlock_t;


void rwlock_init(rwlock_t *rw) {
  rw->readers = 0;
  sem_init(&rw->lock, 0, 1);
  sem_init(&rw->writelock, 0, 1);
}


void rwlock_acquire_readlock(rwlock_t *rw) {
  sem_wait(&rw->lock);
  rw->readers++;
  if (rw->readers == 1)
    sem_wait(&rw->writelock);  // first reader acquires writelock
  sem_post(&rw->lock);
}


void rwlock_release_readlock(rwlock_t *rw) {
  sem_wait(&rw->lock);
  rw->readers--;
  if (rw->readers == 0)
    sem_post(&rw->writelock);  // last reader releases writelock
  sem_post(&rw->lock);
}


void rwlock_acquire_writelock(rwlock_t *rw) {
  sem_wait(&rw->writelock);
}


void rwlock_release_writelock(rwlock_t *rw) {
  sem_post(&rw->writelock);
}

```



### 5.6 Dining Philosophers Problem

<div align="center"> <img src="dining-p-problem.gif" width="45%"/> </div><br>



### 5.7 Concurrency Problems

> 了解并发缺陷的模式是写出健壮，正确的程序的第一步

#### 5.7.1 Deadlock

<div align="center"> <img src="deadlock.png" width="40%"/> </div><br>

