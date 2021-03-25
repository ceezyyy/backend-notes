# MySQL

Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [1. 基本架构](#1-基本架构)
* [2. 索引](#2-索引)
   * [2.1 底层数据结构](#21-底层数据结构)
      * [2.1.1 B Tree](#211-b-tree)
      * [2.1.2 B  Tree](#212-b-tree)
   * [2.2 复合索引](#22-复合索引)
* [3. 事务](#3-事务)
* [4. 锁](#4-锁)
   * [4.1 快照读](#41-快照读)
      * [4.1.1 ReadView](#411-readview)
* [References](#references)

## Brainstorming

  <div align="center"> <img src="mysql.svg" width="100%"/> </div><br>





## 1. 基本架构

  <div align="center"> <img src="image-20210109111740739.png" width="60%"/> </div><br>

## 2. 索引

### 2.1 底层数据结构

#### 2.1.1 B Tree

<div align="center"> <img src="B-Tree.svg" width="50%"/> </div><br>

#### 2.1.2 B+ Tree

<div align="center"> <img src="Bplustree.png" width="50%"/> </div><br>





**Clustered index (聚簇索引)**

叶子结点也称为数据页，InnoDB 大小为 16 KB

**术语**

- 页中的值
- 指向子页的指针
- 指向下一个叶子页的指针

<div align="center"> <img src="clustered.png" width="55%"/> </div><br>

**Secondary index (辅助索引)**

> 以 (key, id) 方式存储数据

<div align="center"> <img src="secondary-index.png" width="60%"/> </div><br>

### 2.2 复合索引

<div align="center"> <img src="image-20210325152557399.png" width="60%"/> </div><br>



## 3. 事务

**Example**

> redo log: 记录事务的行为以实现持久化 | undo log: 支撑事务的 rollback 操作
>

举个例子，现在需要将 a 字段的值由 1 改为 3，b 字段的值由 2 改为 4

| column | value |
| ------ | ----- |
| a      | 1     |
| b      | 2     |

**执行流程**

1. start transaction
2. a = 1 -> 写入 `undo log`
3. 写入/更新 a = 3
4. a = 3 -> 写入 `redo log`
5. b = 2 -> 写入 `undo log`
6. 写入/更新 b = 4
7. b = 4 -> 写入 `redo log`
8. 将 `redo log` 刷入磁盘实现持久化
9. commit



## 4. 锁

### 4.1 快照读

> 写：新增 snapshot 数据；读：旧 snapshot 数据

#### 4.1.1 ReadView

> MVCC 维护了一个 ReadView 结构，主要包含了当前系统活跃的事务列表 TRX_IDs

<div align="center"> <img src="image-20210109154530693.png" width="60%"/> </div><br>

**Explained**

对于事务 t1 启动的瞬间，`ReadView` 保存了当前活跃事务集合（begin 但仍未 commit 的事务）

- 若在绿色部分：**可见**
- 若在黄色部分：**不可见**
- 若在红色部分：**不可见**




## References

- 施瓦茨. 高性能 MYSQL(第3版)[M]. 电子工业出版社, 2013.
- 姜承尧. MySQL技术内幕：InnoDB存储引擎(第2版)[M]. 机械工业出版社, 2018.
- [MySQL实战45讲-极客时间](https://time.geekbang.org/column/intro/100020801)
- [为什么 MySQL 使用 B+ 树](https://draveness.me/whys-the-design-mysql-b-plus-tree/)

