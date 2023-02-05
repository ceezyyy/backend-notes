# Redis

- [高性能](#高性能)
  - [数据结构](#数据结构)
  - [单线程](#单线程)
- [高可用](#高可用)
- [可扩展](#可扩展)
- [引用](#引用)

## 高性能

### 数据结构

**全局哈希表**

<div align="center"> <img src="./pics/hash.png" width="60%"/> </div><br>

挑战 1：过多的 key 会引起哈希冲突，导致查找效率变低

解决：rehash（两个哈希表，先写哈希表 1，不够写了就分配大内存的哈希表 2，数据 transfer，最后释放哈希表 1 空间）



挑战 2：哈希表 1，2 transfer 会阻塞单线程

解决：渐进式 rehash，每个 bucket transfer 分摊到每次请求中



### 单线程

**IO 多路复用**

## 高可用

## 可扩展

## 引用

- [A Closer Look at Redis Dictionary Implementation Internals](https://codeburst.io/a-closer-look-at-redis-dictionary-implementation-internals-3fd815aae535)
