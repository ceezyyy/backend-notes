# J.U.C

Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [1. 线程基础](#1-线程基础)
   * [1.1 创建](#11-创建)
      * [1.1.1 Runnable](#111-runnable)
      * [1.1.2 FutureTask](#112-futuretask)
   * [1.2 状态](#12-状态)
      * [1.2.1 操作系统中线程状态](#121-操作系统中线程状态)
      * [1.2.2 Java 中线程状态](#122-java-中线程状态)
   * [1.3 机制](#13-机制)
      * [1.3.1 Executor](#131-executor)
      * [1.3.2 Daemon](#132-daemon)
      * [1.3.3 sleep()](#133-sleep)
   * [1.4 中断](#14-中断)
   * [1.5 互斥同步](#15-互斥同步)
      * [1.5.1 锁是基于对象的](#151-锁是基于对象的)
* [References](#references)



## Brainstorming

<div align="center"> <img src="JUC.svg" width="100%"/> </div><br>


## 1. 线程基础

### 1.1 创建

#### 1.1.1 Runnable

**App.java**

```java
@FunctionalInterface
public interface Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see     java.lang.Thread#run()
     */
    public abstract void run();
}


public class App {

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " here!");
        }, "t1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " here!");
        }, "t2").start();

        System.out.println(Thread.currentThread().getName() + " here!");

    }

}
```



#### 1.1.2 FutureTask

**App.java**

```java
@FunctionalInterface
public interface Callable<V> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    V call() throws Exception;
}


public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> task = new FutureTask<>(() -> {
            return "Hello World from " + Thread.currentThread().getName();
        });

        new Thread(task, "t1").start();

        System.out.println("Hello World from " + Thread.currentThread().getName());

        System.out.println(task.get());

    }
}
```

### 1.2 状态

#### 1.2.1 操作系统中线程状态

<div align="center"> <img src="thread-states.png" width="90%"/> </div><br>

#### 1.2.2 Java 中线程状态

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



**状态转换图**

<div align="center"> <img src="thread-states-2.png" width="90%"/> </div><br>









### 1.3 机制

#### 1.3.1 Executor

<div align="center"> <img src="thread-pool.png" width="60%"/> </div><br>

**Executor.java**

```java
public interface Executor {

    void execute(Runnable command);
  
}
```



**Executors.java**

```java
package java.util.concurrent;


public class Executors {
}
```



#### 1.3.2 Daemon

```java
public class App {

    public static void main(String[] args) {

        // User thread
        new Thread(() -> {
            while (true) {
                // Do nothing
            }
        }, "t1").start();

        System.out.println("Main thread exited");

    }

}
```

<div align="center"> <img src="image-20210131142739282.png" width="70%"/> </div><br>

**App.java**

```java
public class App {

    public static void main(String[] args) {

        // Daemon thread
        Thread task = new Thread(() -> {
            while (true) {
                // Do nothing
            }
        }, "t1");

        task.setDaemon(true);
        task.start();

        System.out.println("Main thread exited");

    }

}
```

<div align="center"> <img src="image-20210131143140067.png" width="70%"/> </div><br>





#### 1.3.3 sleep()

```java
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    e.printStackTrace();
}
```



### 1.4 中断

**Thread.java**

```java
public void interrupt() {
  // t1 运行时，t2 可以调用 t1.interrupt() 来设置 t1 的中断标志为 true 并立即返回
  // t1 并没有中断，会继续执行
  // 若 t1 处于 waiting / timed_waiting -> 抛 InterruptedException
}


public static boolean interrupted() {
  // 对当前中断标识位进行复位
}


public boolean isInterrupted() {
  // 当前线程是否被中断
}
```

### 1.5 互斥同步

#### 1.5.1 锁是基于对象的 

**SynchronizedDemo.java**

```java
public class SynchronizedDemo {

    public synchronized void func() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
    }

}
```



**App.java**

```java
public class App {
    public static void main(String[] args) {

        SynchronizedDemo demo = new SynchronizedDemo();

        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(() -> demo.func());
        pool.execute(() -> demo.func());

        // 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9

        pool.shutdown();

    }
}
```



**Explained**

使用 `ExecutorService` 执行了 2 个 **线程** 对 **资源**  `SynchronizedDemo` 进行 **操作**

由于 `func()` 为同步方法，当一个线程进入时，另一个就必须等待



**App**

```java
public class App {
    public static void main(String[] args) {

        SynchronizedDemo demo1 = new SynchronizedDemo();
        SynchronizedDemo demo2 = new SynchronizedDemo();

        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(() -> demo1.func());
        pool.execute(() -> demo2.func());

        // 0 1 2 0 1 2 3 4 3 5 4 5 6 7 8 9 6 7 8 9 
        
        pool.shutdown();

    }
}
```



**Explained**

`Java` 中的锁是基于对象的







## References

- 翟陆续, 薛宾田. Java并发编程之美 [M]. 电子工业出版社, 2018.
- 方腾飞, 魏鹏, 程晓明. Java并发编程的艺术 [M]. 机械工业出版社, 2019.
- [CyC2018](https://github.com/CyC2018/CS-Notes/blob/master/notes/Java%20%E5%B9%B6%E5%8F%91.md)
- [RedSpider1 / concurrent](https://github.com/RedSpider1/concurrent)
- [A Guide to the Java ExecutorService](https://www.baeldung.com/java-executor-service-tutorial)
