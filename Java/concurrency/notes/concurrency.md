# Java Concurrency

Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [1. 并发编程基础](#1-并发编程基础)


## Brainstorming

<div align="center"> <img src="concurrency.svg" width="100%"/> </div><br>

## 1. 使用线程

### 1.1 继承 Thread

```java
public class App {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Mythread here!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Main here!");
        new MyThread().start();
    }
}
```



### 1.2 实现 Runnable

```java
@FunctionalInterface
public interface Runnable {
    public abstract void run();
}


public class App {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("My thread here!");
        }).start();
        System.out.println("Main here!");
    }
}
```

- `Thread` 的构造函数中，包含 `@FunctionalInterface` 的只有 `Runnable` -> 使用 JDK8 函数式编程简化代码



### 1.3 Thread 类构造方法

对于 1.1 和 1.2 两种构造线程的方法，底层实现逻辑都是调用了 `Thread.init()`

```java
public Thread(Runnable target) {
        init(null, target, "Thread-" + nextThreadNum(), 0);
    }


private void init(ThreadGroup g, Runnable target, String name,
                      long stackSize, AccessControlContext acc,
                      boolean inheritThreadLocals) {
```

- g: 线程组
- target: 要执行的任务
- name: 线程名字
- stackSize:
- acc:
- inheritThreadLocals:



## 2. ThreadGroup

`threadgroup` 呈树状结构



<div align="center"> <img src="threadgroup.gif" width="50%"/> </div><br>

**ThreadGroup.java**

```java
public
class ThreadGroup implements Thread.UncaughtExceptionHandler {
    private final ThreadGroup parent;
    String name;
    int maxPriority;
    boolean destroyed;
    boolean daemon;
    boolean vmAllowSuspension;

    int nUnstartedThreads = 0;
    int nthreads;
    Thread threads[];

    int ngroups;
    ThreadGroup groups[];
```



若创建线程时没有显式指定 `threadgroup`: 使用父线程的 `threadgroup`

**App.java**

```java
public class App {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("The ThreadGroup of t1: "
                    + Thread.currentThread().getThreadGroup().getName());
        }, "t1").start();  // The ThreadGroup of t1: main

        System.out.println("The ThreadGroup of main: "
                + Thread.currentThread().getThreadGroup().getName());  // The ThreadGroup of main: main

    }

}
```





## 3. 线程状态

