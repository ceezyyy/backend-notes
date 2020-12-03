# JVM

Table of Contents
-----------------

* [1. JVM 的位置](#1-jvm-的位置)
* [2. JVM 的体系结构](#2-jvm-的体系结构)
* [3. 类加载器](#3-类加载器)
* [4. 双亲委派](#4-双亲委派)
* [5. 沙箱安全](#5-沙箱安全)
* [6. Native](#6-native)
* [7. PC 寄存器](#7-pc-寄存器)
* [8. 方法区](#8-方法区)
* [9. 栈](#9-栈)
* [10. 三种 JVM](#10-三种-jvm)
* [11. 堆](#11-堆)
* [12. 新生区 老年区](#12-新生区-老年区)
* [13. 永久区](#13-永久区)
* [14. 堆内存调优](#14-堆内存调优)
* [15. GC](#15-gc)
* [16. JMM](#16-jmm)
* [参考链接](#参考链接)

## 1. JVM 的位置

<div align="center"> <img src="image-20201202162828154.png" width="30%"/> </div><br>



 



## 2. JVM 的体系结构

<div align="center"> <img src="image-20201202164425125.png" width="60%"/> </div><br>





## 3. 类加载器

**作用:** 将类的字节码文件从 `JVM` 外部加载到内存中

<div align="center"> <img src="image-20201202175525446.png" width="60%"/> </div><br>

**Car.java**


```java
≥public class Car {

    private double price;

    public static void main(String[] args) {

        Car maybach = new Car();
        Car bentley = new Car();
        Car porsche = new Car();

        System.out.println(maybach.hashCode());  // 621009875
        System.out.println(bentley.hashCode());  // 1265094477
        System.out.println(porsche.hashCode());  // 2125039532

        Class<? extends Car> maybachClass = maybach.getClass();
        Class<? extends Car> bentleyClass = bentley.getClass();
        Class<? extends Car> porscheClass = porsche.getClass();

        System.out.println(maybachClass.hashCode());  // 856419764
        System.out.println(bentleyClass.hashCode());  // 856419764
        System.out.println(porscheClass.hashCode());  // 856419764

    }
}
```



## 4. 双亲委派

> 什么是 jar 包?
>
> jar 包实际上是 zip 压缩包，别人写好的类封装到一个 jar 包中，你在项目中可以引用该 jar 包，即直接使用他人已封装好的类（包括方法 / 属性）

<div align="center"> <img src="image-20201203081435192.png" width="30%"/> </div><br>

其中，`rt.jar` 是 `Java` 基础类库

<div align="center"> <img src="image-20201203081618129.png" width="30%"/> </div><br>

看一个 `demo` 来理解 `JVM` 中何为双亲委派









## 5. 沙箱安全

## 6. Native

## 7. PC 寄存器

## 8. 方法区

## 9. 栈

## 10. 三种 JVM

## 11. 堆

## 12. 新生区 老年区

## 13. 永久区

## 14. 堆内存调优

## 15. GC

## 16. JMM



## 参考链接

- [【狂神说Java】JVM快速入门篇](https://www.bilibili.com/video/BV1iJ411d7jS)