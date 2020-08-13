# 概述



Table of Contents
-----------------

* [1. 什么是设计模式？](#1-什么是设计模式)
* [2. 为什么要使用设计模式？](#2-为什么要使用设计模式)
* [2. 单一职责](#2-单一职责)
* [2. 接口隔离](#2-接口隔离)
* [4. 依赖倒转](#4-依赖倒转)
* [5. 里氏替换](#5-里氏替换)
* [6. 开闭 OCP](#6-开闭-ocp)
* [7. 迪米特](#7-迪米特)
* [8. 合成复用](#8-合成复用)
* [9. 设计模式修炼之道](#9-设计模式修炼之道)







## 1. 什么是设计模式？

> 设计模式，即Design Patterns，是指在软件设计中，被反复使用的一种代码设计经验。使用设计模式的目的是为了可重用代码，提高代码的可扩展性和可维护性。
>
> 设计模式这个术语是上个世纪90年代由Erich Gamma、Richard Helm、Raplh Johnson和Jonhn Vlissides四个人总结提炼出来的，并且写了一本[Design Patterns](https://en.wikipedia.org/wiki/Design_Patterns)的书。这四人也被称为四人帮（GoF）。



## 2. 为什么要使用设计模式？

- 代码重用性：相同功能的代码，不需要多次编写
- 代码可读性：编程规范性，便于其他程序员阅读
- 代码可扩展性：当增加新的功能后，原有功能不受影响







## 2. 单一职责

- 一个类只负责一项职责
- 提高类的可读性
- 降低变更引起的风险



## 2. 接口隔离

类不应该依赖他不需要对接口，接口尽量小颗粒划分



**Person.java**

```java
public interface Person {

    void exam();

    void teach();

}
```



**Student.java**

```java
public class Student implements Person {
    @Override
    public void exam() {
        System.out.println("Student here!");
        System.out.println("I love taking exams!");
    }

    @Override
    public void teach() {

    }
}
```



**Teacher.java**

```java
public class Teacher implements Person {
    @Override
    public void exam() {

    }

    @Override
    public void teach() {
        System.out.println("Teacher here!");
        System.out.println("I love teaching!");
    }
}
```

`Teacher` 和 `Student` 类都实现了 `Person` 接口，但是：

- `teacher` 只需要实现 `teach()` 方法
- `student` 只需要实现 `exam()` 方法



为了满足接口隔离原则

将原有的 `Person` 接口拆分成更细的粒度



**Person_stu.java**

```java
public interface Person_stu {
    void exam();
}
```

**Person_tea.java**

```java
public interface Person_tea {
    void teach();
}
```

**Person_stu.java**

```java
public class Student implements Person_stu {

    @Override
    public void exam() {
        System.out.println("Student here!");
        System.out.println("I love taking exams");
    }

}
```

**Person_tea.java**

```java
public class Teacher implements Person_tea {

    @Override
    public void teach() {
        System.out.println("Teacher here!");
        System.out.println("I love teaching");
    }

}
```





## 4. 依赖倒转















## 5. 里氏替换



















## 6. 开闭 OCP















## 7. 迪米特



















## 8. 合成复用













## 9. 设计模式修炼之道

1. 刚开始学习编程不久，听过什么是设计模式
2. 有长时间的编程经验，其中用到了设计模式，但自己不知道
3. 学过了设计模式，使用中，发现了一些新的模式挺好用的
4. 阅读了很多源码和框架，在看别人的设计模式，能够体会设计模式的精妙和带来的好处
5. 编写代码的过程中不知不觉写出了设计模式