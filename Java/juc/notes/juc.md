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
  
    NEW,
    RUNNABLE,
    BLOCKED,
    WAITING,
    TIMED_WAITING,
    TERMINATED;

}
```



**Java 线程转换图**

<div align="center"> <img src="thread-states-2.png" width="90%"/> </div><br>









## 2. 锁













## References

- [CyC2018](https://github.com/CyC2018/CS-Notes/blob/master/notes/Java%20%E5%B9%B6%E5%8F%91.md)
- [RedSpider1 / concurrent](https://github.com/RedSpider1/concurrent)

