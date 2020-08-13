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
* [参考教程](#参考教程)





## 1. 什么是设计模式？

> 设计模式，即Design Patterns，是指在软件设计中，被反复使用的一种代码设计经验。使用设计模式的目的是为了可重用代码，提高代码的可扩展性和可维护性。
>
> 设计模式这个术语是上个世纪90年代由Erich Gamma、Richard Helm、Raplh Johnson和Jonhn Vlissides四个人总结提炼出来的，并且写了一本[Design Patterns](https://en.wikipedia.org/wiki/Design_Patterns)的书。这四人也被称为四人帮（GoF）。



## 2. 为什么要使用设计模式？

- 代码重用性：相同功能的代码，不需要多次编写
- 代码可读性：编程规范性，便于其他程序员阅读
- 代码可扩展性：当增加新的功能后，原有功能不受影响







## 2. 单一职责

> 在[面向对象编程](https://zh.wikipedia.org/wiki/面向对象编程)领域中，**单一功能原则**（Single responsibility principle）规定每个类都应该有一个单一的功能，并且该功能应该由这个类完全封装起来。所有它的（这个类的）服务都应该严密的和该功能平行（功能平行，意味着没有依赖）。
>
> 这个术语由[罗伯特·C·马丁](https://zh.wikipedia.org/w/index.php?title=罗伯特·C·马丁&action=edit&redlink=1)（Robert Cecil Martin）在他的《敏捷软件开发，原则，模式和实践》一书中的一篇名为〈面向对象设计原则〉的文章中给出。 [[1\]](https://zh.wikipedia.org/wiki/单一功能原则#cite_note-1) 马丁表述该原则是基于的《结构化分析和系统规格》[[2\]](https://zh.wikipedia.org/wiki/单一功能原则#cite_note-2)一书中的[内聚原则](https://zh.wikipedia.org/wiki/内聚原则)（Cohesion）上。
>
> 马丁把功能（职责）定义为：“改变的原因”，并且总结出一个类或者模块应该有且只有一个改变的原因。一个具体的例子就是，想象有一个用于编辑和打印报表的模块。这样的一个模块存在两个改变的原因。第一，报表的内容可以改变（编辑）。第二，报表的格式可以改变（打印）。这两方面会的改变因为完全不同的起因而发生：一个是本质的修改，一个是表面的修改。单一功能原则认为这两方面的问题事实上是两个分离的功能，因此他们应该分离在不同的类或者模块里。把有不同的改变原因的事物耦合在一起的设计是糟糕的。
>
> 保持一个类专注于单一功能点上的一个重要的原因是，它会使得类更加的健壮。继续上面的例子，如果有一个对于报表编辑流程的修改，那么将存在极大的危险性，因为假设这两个功能存在于同一个类中，修改报表的编辑流程会导致公共状态或者依赖关系的改变，打印功能的代码会因此不工作。

一个类只负责一项职责





## 2. 接口隔离

> **接口隔离原则**（英语：interface-segregation principles， 缩写：ISP）指明客户（client）不应被迫使用对其而言无用的方法或功能。[[1\]](https://zh.wikipedia.org/wiki/接口隔离原则#cite_note-ASD-1)接口隔离原则(ISP)拆分非常庞大臃肿的接口成为更小的和更具体的接口，这样客户将会只需要知道他们感兴趣的方法。这种缩小的接口也被称为**角色接口**（role interfaces）。[[2\]](https://zh.wikipedia.org/wiki/接口隔离原则#cite_note-RoleInterface-2)接口隔离原则(ISP)的目的是系统解开耦合，从而容易重构，更改和重新部署。接口隔离原则是在[SOLID (面向对象设计)](https://zh.wikipedia.org/wiki/SOLID_(面向对象设计))中五个[面向对象设计](https://zh.wikipedia.org/wiki/面向对象设计)(OOD)的原则之一，类似于在[GRASP (面向对象设计)](https://zh.wikipedia.org/w/index.php?title=GRASP_(面向对象设计)&action=edit&redlink=1)中的高[内聚性](https://zh.wikipedia.org/wiki/內聚性_(計算機科學))。[[3\]](https://zh.wikipedia.org/wiki/接口隔离原则#cite_note-CB-3)



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

> 在[面向对象编程](https://zh.wikipedia.org/wiki/面向对象编程)领域中，**依赖反转原则**（Dependency inversion principle，DIP）是指一种特定的[解耦](https://zh.wikipedia.org/wiki/耦合性_(計算機科學))（传统的[依赖](https://zh.wikipedia.org/wiki/耦合性_(計算機科學))关系创建在高层次上，而具体的策略设置则应用在低层次的模块上）形式，使得高层次的模块不依赖于低层次的模块的实现细节，依赖关系被颠倒（反转），从而使得低层次模块依赖于高层次模块的需求抽象。
>
> 该原则规定：
>
> 1. 高层次的模块不应该依赖于低层次的模块，两者都应该依赖于[抽象接口](https://zh.wikipedia.org/wiki/抽象化_(計算機科學))。
> 2. 抽象接口不应该依赖于具体实现。而具体实现则应该依赖于抽象接口。
>
> 该原则颠倒了一部分人对于面向对象设计的认识方式。如高层次和低层次对象都应该依赖于相同的抽象接口。[[1\]](https://zh.wikipedia.org/wiki/依赖反转原则#cite_note-1)



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

> 在[面向对象的程序设计](https://zh.wikipedia.org/wiki/面向对象的程序设计)中，**里氏替换原则**（Liskov Substitution principle）是对[子类型](https://zh.wikipedia.org/wiki/子类型)的特别定义。它由[芭芭拉·利斯科夫](https://zh.wikipedia.org/wiki/芭芭拉·利斯科夫)（Barbara Liskov）在1987年在一次会议上名为“数据的抽象与层次”的演说中首先提出。[[1\]](https://zh.wikipedia.org/wiki/里氏替换原则#cite_note-FamilyValues-1)
>
> 里氏替换原则的内容可以描述为： “派生类（子类）对象可以在程序中代替其基类（超类）对象。” 以上内容并非利斯科夫的原文，而是译自[罗伯特·马丁](https://zh.wikipedia.org/wiki/罗伯特·马丁)（Robert Martin）对原文的解读。其原文为：
>
> 
>
> [芭芭拉·利斯科夫](https://zh.wikipedia.org/wiki/芭芭拉·利斯科夫)与[周以真](https://zh.wikipedia.org/wiki/周以真)（Jeannette Wing）在1994年发表论文并提出以上的**Liskov代换原则**。



子类可以扩展父类的功能，但不能改变父类原有的功能





## 6. 开闭

> 在[面向对象编程](https://zh.wikipedia.org/wiki/面向对象编程)领域中，**开闭原则**规定“*软件中的对象（类，模块，函数等等）应该对于扩展是开放的，但是对于修改是封闭的*”[[1\]](https://zh.wikipedia.org/wiki/开闭原则#cite_note-1)，这意味着一个实体是允许在不改变它的[源代码](https://zh.wikipedia.org/wiki/源代码)的前提下变更它的行为。该特性在产品化的环境中是特别有价值的，在这种环境中，改变源代码需要[代码审查](https://zh.wikipedia.org/wiki/代码审查)，[单元测试](https://zh.wikipedia.org/wiki/单元测试)以及诸如此类的用以确保产品使用质量的过程。遵循这种原则的代码在扩展时并不发生改变，因此无需上述的过程。
>
> *开闭原则*的命名被应用在两种方式上。这两种方式都使用了[继承](https://zh.wikipedia.org/wiki/继承_(计算机科学))来解决明显的困境，但是它们的目的，技术以及结果是不同的。



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

> **得墨忒耳定律**（**Law of Demeter**，缩写**LoD**）亦被称作“最少知识原则（Principle of Least Knowledge）”，是一种[软件](https://zh.wikipedia.org/wiki/软件)开发的设计指导原则，特别是[面向对象的程序设计](https://zh.wikipedia.org/wiki/面向对象的程序设计)。得墨忒耳定律是[松耦合](https://zh.wikipedia.org/wiki/松耦合)的一种具体案例。该原则是[美国东北大学](https://zh.wikipedia.org/wiki/东北大学_(美国))在1987年末在发明的，可以简单地以下面任一种方式总结:
>
> 1. 每个单元对于其他的单元只能拥有有限的知识：只是与当前单元紧密联系的单元；
> 2. 每个单元只能和它的朋友交谈：不能和陌生单元交谈；
> 3. 只和自己直接的朋友交谈。
>
> 这个原理的名称来源于[希腊神话](https://zh.wikipedia.org/wiki/希腊神话)中的[农业](https://zh.wikipedia.org/wiki/农业)女神，孤独的[得墨忒耳](https://zh.wikipedia.org/wiki/得墨忒耳)。
>
> 很多面向对象程序设计语言用"."表示对象的域的解析算符，因此得墨忒耳定律可以简单地陈述为“只使用一个.算符”。因此，a.b.Method()违反了此定律，而a.Method()不违反此定律。一个简单例子是，人可以命令一条狗行走（walk），但是不应该直接指挥狗的腿行走，应该由狗去指挥控制它的腿如何行走。



















## 8. 合成复用













## 9. 设计模式修炼之道

1. 刚开始学习编程不久，听过什么是设计模式
2. 有长时间的编程经验，其中用到了设计模式，但自己不知道
3. 学过了设计模式，使用中，发现了一些新的模式挺好用的
4. 阅读了很多源码和框架，在看别人的设计模式，能够体会设计模式的精妙和带来的好处
5. 编写代码的过程中不知不觉写出了设计模式







## 参考教程

- [万字总结之设计模式七大原则](https://juejin.im/post/6844904065806106632)

