# Java 基础

Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [1. Data types](#1-data-types)
   * [1.1 基本类型](#11-基本类型)
   * [1.2 Autoboxing &amp; Unboxing](#12-autoboxing--unboxing)
   * [1.3 IntegerCache](#13-integercache)
* [2. 运算](#2-运算)
* [3. keyword](#3-keyword)
* [4. Object](#4-object)
* [5. 继承](#5-继承)
* [6. 反射](#6-反射)
* [7. 异常](#7-异常)
* [8. 泛型](#8-泛型)
* [9. 注解](#9-注解)
* [References](#references)



## Brainstorming

<div align="center"> <img src="basic.svg" width="100%"/> </div><br>

## 1. Data types

### 1.1 基本类型

- 二进制中的一位称为 `bit`



### 1.2 Autoboxing & Unboxing

```java
public class Main {

    public static void main(String[] args) {
        // Autoboxing: Integer.valueOf(int)
        Integer x = 1;
        // Unboxing: x.intValue()
        int y = x;
        // x 会拆箱 实际上是两个 int 在比较
        System.out.println(x == y);  // true
    }
}
```



### 1.3 IntegerCache

```java
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}

// 下限为 -128
static final int low = -128;
// 上限默认 127, 可通过 JVM 调参
static final int high;
```



## 2. 运算



## 3. keyword



## 4. Object



## 5. 继承



## 6. 反射



## 7. 异常



## 8. 泛型





## 9. 注解





## References

- [CS-Notes](https://github.com/CyC2018/CS-Notes/blob/master/notes/Java%20%E5%9F%BA%E7%A1%80.md)