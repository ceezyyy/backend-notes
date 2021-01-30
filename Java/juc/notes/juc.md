# J.U.C

Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [1. 线程](#1-线程)
   * [1.1 状态](#11-状态)
      * [1.1.1 线程在操作系统中的状态](#111-线程在操作系统中的状态)
      * [1.1.2 Java 线程的状态](#112-java-线程的状态)
* [2. 锁](#2-锁)
* [References](#references)



## Brainstorming

<div align="center"> <img src="JUC.svg" width="100%"/> </div><br>



## 1. 线程

### 1.1 状态

#### 1.1.1 线程在操作系统中的状态

<div align="center"> <img src="thread-states.png" width="90%"/> </div><br>

#### 1.1.2 Java 线程的状态

**Thread.java**

```java
// Thread.State
public enum State {
  
    // 初始状态 -> 线程被构建，但未被调用 start()
    NEW,
  
    // 运行状态 -> 包含操作系统中的 ready 和 running 状态
    RUNNABLE,
  
    // 阻塞状态 -> 等待锁的释放进入同步区
    BLOCKED,
  
    // 等待状态 -> 变成 runnable 需被其他线程唤醒
    WAITING,

	  // 超时等待状态 -> 线程在一段时间之后自动唤醒
    TIMED_WAITING,

	  // 终止状态 -> 线程执行完毕
    TERMINATED;

}
```



**Java 线程转换图**

<div align="center"> <img src="thread-states-2.png" width="90%"/> </div><br>









## 2. 锁













## References

- [CyC2018](https://github.com/CyC2018/CS-Notes/blob/master/notes/Java%20%E5%B9%B6%E5%8F%91.md)
- [RedSpider1 / concurrent](https://github.com/RedSpider1/concurrent)

