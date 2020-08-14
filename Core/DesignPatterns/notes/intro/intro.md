# 概述

Table of Contents
-----------------

* [1. 什么是设计模式？](#1-什么是设计模式)
* [2. 为什么要使用设计模式？](#2-为什么要使用设计模式)
* [2. 单一职责](#2-单一职责)
* [2. 接口隔离](#2-接口隔离)
* [4. 依赖倒转](#4-依赖倒转)
* [5. 里氏替换](#5-里氏替换)
* [6. 开闭](#6-开闭)
* [7. 迪米特](#7-迪米特)
* [8. 合成复用](#8-合成复用)
* [9. 设计模式修炼之道](#9-设计模式修炼之道)
* [Conclusion](#conclusion)
* [参考教程](#参考教程)





## 1. 什么是设计模式？

设计模式，即Design Patterns，是指在软件设计中，被反复使用的一种代码设计经验。使用设计模式的目的是为了可重用代码，提高代码的可扩展性和可维护性。



## 2. 为什么要使用设计模式？

- 代码重用性：相同功能的代码，不需要多次编写
- 代码可读性：编程规范性，便于其他程序员阅读
- 代码可扩展性：当增加新的功能后，原有功能不受影响







## 2. 单一职责



一个类只负责一项职责



### 







## 2. 接口隔离

> **接口隔离原则**（英语：interface-segregation principles， 缩写：ISP）指明客户（client）不应被迫使用对其而言无用的方法或功能。[[1\]](https://zh.wikipedia.org/wiki/接口隔离原则#cite_note-ASD-1)接口隔离原则(ISP)拆分非常庞大臃肿的接口成为更小的和更具体的接口，这样客户将会只需要知道他们感兴趣的方法。这种缩小的接口也被称为**角色接口**（role interfaces）



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

> 1. 高层次的模块不应该依赖于低层次的模块，两者都应该依赖于[抽象接口](https://zh.wikipedia.org/wiki/抽象化_(計算機科學))。
> 2. 抽象接口不应该依赖于具体实现。而具体实现则应该依赖于抽象接口。



要从底层往上思考，尽量抽象类和接口

即面向接口编程



**Apple.java**

```java
public class Apple {
    
}
```

**Peach.java**

```java
public class Peach {

}
```

自底向上思考，抽象出接口

**Fruit.java**

```java
public interface Fruit {

    void eat();

}
```

面向接口编程，修改 `apple` 和 `peach` 类：

**Apple.java**

```java
public class Apple implements Fruit {

    @Override
    public void eat() {
        System.out.println("Eating apple");
    }
}
```

**Fruit.java**

```java
public class Peach implements Fruit {

    @Override
    public void eat() {
        System.out.println("Eating peach");
    }
}
```





## 5. 里氏替换

**什么是里氏替换？**

子类可以扩展父类的功能，但不能改变父类原有的功能



**为什么有里氏替换？**

继承的缺点：当父类需要改动方法，那么需要考虑是否对继承其的子类造成影响

为了缓解这一影响，里氏替换原则诞生了



B 继承 A



<div align="center"> <img src="image-20200814100029968.png" width="50%"/> </div><br>

当 B 需要新增 / 重写很多方法或 A 也需要经常改动时

可以考虑增加一个 `base` 类，让 A 和 B 继承 `base`



<div align="center"> <img src="image-20200814100506277.png" width="50%"/> </div><br>











## 6. 开闭

**Transport.java**

```java
public interface Transport {
    void transport();
}
```

**Bus.java**

```java
public class Bus implements Transport {
    @Override
    public void transport() {
        System.out.println("Bus here!");
        System.out.println("Running on the road");
    }
}
```



此时，如果 `Bus` 有一个新功能：在天上飞（在实际开发过程中谁也无法保证没有新需求）

如果直接在 `Bus` 增加 `fly()` 方法，就违反了开闭原则，程序变得难以维护



需要新增一个类（对扩展开放）

**UniverseBus.java**

```java
public class UniverseBus extends Bus implements Transport {
    @Override
    public void transport() {
        System.out.println("Universe bus here!");
        System.out.println("Running on the road");
    }

    public void fly() {
        System.out.println("I can fly");
    }
}
```





## 7. 迪米特

> 1. 每个单元对于其他的单元只能拥有有限的知识：只是与当前单元紧密联系的单元；
> 2. 每个单元只能和它的朋友交谈：不能和陌生单元交谈；
> 3. 只和自己直接的朋友交谈。



















## 8. 合成复用













## 9. 设计模式修炼之道

1. 刚开始学习编程不久，听过什么是设计模式
2. 有长时间的编程经验，其中用到了设计模式，但自己不知道
3. 学过了设计模式，使用中，发现了一些新的模式挺好用的
4. 阅读了很多源码和框架，在看别人的设计模式，能够体会设计模式的精妙和带来的好处
5. 编写代码的过程中不知不觉写出了设计模式





## Conclusion

- 先去维基百科了解概念 消化成自己的东西再输出





## 参考教程

- [万字总结之设计模式七大原则](https://juejin.im/post/6844904065806106632)

