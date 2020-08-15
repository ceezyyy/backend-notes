# 单例模式（创建型）

Table of Contents
-----------------

* [1. 什么是单例？](#1-什么是单例)
* [2. 为什么使用单例？](#2-为什么使用单例)
* [3. 如何使用单例？](#3-如何使用单例)
* [4. 优缺点](#4-优缺点)
* [5. 使用场景](#5-使用场景)
* [6. Demo](#6-demo)
* [7. 多线程场景下的单例](#7-多线程场景下的单例)
* [参考资料](#参考资料)





## 1. 什么是单例？

保证一个类仅有一个实例，并提供一个访问它的全局访问点。

单例模式也称作单件模式



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

暂缺



## 6. Demo

```java
public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        
        // lazy loading
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}
```

**关键：**

- 私有构造器
- 一个静态方法
- 一个静态变量



## 7. 多线程场景下的单例

暂缺










## 参考资料

- [单例模式](https://www.runoob.com/design-pattern/singleton-pattern.html)