# 多线程原理


* [1. JMM](#1-jmm)
* [2. 内存可见性](#2-内存可见性)
* [3. volatile](#3-volatile)
* [4. synchronized 与锁](#4-synchronized-与锁)
* [5. CAS 与原子操作](#5-cas-与原子操作)
* [6. AQS](#6-aqs)



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







## 3. volatile





## 4. synchronized 与锁









## 5. CAS 与原子操作











## 6. AQS











