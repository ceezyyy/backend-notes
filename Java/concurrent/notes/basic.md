# 进程 / 多线程


Table of Contents
-----------------

* [1. 进程产生的背景](#1-进程产生的背景)
   * [1.1 批处理操作系统](#11-批处理操作系统)
   * [1.2 进程的提出](#12-进程的提出)
   * [1.3 线程的提出](#13-线程的提出)
* [2. 上下文切换](#2-上下文切换)
* [3. Java 多线程入门类和接口](#3-java-多线程入门类和接口)
   * [3.1 Thread 类](#31-thread-类)
   * [3.2 Runnable 接口](#32-runnable-接口)
   * [3.3 Thread 与 Runnable 接口比较](#33-thread-与-runnable-接口比较)
   * [3.4 Thread 构造方法](#34-thread-构造方法)
   * [3.5 Thread 常用方法](#35-thread-常用方法)
   * [3.6 Callable](#36-callable)
   * [3.7 Future](#37-future)
   * [3.8 FutureTask](#38-futuretask)
   * [3.9 FutureTask 的几个状态](#39-futuretask-的几个状态)
* [4. 线程组和线程优先级](#4-线程组和线程优先级)
   * [4.1 ThreadGroup](#41-threadgroup)
   * [4.2 线程优先级](#42-线程优先级)
   * [4.3 ThreadGroup 常用方法](#43-threadgroup-常用方法)
   * [4.4 ThreadGroup 数据结构](#44-threadgroup-数据结构)
* [5. 线程的状态 &amp; 主要转化方法](#5-线程的状态--主要转化方法)
   * [5.1 操作系统中的线程状态转换](#51-操作系统中的线程状态转换)
   * [5.2 Java 线程的 6 个状态](#52-java-线程的-6-个状态)
   * [5.3 线程状态的转换](#53-线程状态的转换)
   
   


## 1. 进程产生的背景

最初的计算机只能接受一些特定的指令，用户输入一些指令，计算机读取后执行

在用户思考 / 输入时，计算机大量时间处于等待状态，效率低下



### 1.1 批处理操作系统

到了批处理操作系统时代，用户可以将需要执行的指令用一张清单记录，作为计算机的输入

计算机执行过后，会将结果输出到另一张清单上

这样虽然提高了效率，但在一定程度上，**由于批处理操作系统的指令方式是串行的，内存中仍然只有一个程序在运行**

当前一个程序由于 I / O 操作或网络原因堵塞时，效率受到限制



### 1.2 进程的提出

为了解决上述问题，科学家提出的进程的概念



**进程就是在内存中分配空间，也就是正在运行的程序**



各个线程之间互不干扰，同时进程保持着每一个程序的运行状态

`CPU` 采用时间片轮转的方式运行线程：`CPU` 为每个进程分配一个时间段，称作时间片。

如果在时间片结束时进程仍然在运行，则暂停这个进程的运行，并且 `CPU` 分配给另一个进程（上下文切换）

若进程在时间片结束之前阻塞 / 结束，`CPU` 立即进行切换，不用等时间片用完





进程在我们生活中无处不在

<div align="center"> <img src="image-20200823191846339.png" width="70%"/> </div><br>




### 1.3 线程的提出

虽然进程的出现再次提升了操作系统的性能，但随着时间的推移，人们并不满足一个进程在一段时间内只能做一件事情。如果一个线程有多个子任务时，只能逐个地执行这些子任务，很影响效率

<div align="center"> <img src="image-20200916154100263.png" width="70%"/> </div><br>

那能否让这些子任务同时执行呢？于是人们又提出了线程的概念

**让一个线程执行一个子任务，则一个进程就包含了多个线程**



<div align="center"> <img src="process.png" width="30%"/> </div><br>






## 2. 上下文切换

上下文切换指的是 `CPU` 从一个进程 / 线程切换到另一个进程 / 线程



上下文切换通常是计算密集型，故线程不是越多越好。如何减少系统中上下文切换次数，是提升多线程性能的一个重点课题









## 3. Java 多线程入门类和接口

### 3.1 Thread 类

创建一个 `t1` 线程

重写 `run` 方法，即需要实现的任务

调用 `start` 方法开启线程

```java
@Slf4j
public class App {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                log.info("t1 here!");
            }
        };
        t1.setName("t1");
        t1.start();
        log.info("main here!");
    }

}
```

可见两个线程在同时抢夺 `CPU` 资源，执行顺序不一致

<div align="center"> <img src="image-20200822181506998.png" width="30%"/> </div><br>

<div align="center"> <img src="image-20200822181542006.png" width="30%"/> </div><br>

⚠️注意：

调用 `start()` 后，该线程才算启动！

> 在程序中调用了 start() 方法后，虚拟机会先为我们创建一个线程，然后等到这个线程第一次得到时间片时再调用 run() 方法
>
>
> 注意不可多次调用 start() 方法



### 3.2 Runnable 接口

```java
@Slf4j
public class App {

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            public void run() {
                log.info("t1 here!");
            }
        };

        Thread t1 = new Thread(r1, "t1");
        t1.start();

        log.info("main here!");
    }

}
```





<div align="center"> <img src="image-20200822182313069.png" width="30%"/> </div><br>


<div align="center"> <img src="image-20200822182330205.png" width="30%"/> </div><br>

使用 `lambda expression` 进行简化

```java
@Slf4j
public class App {

    public static void main(String[] args) {

        Runnable r1 = () -> {
            log.info("t1 here!");
        };

        Thread t1 = new Thread(r1, "t1");
        t1.start();

        log.info("main here!");
    }

}
```

### 3.3 Thread 与 Runnable 接口比较

- 底层实现原理一样
- 推荐使用实现 `runnable` 接口的方式（降低耦合度）

调用 `Thread` 类的构造方法传入 `runnable` 接口时，底层也是重写了 `Thread` 类的 `run` 方法

```java
public Thread(Runnable target, String name) {
    init(null, target, name, 0);
}


private void init(ThreadGroup g, Runnable target, String name,
                  long stackSize, AccessControlContext acc,
                  boolean inheritThreadLocals) {
}


@Override
public void run() {
    if (target != null) {
        target.run();
    }
}
```

### 3.4 Thread 构造方法

**Thread.java**

```java
public Thread(Runnable target) {
  init(null, target, "Thread-" + nextThreadNum(), 0);
}


// Initializes a Thread
private void init(ThreadGroup g, Runnable target, String name,
                  long stackSize, AccessControlContext acc,
                  boolean inheritThreadLocals) {
```









### 3.5 Thread 常用方法









### 3.6 Callable









### 3.7 Future







### 3.8 FutureTask













### 3.9 FutureTask 的几个状态





## 4. 线程组和线程优先级

### 4.1 ThreadGroup







### 4.2 线程优先级









### 4.3 ThreadGroup 常用方法









### 4.4 ThreadGroup 数据结构

### 

## 5. 线程的状态 & 主要转化方法

### 5.1 操作系统中的线程状态转换











### 5.2 Java 线程的 6 个状态









### 5.3 线程状态的转换


