# JVM 概述

Table of Contents
-----------------

* [1. 什么是 JVM ?](#1-什么是-jvm-)
* [2. 为什么要学 JVM ?](#2-为什么要学-jvm-)
* [3. JVM 体系结构](#3-jvm-体系结构)
   * [ClassLoader](#classloader)
   * [Method Area](#method-area)
   * [Heap](#heap)
   * [VM Stack](#vm-stack)
   * [程序计数器](#程序计数器)
* [4. Java 文件执行流程](#4-java-文件执行流程)


## 1. 什么是 JVM ?

维基百科

> **Java虚拟机**（英语：Java Virtual Machine，缩写为JVM），一种能够运行[Java bytecode](https://zh.wikipedia.org/wiki/Java_bytecode)的[虚拟机](https://zh.wikipedia.org/wiki/虛擬機器)，以[堆栈结构机器](https://zh.wikipedia.org/wiki/堆疊結構機器)来进行实做。最早由[Sun微系统](https://zh.wikipedia.org/wiki/昇陽電腦)所研发并实现第一个实现版本，是[Java平台](https://zh.wikipedia.org/wiki/Java平臺)的一部分，能够运行以[Java](https://zh.wikipedia.org/wiki/Java)语言写作的[软件](https://zh.wikipedia.org/wiki/軟體)[程序](https://zh.wikipedia.org/wiki/程式)。
>
> Java虚拟机有自己完善的[硬体](https://zh.wikipedia.org/wiki/硬体)架构，如[处理器](https://zh.wikipedia.org/wiki/处理器)、[堆栈](https://zh.wikipedia.org/wiki/堆栈)、[寄存器](https://zh.wikipedia.org/wiki/寄存器)等，还具有相应的[指令](https://zh.wikipedia.org/wiki/指令)系统。JVM屏蔽了与具体[操作系统](https://zh.wikipedia.org/wiki/操作系统)平台相关的信息，使得Java[程序](https://zh.wikipedia.org/wiki/程序)只需生成在Java虚拟机上运行的目标代码（[字节码](https://zh.wikipedia.org/wiki/字节码)），就可以在多种平台上不加修改地运行。通过对中央处理器（[CPU](https://zh.wikipedia.org/wiki/CPU)）所执行的软件实现，实现能执行[编译](https://zh.wikipedia.org/wiki/编译)过的Java程序码（[Applet](https://zh.wikipedia.org/wiki/Applet)与应用程序）。



`JVM` 类似于一台小电脑运行在 `macOS` / `Linux` / `Win` 操作系统，直接与操作系统进行交互，而不与硬件打交道



<div align="center"> <img src="image-20200915091446733.png" width="15%"/> </div><br>

## 2. 为什么要学 JVM ?

- 面试
- 中高级程序员必备技能（项目管理 / 调优）
- 极客精神（垃圾回收 / JIT / 底层）



## 3. JVM 体系结构

先从全览看一下 `JVM` 的体系结构

<div align="center"> <img src="jvm.png" width="90%"/> </div><br>

我们使用 `IDEA` 编写的是 `.java` 文件，本质上是一个文本（包含着英文符号以及缩进）

`JVM` 并不认识，故 `.java` 需要进行编译，转换为二进制的 `.class` 文件



### ClassLoader

`ClassLoader` 就好比一个搬运工，将所有的 `.class` 文件搬运到 `JVM` 中

<div align="center"> <img src="image-20200915095933016.png" width="60%"/> </div><br>



### Method Area

用于存放类似于元数据信息方面的数据，比如类信息，常量，静态变量，编译后的代码等...

`ClassLoader` 将 `.class` 文件搬过来后先丢到这一块上

线程共享





### Heap

主要放了一些存储的数据，比如对象实例，数组...

线程共享







### VM Stack

代码的运行空间，每个方法都会放到栈里面执行

线程独享





### 程序计数器

主要就是完成一个加载工作，类似于一个指针一样的，指向下一行我们需要执行的代码

线程独享





## 4. Java 文件执行流程

```java
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void sayHi() {
        System.out.println("My name is " + name);
    }
}


public class App {
    public static void main(String[] args) {
        Person person = new Person("ceezyyy");
        person.sayHi();
    }
}
```

执行 `main` 方法流程如下：

1. 编译好的 `App.java` 得到 `App.class`，执行 `App.class`，系统会启动一个 `JVM` 进程，在 `classpath` 中找到 `App.class` 通过 `ClassLoader` 将 `App` 的类信息加载到 `Method Area` 中，这个过程称为类的加载
2. `JVM` 找到 `App` 的主程序入口，执行 `main` 方法
3. `main` 方法第一条语句为 `Person person = new Person("ceezyyy");`，即让 `JVM` 创建一个 `Person` 对象，但这时 `Method Area` 是没有 `Person` 类的信息的，所以 `JVM` 马上加载 `Person` 类，相关信息放到 `Method Area` 中
4. 加载完后，`JVM` 在堆中为 `Person` 实例分配内存，并调用构造方法初始化，这个 `Person` 实例持有指向 `Method Area` 中 `Person` 类的类型信息的引用
5. 执行 `person.sayHi();` 语句时，`JVM` 根据 `person` 的引用找到 `person` 对象，然后根据 `person` 对象持有的引用定位到 `Method Area` 中 `student` 类的类型信息的方法表，获得 `sayHi()` 的字节码地址
6. 执行 `sayHi()` 方法

