# HashMap 

Table of Contents
-----------------

* [1. 什么是 hash?](#1-什么是-hash)
* [2. Hash 的特点](#2-hash-的特点)
* [3. 什么是 HashTable?](#3-什么是-hashtable)
* [4. 原理](#4-原理)
* [参考链接](#参考链接)


## 1. 什么是 hash?

维基百科

> 散列表（Hash table，也叫哈希表），是根据键（Key）而直接访问在内存储存位置的数据结构。也就是说，它通过计算一个关于键值的函数，将所需查询的数据映射到表中一个位置来访问记录，这加快了查找速度。这个映射函数称做散列函数，存放记录的数组称做散列表。

百度百科

> Hash算法可以将一个数据转换为一个标志，这个标志和源数据的每一个字节都有十分紧密的关系。Hash算法还具有一个特点，就是很难找到逆向规律。
>
> Hash算法是一个广义的算法，也可以认为是一种思想，使用Hash算法可以提高存储空间的利用率，可以提高数据的查询效率，也可以做[数字签名](https://baike.baidu.com/item/数字签名/212550)来保障数据传递的安全性。所以Hash算法被广泛地应用在互联网应用中。
>
> Hash算法也被称为散列算法，Hash算法虽然被称为算法，但实际上它更像是一种思想。Hash算法没有一个固定的公式，只要符合散列思想的算法都可以被称为是Hash算法。 



`Hash` 的原理就是把任意长度的输入，通过 `Hash` 算法变成固定长度的输出，这个映射的规则就是对应的 `Hash` 算法。而原始数据映射后的二进制串就是哈希值。

```shell
echo md5("这是一个测试文案");
// 输出结果：2124968af757ed51e71e6abeac04f98d
```



## 2. Hash 的特点

- 从 `hash` 值不可以反向推导出原始数据
- 输入数据的微小变化会得到完全不同的 `hash` 值，相同的数据会得到相同的值
- `hash` 算法执行效率高，长文本也能快速计算出 `hash` 值
- `hash` 算法的冲突概率要小



## 3. 什么是 HashTable?

维基百科

> A hash table (hash map) is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A hash table uses a hash function to compute an index, also called a hash code, into an array of buckets or slots, from which the desired value can be found

举个例子





<div align="center"> <img src="pl.jpg" width="70%"/> </div><br>






## 4. 原理

<div align="center"> <img src="image-20200902181253766.png" width="70%"/> </div><br>




## 参考链接

- [What is a HashTable Data Structure - Introduction to Hash Tables , Part 0](https://www.youtube.com/watch?v=MfhjkfocRR0)
-  [What is Hashing? Hash Functions Explained Simply](https://www.youtube.com/watch?v=2BldESGZKB8)
-  [程序员常说的「哈希表」是个什么鬼？](http://www.woshipm.com/pmd/805326.html)
-  [什么是 hash？-知乎](https://www.zhihu.com/question/26762707)

