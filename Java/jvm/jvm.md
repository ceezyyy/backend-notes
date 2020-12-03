# JVM

Table of Contents
-----------------

   * [JVM](#jvm)
      * [Table of Contents](#table-of-contents)
      * [1. JVM 的位置](#1-jvm-的位置)
      * [2. JVM 的体系结构](#2-jvm-的体系结构)
      * [3. 类加载器](#3-类加载器)
      * [4. 双亲委派](#4-双亲委派)
      * [5. Native](#5-native)
      * [6. PC 寄存器](#6-pc-寄存器)
      * [7. 方法区](#7-方法区)
      * [8. 栈](#8-栈)
      * [9. 三种 JVM](#9-三种-jvm)
      * [10. 堆](#10-堆)
      * [11. 新生区 老年区](#11-新生区-老年区)
      * [12. 永久区](#12-永久区)
      * [13. 堆内存调优](#13-堆内存调优)
      * [14. GC](#14-gc)
      * [15. JMM](#15-jmm)
      * [参考资料](#参考资料)



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

进入正题，

`JVM` 提供了三种类加载器：

- Bootstrap 加载器：主要加载 `JVM` 自身需要的类，负责加载 `<JAVA_HOME>/lib` 路径下的核心类库
- Extension 加载器：负责加载 `<JAVA_HOME>/lib/ext` 下的类库
- Application 加载器：加载 `classpath` 下的类库



**什么是双亲委派机制？**

> The Java platform uses a delegation model for loading classes. **The basic idea is that every class loader has a "parent" class loader.** When loading a class, a class loader first "delegates" the search for the class to its parent class loader before attempting to find the class itself.

即当 `class loader` 收到 “需要加载类” 的命令后，先向上找父类加载器（依次递归），若父类能找到就加载且成功返回，反之自己加载

<div align="center"> <img src="image-20201203093747163.png" width="50%"/> </div><br>



**双亲委派机制的作用是什么？**

保证安全

例如，`java.lang.String` 这个类，无论哪个 `class loader` 加载时**最终**都需要到 `Bootstrap` 加载器去找这个类，因此保证类的唯一性

假若没有双亲委派机制，开发者在 `classpath` 下自行写了 `java.lang.String` 这个类，那么系统将混乱（不知道应该加载哪一个）



（源码部分删减）

**ClassLoader.java**

```java
protected Class<?> loadClass(String name, boolean resolve)
    throws ClassNotFoundException
{
    synchronized (getClassLoadingLock(name)) {
        // First, check if the class has already been loaded
        Class<?> c = findLoadedClass(name);
        if (c == null) {
            try {
                if (parent != null) {
                    // 向上委派
                    c = parent.loadClass(name, false);
                } else {
                    // 直接到 Bootstrap 类加载器去找
                    c = findBootstrapClassOrNull(name);
                }
            } catch (ClassNotFoundException e) {
                // ClassNotFoundException thrown if class not found
                // from the non-null parent class loader
            }
          
            // 若还是找不到 则在 Application 类加载器找
            if (c == null) {
                // If still not found, then invoke findClass in order
                // to find the class.
                c = findClass(name);
            }
        }
        return c;
    }
}


protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }
```





P.S: 英文原文为 `parent delegation model`，国内习惯于叫双亲



## 5. Native 

> A *native* method is a Java method (either an instance method or a class method) whose implementation is also written in another programming language such as C/C++.
>
> Moreover, a method marked as *native* cannot have a body and should end with a semicolon



当调用有 `native` 关键词修饰的方法时：

会入 `native method stack`（本地方法栈），调用本地方法接口



## 6. PC 寄存器

## 7. 方法区

## 8. 栈

## 9. 三种 JVM

## 10. 堆

## 11. 新生区 老年区

## 12. 永久区

## 13. 堆内存调优

## 14. GC

## 15. JMM



## 参考资料

- [【狂神说Java】JVM快速入门篇](https://www.bilibili.com/video/BV1iJ411d7jS)
- [深入理解Java类加载器(ClassLoader)](https://blog.csdn.net/javazejian/article/details/73413292)