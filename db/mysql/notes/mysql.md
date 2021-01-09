# MySQL

Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [1. 基本架构](#1-基本架构)
* [2. 索引](#2-索引)
   * [2.1 回表](#21-回表)
   * [2.2 联合索引](#22-联合索引)
   * [2.3 前缀索引](#23-前缀索引)
   * [2.4 Left Join &amp; Right Join 索引优化](#24-left-join--right-join-索引优化)
   * [2.5 覆盖索引](#25-覆盖索引)
* [3. 事务](#3-事务)
   * [3.1 redo log](#31-redo-log)
   * [3.2 undo log](#32-undo-log)
* [4. 锁（InnoDB）](#4-锁innodb)
   * [4.1 意向锁](#41-意向锁)
   * [4.2 MVCC](#42-mvcc)
      * [4.2.1 ReadView](#421-readview)
      * [4.2.2 Example](#422-example)
* [References](#references)

## Brainstorming

  <div align="center"> <img src="mysql.svg" width="100%"/> </div><br>





## 1. 基本架构

  <div align="center"> <img src="image-20210109111740739.png" width="70%"/> </div><br>

## 2. 索引

**每一个索引在 InnoDB 里面对应一颗 B+ 树**



### 2.1 回表

举个例子，我们有一个主键列为 `ID` 的表，其中有个字段为 `k`，且 `k` 上有索引

我们称 `ID` 为主键索引，`k` 为非主键索引





<div align="center"> <img src="image-20201216201947037.png" width="70%"/> </div><br>



在执行下列语句时：

```mysql
SELECT * FROM table_name WHERE ID = 500;
```

只需要搜索 `ID` 这颗 `B+` 树

而当执行下列语句时：

```mysql
SELECT * FROM table_name WHERE K = 5;
```

则需要先搜索 `k` 索引树，获得 `ID` 为 500，再去搜 `ID` 索引树，这个称 "回表"





**执行流程（重要）：**

1. 在 `k` 索引树上找到 `k = 3` 的记录，取得 `ID = 300`
2. 再到 `ID`  索引树查到 `ID = 300` 对应的 `R3`
3. 在 `k` 索引树取下一个值 `k = 5`，取得 `ID = 500`
4. 再回到 `ID` 索引树查到 `ID = 500` 对应的 `R4`
5. 在 `k` 索引树取下一个值 `k = 6`，不满足条件，循环结束



在这个例子中，由于查询结果所需要的数据只在主键索引上有，所以不得不回表



### 2.2 联合索引

**表设计 & 初始化 **

  <div align="center"> <img src="image-20201216110449022.png" width="100%"/> </div><br>



<div align="center"> <img src="image-20201216164123575.png" width="60%"/> </div><br>


**踩坑记录**

- 插入数据时：

  `INSERT INTO TABLE_NAME (col1, col2, ...) VALUES (val1, val2, ...)` 若 `PK` 为自增，则不要写入 `(col1, col2, ...)` 的参数中（对表进行修改后记得手动保存）



**需求：查询 category_id 为 1 且 comments 大于 1 的情况下，views 最多的 id**

```mysql
SELECT
	id 
FROM
	article 
WHERE
	category_id = 1 
	AND comments > 1 
ORDER BY
	views DESC 
	LIMIT 1;
```

<div align="center"> <img src="image-20201216203010470.png" width="100%"/> </div><br>

**优化 1.0**

既然在 `WHERE` 和 `ORDER BY` 后跟了 `category_id`，`comments` 以及 `views` 这三列

那我们就建一个联合索引：

```mysql
CREATE INDEX idx_category_comments_views ON article ( category_id, comments, views );
```

<div align="center"> <img src="image-20201216204202798.png" width="100%"/> </div><br>

避免了全表扫，但出现了 `using filesort`



**联合索引在执行的时候，遵循 “最左匹配原则”**



假设一张表的 `a`，`b`，`c` 列上有一个联合索引 `idx_a_b_c`

相当于已经对 `(a)`，`(a, b)`，`(a, b, c)` 建立了索引



举个例子，联合索引的结构和电话簿相类似，

- 若知道姓，电话簿会很有用
- 除了姓，还知道名，电话薄更有用
- 若只知道名，不知道姓，电话簿还能发挥作用吗？



**优化 2.0**

```mysql
CREATE INDEX idx_category_views ON article ( category_id, views );
```

<div align="center"> <img src="image-20201216224438990.png" width="100%"/> </div><br>

### 2.3 前缀索引

假设现在需要维护一个邮箱登录的系统，如何在邮箱这个字段高效地建立索引？

两种方案：

1. 记录整个字符串
2. 记录字符串的前 n 个字节



<div align="center"> <img src="image-20201221161039211.png" width="60%"/> </div><br>

<div align="center"> <img src="image-20201221161115527.png" width="60%"/> </div><br>

```mysql
SELECT 
	id,name,email 
FROM 
	SUser 
WHERE 
	email='zhangssxyz@xxx.com';
```



第一种方案的执行顺序：

1. 在 `email` 索引树上找到



第二种方案的执行顺序：

1. 在 `email` 索引树上找到





### 2.4 Left Join & Right Join 索引优化

**表设计**

`class` 表：

<div align="center"> <img src="image-20201216230148641.png" width="90%"/> </div><br>


`book` 表：

<div align="center"> <img src="image-20201216230150133.png" width="90%"/> </div><br>

字段都相同，`card` 为主外键关系



下面以 `left join` 为例，探究两表的索引该如何建立

- 左表：`class`
- 右表：`book`

```mysql
EXPLAIN SELECT
	* 
FROM
	class
	LEFT JOIN book ON class.card = book.card;
```



没建索引之前：

<div align="center"> <img src="image-20201217112927500.png" width="90%"/> </div><br>



1. 只在左表 `card` 字段上建立索引：

```mysql
CREATE INDEX idx_class_card ON class(card);
```

使用 `explain` 分析结果：

<div align="center"> <img src="image-20201217114636037.png" width="90%"/> </div><br>



2. 只在右表的 `card` 字段建立索引：

```mysql
CREATE INDEX idx_book_card ON book ( card );
```

使用 `explain` 分析结果：

<div align="center"> <img src="image-20201217115112303.png" width="90%"/> </div><br>





**总结：**

- Left join, 索引加右表
- Right join, 索引加左表



### 2.5 覆盖索引

通过遍历索引树就可以满足查询的字段，不用回表，即索引被覆盖了

是一种高效的性能优化手段



**注意（重要）：**

当 ` SELECT *` 的时候，若是遍历整个索引树（比如 `LIKE %xxx%`），可以认为造成了全表扫描（因为在遍历索引树的过程每次都需要回表）

## 3. 事务

### 3.1 redo log

> redo log 用来保证事务的持久性，InnoDB 特有

当有一条记录需要更新的时候，`InnoDB` 会将该记录写到 `redo log` 中，并更新内存。在系统较空闲的时候，再将此条记录更新到磁盘中



<div align="center"> <img src="image-20210109113050644.png" width="50%"/> </div><br>



**Example**

```mysql
CREATE TABLE t (
	id int PRIMARY KEY,
	c int
);

UPDATE T
SET c = c + 1
WHERE id = 2;
```



执行流程：

1. 执行器找 `InnoDB` 查找 `id` = 2 的这一行数据，`InnoDB` 查找完成后返回给执行器
2. 执行器将当前值置为 `N = N + 1`，找 `InnoDB` 更新数据
3. `InnoDB` 将记录更新到内存中，写入 `redo log`（此时 `redo log` 处于 `prepare` 状态），告知执行器准备完毕，等待提交
4. 执行器生成这个操作的 `binlog`，并写入磁盘
5. 执行器调用 `InnoDB` 的事务提交接口，此时 `InnoDB` 将 `redo log` 的状态改为 `commit`，更新完成

 



### 3.2 undo log



## 4. 锁（InnoDB）

### 4.1 意向锁

<div align="center"> <img src="is-ix-lock.png" width="60%"/> </div><br>

在存在行锁和表锁的情况下，事务 T 想要对表 A 加 X 锁，就需要检测是否有其他事务对表 A 或者表 A 中任一一行加了锁，即需要对表 A 每一行都检测一次，无疑是非常耗时的



**意向锁有两个规定：**

- 一个事务在获得某个数据行对象的  S 锁之前，必须先获得表的 IS 锁或者更强的锁
- 一个事务在获得某个数据行对象的  X 锁之前，必须先获得表的 IX 锁



### 4.2 MVCC

> 行锁的变种，在大多情况下实现了非阻塞读，写操作也只锁定部分行

#### 4.2.1 ReadView

> MVCC 维护了一个 ReadView 结构，主要包含了当前系统活跃的事务列表 TRX_IDs

<div align="center"> <img src="image-20210109154530693.png" width="60%"/> </div><br>

**Explained**

- 低水位：当前活跃事务 ID 最小值；高水位：当前活跃事务 ID 最大值 + 1
- 对于当前事务的启动瞬间，一个数据版本的 `row trx_id`：
  - 若在绿色部分：可见；若在红色部分：不可见
  - 若在黄色部分：**是否可见需要看具体隔离级别**
    - 若 `row trx_id` 在 `TRX_IDs` 中：表示这个版本是由未 commit 的事务生成的
    - 若 `row trx_id` 不在 `TRX_IDs` 中：表示这个版本是已 commit 的事务生成的

#### 4.2.2 Example

建表

```mysql
CREATE TABLE t (
	id int PRIMARY KEY,
	k int DEFAULT NULL
) ENGINE = InnoDB;
```

插入数据

```mysql
INSERT INTO t (id, k)
VALUES (1, 1);

INSERT INTO t (id, k)
VALUES (2, 2);
```

事务 `T1`，`T2`，`T3` 执行流程：

| T1                                          | T2                                                           | T3                                   |
| ------------------------------------------- | ------------------------------------------------------------ | ------------------------------------ |
| start transaction with consistent snapshot; |                                                              |                                      |
|                                             | start transaction with consistent snapshot;                  |                                      |
|                                             |                                                              | update t set k = k + 1 where id = 1; |
|                                             | update t set k = k + 1 where id = 1;<br />select k from t where id = 1; |                                      |
| select k from t where id = 1;<br />commit;  |                                                              |                                      |
|                                             | commit;                                                      |                                      |



**P.S**

- 使用 `start/begin transaction` 方式启动事务，一致性视图是在执行第一个快照读语句时创建的
- 使用 `start transaction with consistent snapshot`，一致性视图立马创建



**结果**

- `T1` 查到的 K 值是 1
- `T2` 查到的 K 值是 3







## References

- 施瓦茨. 高性能 MYSQL(第3版)[M]. 电子工业出版社, 2013.
- 姜承尧. MySQL技术内幕：InnoDB存储引擎(第2版)[M]. 机械工业出版社, 2018.
- [MySQL实战45讲-极客时间](https://time.geekbang.org/column/intro/100020801)
- [尚硅谷MySQL数据库高级，mysql优化，数据库优化](https://www.bilibili.com/video/BV1KW411u7vy?from=search&seid=11888146484032851728)
- [What does eq_ref and ref types mean in MySQL explain](https://stackoverflow.com/questions/4508055/what-does-eq-ref-and-ref-types-mean-in-mysql-explain)
- [CyC2018/CS-Notes](https://github.com/CyC2018/CS-Notes/blob/master/notes/%E6%95%B0%E6%8D%AE%E5%BA%93%E7%B3%BB%E7%BB%9F%E5%8E%9F%E7%90%86.md)
