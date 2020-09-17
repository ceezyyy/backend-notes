# Redis 

<div align="center"> <img src="logo.png" width="50%"/> </div><br>





Table of Contents
-----------------

* [1. 什么是 redis?](#1-什么是-redis)
* [2. 为什么要使用 redis？](#2-为什么要使用-redis)
* [3. 使用场景](#3-使用场景)
* [4. Quickstart](#4-quickstart)
   * [4.1 Installation](#41-installation)



## 1. 什么是 redis?

`Redis` 是一种基于 `key-value` 的 `NoSQL` 数据库，没有数据表的概念

## 2. 为什么要使用 redis？

1. 速度快

   `Redis` 所有数据都是放在内存中的（避免了大量与操作系统 IO 打交道）

2. 基于 `key-value` 的数据结构服务器

3. 丰富的功能：

   1. 键过期：实现缓存
   2. 发布订阅：消息系统

4. 持久化

   将数据保存在内存中是不安全的，当发生断电或者宕机，数据极有可能丢失

   `Redis` 提供了 `RDB` 和 `AOF` 两种持久化方式，将内存的数据保存在硬盘中

5. 高可用和分布式



## 3. 使用场景





## 4. Quickstart

### 4.1 Installation

<div align="center"> <img src="image-20200917163808061.png" width="60%"/> </div><br>

启动 `redis`：

```bash
brew services start redis
```













