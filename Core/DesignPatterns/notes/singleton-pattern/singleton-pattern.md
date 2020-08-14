# 单例模式（创建型）

Table of Contents
-----------------

* [1. 什么是单例？](#1-什么是单例)
* [2. 为什么使用单例？](#2-为什么使用单例)
* [3. 如何使用单例？](#3-如何使用单例)
* [4. 优缺点](#4-优缺点)
* [5. 使用场景](#5-使用场景)
* [6. 构建方式](#6-构建方式)
* [7. Demo](#7-demo)
* [8. 实现方式](#8-实现方式)
   * [8.1 懒汉式 线程不安全](#81-懒汉式-线程不安全)
   * [8.2 懒汉式 线程安全](#82-懒汉式-线程安全)
   * [8.3 饿汉式](#83-饿汉式)
   * [8.4 double-checked locking](#84-double-checked-locking)
   * [8.5 静态内部类](#85-静态内部类)
* [总结](#总结)
* [参考资料](#参考资料)



## 1. 什么是单例？

保证一个类仅有一个实例，并提供一个访问它的全局访问点。





## 2. 为什么使用单例？

解决一个全局使用的类频繁地创建与销毁浪费资源问题





## 3. 如何使用单例？

判断系统是否已经有这个单例，如果有则返回，如果没有则创建。





## 4. 优缺点

**优点：**

- 减少内存开销（尤其是频繁地创建和销毁实例）
- 避免对资源的多重占用（比如写文件）



**缺点：**

- 没有接口，无法继承
- 与单一原则冲突



## 5. 使用场景







## 6. 构建方式

- 懒汉方式：指全局的单例实例在第一次被使用时构建。
- 饿汉方式：指全局的单例实例在类装载时构建。



## 7. Demo

**SingleObject.java**

```java
public class SingletonObject {

    private static SingletonObject instance = new SingletonObject();

    private SingletonObject() {
    }

    public static SingletonObject getInstance() {
        return instance;
    }

    public void sayHello() {
        System.out.println("Hello World!");
    }

}
```

**SingletonPatternDemo.java**

```java
public class SingletonPatternDemo {
    
    public static void main(String[] args) {

        // SingletonObject singletonObject = new SingletonObject(); is illegal
        SingletonObject instance = SingletonObject.getInstance();
        instance.sayHello();

    }

}
```



<div align="center"> <img src="image-20200814150422537.png" width="30%"/> </div><br>





## 8. 实现方式

### 8.1 懒汉式 线程不安全

**Singleton.java**

```java
/**
 * 懒汉式 线程不安全
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
```

**缺点：**

不支持多线程



### 8.2 懒汉式 线程安全

```java
/**
 * 懒汉式 线程安全
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
```

**优点：**

第一次调用才初始化，避免内存浪费。

**缺点：**

必须加锁 synchronized 才能保证单例，但加锁会影响效率。



### 8.3 饿汉式

```java
/**
 * 饿汉式 线程安全
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
```

**优点：**

没有加锁，执行效率会提高。

**缺点：**

类加载时就初始化，浪费内存。

















### 8.4 double-checked locking



















### 8.5 静态内部类





















## 总结

一般情况下，不建议使用第 1 种和第 2 种懒汉方式，建议使用第 3 种饿汉方式。只有在要明确实现 lazy loading 效果时，才会使用第 5 种登记方式。如果涉及到反序列化创建对象时，可以尝试使用第 6 种枚举方式。如果有其他特殊的需求，可以考虑使用第 4 种双检锁方式。










## 参考资料

- [单例模式](https://www.runoob.com/design-pattern/singleton-pattern.html)