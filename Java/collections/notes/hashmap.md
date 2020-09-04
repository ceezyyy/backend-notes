# HashMap 

Table of Contents
-----------------

* [1. 什么是 HashTable?](#1-什么是-hashtable)
* [2. 手撕源码](#2-手撕源码)
   * [2.1 成员变量](#21-成员变量)
   * [2.2 构造方法](#22-构造方法)
* [参考链接](#参考链接)



## 1. 什么是 HashTable?

维基百科

> A hash table (hash map) is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A hash table uses a hash function to compute an index, also called a hash code, into an array of buckets or slots, from which the desired value can be found

举个例子





<div align="center"> <img src="pl.jpg" width="70%"/> </div><br>

假设你开车去一家超市买东西，买完东西后，不记得车停哪了

如何快速地找到自己停车的位置呢？

1.  按顺序查找，时间复杂度 `O(n)`
2. 二分查找，假设停车位的顺序是按照车牌号的顺序，时间复杂度 `O(logn)`
3. 按索引查找，假设每个车牌都对应一个车位，时间复杂度 `O(1)`



虽然时间提上来了，但是空间消耗过大，有没有一种方法 / 数据结构，能有着极快的查找效率且又没有过大的空间消耗呢？



**HashTable** 孕育而生



`Hashtable` 通过 `hash` 算法，将你的车牌转换为一串特定的数字（取模）

你的名字作为 `key`，你的车停放的位置作为 `value`

根据 `key` 查找停车的位置，时间复杂度 `O(1)`



但是，任何事物都有利弊，`hash` 可能会把不同的数据映射到同一个点上，俗称 **哈希碰撞 / 哈希冲突**



如何解决这个问题？

- 临时加立体车库，将冲突的车辆存放到立体车库
- 对于冲突的车辆，使用另一套 `hash` 算法 ，重新安排位置
- 新增一个小车库，放置冲突的车辆





## 2. 手撕源码

在 `JDK 1.8` 之前，`HashMap` 采用 数组 + 链表组成

在 `JDK 1.8` 之后，`HashMap` 采用 数组 + 链表 + 红黑树组成

本文采用 `JDK1.8` 版本

<div align="center"> <img src="image-20200902181253766.png" width="60%"/> </div><br>



### 2.1 成员变量

 **HashMap.java**

```java
public class HashMap<K,V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {

    private static final long serialVersionUID = 362498820763181265L;

    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * The bin count threshold for using a tree rather than list for a
     * bin.  Bins are converted to trees when adding an element to a
     * bin with at least this many nodes. The value must be greater
     * than 2 and should be at least 8 to mesh with assumptions in
     * tree removal about conversion back to plain bins upon
     * shrinkage.
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * The bin count threshold for untreeifying a (split) bin during a
     * resize operation. Should be less than TREEIFY_THRESHOLD, and at
     * most 6 to mesh with shrinkage detection under removal.
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * The smallest table capacity for which bins may be treeified.
     * (Otherwise the table is resized if too many nodes in a bin.)
     * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
     * between resizing and treeification thresholds.
     */
    static final int MIN_TREEIFY_CAPACITY = 64;
```

<div align="center"> <img src="HashMap_base.png" width="80%"/> </div><br>





### 2.2 构造方法




























## 参考链接

- [What is a HashTable Data Structure - Introduction to Hash Tables , Part 0](https://www.youtube.com/watch?v=MfhjkfocRR0)
-  [What is Hashing? Hash Functions Explained Simply](https://www.youtube.com/watch?v=2BldESGZKB8)
-  [程序员常说的「哈希表」是个什么鬼？](http://www.woshipm.com/pmd/805326.html)
-  [什么是 hash？-知乎](https://www.zhihu.com/question/26762707)

