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
      * [1.5.1 synchronized 用法](#151-synchronized-用法)
      * [1.5.2 锁为 Class 对象](#152-锁为-class-对象)
      * [1.5.3 锁为 instance](#153-锁为-instance)
      * [1.5.4 synchronized 内存语义](#154-synchronized-内存语义)
   * [1.6 线程间协作](#16-线程间协作)
      * [1.6.1 Thread.join()](#161-threadjoin)
      * [1.6.2 Object.wait()  &amp; Object.notify()](#162-objectwait---objectnotify)
* [2. 锁](#2-锁)
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

#### 1.5.1 synchronized 用法

```java
// 关键字在 instance 方法上 -> 锁为当前 instance
public synchronized void instanceLock() {
    // code
}


// 关键字在静态方法上 -> 锁为当前 Class 对象
public static synchronized void classLock() {
    // code
}


// 关键字在代码块上 -> 锁为括号里面的对象 (Class 对象 / instance)
public void blockLock() {
    Object o = new Object();
    synchronized (o) {
        // code
    }
}
```



以下两种写法等价

```java
// 关键字在 instance 方法上 -> 锁为当前 instance
public synchronized void instanceLock() {
    // code
}


// 关键字在代码块上 -> 锁为括号里面的 instance
public void blockLock() {
    synchronized (this) {
        // code
    }
}
```



这两种写法也是等价的

```java
// 关键字在静态方法上 -> 锁为当前 Class 对象
public static synchronized void classLock() {
    // code
}


// 关键字在代码块上 -> 锁为括号里的 Class 对象
public void blockLock() {
    synchronized (this.getClass()) {
        // code
    }
}
```



#### 1.5.2 锁为 Class 对象

**Resource.java**

```java
public class Resource {

    public static synchronized void func() {
        for (int i = 0; i < 20; i++) {
            System.out.print(i + " ");
        }
    }
}
```

**Resource.java**

```java
public class Resource {

    public void func() {
        synchronized (this.getClass()) {
            for (int i = 0; i < 20; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
```



**App.java**

```java
public class App {

    public static void main(String[] args) {

        Resource r1 = new Resource();
        Resource r2 = new Resource();
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(() -> {
            r1.func();
        });
        pool.execute(() -> {
            r2.func();
        });

        pool.shutdown();

    }
}
```



**Output**

```
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 
```



#### 1.5.3 锁为 instance

**Resource.java**

```java
public class Resource {

    public synchronized void func() {
        for (int i = 0; i < 20; i++) {
            System.out.print(i + " ");
        }
    }
}
```



**Resource.java**

```java
public class Resource {

    public void func() {
        synchronized (this) {
            for (int i = 0; i < 20; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
```



**App.java**

```java
public class App {

    public static void main(String[] args) {

        Resource r1 = new Resource();
        Resource r2 = new Resource();
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(() -> {
            r1.func();
        });
        pool.execute(() -> {
            r2.func();
        });

        pool.shutdown();

    }
}
```



**Output**

```
0 1 2 3 4 5 6 0 7 8 9 10 11 12 13 14 1 2 3 4 5 15 6 7 16 17 18 19 8 9 10 11 12 13 14 15 16 17 18 19 
```



#### 1.5.4 synchronized 内存语义

**CPU**

<div align="center"> <img src="cpu-structure.png" width="60%"/> </div><br>



**Three level cache**

<div align="center"> <img src="3-level-cache.png" width="70%"/> </div><br>





### 1.6 线程间协作

#### 1.6.1 Thread.join()

**Thread.java**

```java
public final void join() throws InterruptedException {
    join(0);
}
```

**App.java**

```java
public class App {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " started");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }, "t1");

        t1.start();
//        t1.join();

        System.out.println(Thread.currentThread().getName() + " exited");

    }
}
```



**Output**

```
main started
main exited
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
```



**App.java**

```java
public class App {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + " started");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }, "t1");

        t1.start();
        t1.join();

        System.out.println(Thread.currentThread().getName() + " exited");

    }
}
```



**Output**

```
main started
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 
main exited
```





#### 1.6.2 Object.wait()  & Object.notify()

**使用方法**

```java
synchronized (obj) {
         while (<condition does not hold>)
             obj.wait();
         ... // Perform action appropriate to condition
     }
```



**Example**

<div align="center"> <img src="BlockingQueue.png" width="70%"/> </div><br>

**BlockingQueue.java**

```java
/**
 * A demo of Object.wait() & Object.notify()
 *
 * @param <E>
 */
public class BlockingQueue<E> {

    private int capacity;
    private Deque<E> deque = new LinkedList<>();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(E element) throws InterruptedException {

        while (deque.size() == capacity) {
            wait();
        }

        deque.add(element);
        notifyAll();

    }

    public synchronized E get() throws InterruptedException {

        while (deque.isEmpty()) {
            wait();
        }

        E res = deque.remove();
        notifyAll();
        return res;

    }
}
```

**App.java**

```java
public class App {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Object> blockingQueue = new BlockingQueue<>(10);
        ExecutorService pool = Executors.newCachedThreadPool();

        // Producer
        for (int i = 0; i < 5; i++) {
            pool.execute(() -> {
                try {
                    blockingQueue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Consumer
        for (int i = 0; i < 8; i++) {
            pool.execute(() -> {
                try {
                    blockingQueue.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();

    }
}
```



**思考**

- deque 的容量
- 生产者数量
- 消费者数量

当三者何种关系时，会造成程序不退出？



## 2. 锁















## References

- 翟陆续, 薛宾田. Java并发编程之美 [M]. 电子工业出版社, 2018.
- 方腾飞, 魏鹏, 程晓明. Java并发编程的艺术 [M]. 机械工业出版社, 2019.
- [CyC2018](https://github.com/CyC2018/CS-Notes/blob/master/notes/Java%20%E5%B9%B6%E5%8F%91.md)
- [RedSpider1 / concurrent](https://github.com/RedSpider1/concurrent)
- [A Guide to the Java ExecutorService](https://www.baeldung.com/java-executor-service-tutorial)
- [wait and notify() Methods in Java](https://www.baeldung.com/java-wait-notify)
- [A simple scenario using wait() and notify() in java](https://stackoverflow.com/questions/2536692/a-simple-scenario-using-wait-and-notify-in-java)
