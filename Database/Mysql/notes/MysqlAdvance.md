# Mysql 进阶

## 目录

* [1. Mysql 架构介绍](#1-mysql-----)
  + [1.1 SQL 执行顺序](#11-sql-----)
    - [1.1.1 手写](#111---)
    - [1.1.2 机读](#112---)
  + [1.2 JOIN 连接](#12-join---)
* [2. 索引优化分析](#2-------)
  + [2.1 建立索引](#21-----)
    - [2.1.1 为什么要建立索引](#211---------)
* [3. 查询截取分析](#3-------)
* [4. 锁机制](#4----)
* [5. 主从复制](#5-----)



## 1. Mysql 架构介绍

**插件式的存储引擎架构将查询处理和其他系统任务以及数据的存储提取相分离**

- 连接层
- 服务层
- 引擎层
- 数据存储层

<div align="center"> <img src="structure.jfif" width="90%"/> </div><br>

```sql
show engines;
```

<div align="center"> <img src="image-20200622174451858.png" width="90%"/> </div><br>

<div align="center"> <img src="image-20200622174619206.png" width="90%"/> </div><br>



### 1.1 SQL 执行顺序

#### 1.1.1 手写

<div align="center"> <img src="image-20200622180926436.png" width="40%"/> </div><br>



#### 1.1.2 机读

`mysql` 最关心的是表以及字段 

<div align="center"> <img src="image-20200622181440991.png" width="90%"/> </div><br>

### 1.2 JOIN 连接

放一张神图（强烈建议手写一遍）

<div align="center"> <img src="sqljoins.webp" width="80%"/> </div><br>



## 2. 索引优化分析

### 2.1 建立索引

#### 2.1.1 为什么要建立索引

可以大大加快数据的检索速度（大幅度减少检索的数据量）



**如何建立索引？**

其中 `idx` 是约定俗成的索引前缀，`blog` 为表明，`title` 为该表经常需要查询的字段

```sql
create index idx_blog_title on blog(title);
```




























## 3. 查询截取分析



























## 4. 锁机制

































## 5. 主从复制

