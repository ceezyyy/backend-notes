# 并发编程基础

Table of Contents
-----------------

* [1. 进程和线程](#1-进程和线程)
* [2. Java 多线程](#2-java-多线程)
   * [2.1 创建和运行](#21-创建和运行)
* [3. 共享模型之管程](#3-共享模型之管程)
* [4. 共享模型之内存](#4-共享模型之内存)
* [5. 共享模型之无锁](#5-共享模型之无锁)
* [6. 共享模型之不可变](#6-共享模型之不可变)




## 1. 进程和线程

**进程**

- 程序由指令和数据组成，这些指令要执行，数据要读写，就必须将指令加载到 `CPU`，数据加载到内存。指令运行的过程中，还需要用到磁盘或网络等设备。进程就是用来加载指令，管理内存，管理 `IO` 的
- 当一个程序被运行，从磁盘加载这个程序的代码至内存，就开启了一个进程
- 进程可以视为程序的一个实例



**线程**

- 一个进程中可以有多个线程
- 一个线程就是一个指令流，将指令流中的一条条指令以一定的顺序交给 `CPU` 执行
- 线程作为最小调度单位，进程作为资源分配最小单位



<div align="center"> <img src="process.png" width="30%"/> </div><br>



## 2. Java 多线程

### 2.1 创建和运行

**方法1: 使用 Thread 类**

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



**方法2: 实现 Runnable 接口（推荐）**

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

**创建 Thread 类和实现 Runnable 接口有何区别？**

实现 `Runnable` 接口本质上还是重写了 `Thread` 类的 `run()` 方法，但将线程和任务分离，降低耦合性





**方法3: FutureTask 配合 Thread**











## 3. 共享模型之管程













## 4. 共享模型之内存

















## 5. 共享模型之无锁















## 6. 共享模型之不可变

