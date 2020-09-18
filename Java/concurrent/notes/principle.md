# 多线程原理

Table of Contents
-----------------

* [1. JMM](#1-jmm)
* [2. 内存可见性](#2-内存可见性)
* [3. 重排序](#3-重排序)
* [4. 顺序一致性](#4-顺序一致性)
* [5. happens-before](#5-happens-before)
* [6. volatile](#6-volatile)
* [7. synchronized 与 锁](#7-synchronized-与-锁)
* [8. CAS 与原子操作](#8-cas-与原子操作)
* [9. AQS](#9-aqs)


## 1. JMM

Java 中采用的是共享内存并发模型

<div align="center"> <img src="jmm.png" width="70%"/> </div><br>



## 2. 内存可见性





<div align="center"> <img src="jmm1.jpg" width="70%"/> </div><br>

注意⚠️：

1. 所有的共享变量都存在主内存中
2. 每个线程都保存了一份该线程使用到的共享变量的副本
3. 线程 A 和线程 B 进行通讯必须经过以下步骤：
   1. 线程 A 将本地内存 A 中更新过的共享变量刷新到主内存中
   2. 线程 B 到主内存中读取线程 A 已更新过的共享变量



根据 `JMM` 的规定，线程对共享变量的操作必须在自己本地内存中进行，不能直接从主内存读取





## 3. 重排序











## 4. 顺序一致性







## 5. happens-before









## 6. volatile





## 7. synchronized 与 锁









## 8. CAS 与原子操作











## 9. AQS











