# MySQL

Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [1. 数据库原理](#1-数据库原理)
   * [1.1 事务](#11-事务)
      * [1.1.1 ACID](#111-acid)
      * [1.1.2 Mysql 中的事务](#112-mysql-中的事务)
   * [1.2 并发一致性问题](#12-并发一致性问题)
   * [1.3 封锁](#13-封锁)
   * [1.4 隔离级别](#14-隔离级别)
   * [1.5 多版本并发控制](#15-多版本并发控制)
   * [1.6 Next-Key Locks](#16-next-key-locks)
   * [1.7 关系数据库设计理论](#17-关系数据库设计理论)
   * [1.8 ER 图](#18-er-图)
* [2. Mysql 架构](#2-mysql-架构)
* [3. 索引](#3-索引)
   * [3.1 回表](#31-回表)
   * [3.2 联合索引：最左匹配原则](#32-联合索引最左匹配原则)
   * [3.3 前缀索引（最左匹配原则应用）](#33-前缀索引最左匹配原则应用)
   * [3.4 Left Join &amp; Right Join 索引优化](#34-left-join--right-join-索引优化)
   * [3.5 覆盖索引](#35-覆盖索引)
   * [3.6 COUNT(*) 优化](#36-count-优化)
   * [3.7 小表驱动大表](#37-小表驱动大表)
* [4. 存储引擎比较](#4-存储引擎比较)
* [5. 数据类型](#5-数据类型)
* [6. 复制](#6-复制)
* [References](#references)


## Brainstorming

  <div align="center"> <img src="mysql.svg" width="100%"/> </div><br>



## 1. 数据库原理

### 1.1 事务

> 事务就是一组原子性的 SQL 语句，要么全部执行成功，要么全部执行失败

#### 1.1.1 ACID

一个运行良好的事务，必须具备 `ACID` 四个特性

- Atomicity: 一个事务必须视为不可分割的最小工作单元（不能只执行事务的其中一部分）
- Consistency: 数据库总是从一个一致性的状态转移到另一个一致性的状态（可理解为 C 是目的，AID 是手段）
- Isolation: **通常来说**（后面会谈论事务的隔离级别），一个事务在未提交之前对其他事务是不可见的
- Durability: 一旦事务提交，其所做的修改就会永久保存到数据库中

#### 1.1.2 Mysql 中的事务



### 1.2 并发一致性问题

### 1.3 封锁

### 1.4 隔离级别

### 1.5 多版本并发控制

### 1.6 Next-Key Locks

### 1.7 关系数据库设计理论

### 1.8 ER 图





## 2. Mysql 架构

  <div align="center"> <img src="mysql-architecture.png" width="75%"/> </div><br>

## 3. 索引

**每一个索引在 InnoDB 里面对应一颗 B+ 树**



### 3.1 回表

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



### 3.2 联合索引：最左匹配原则

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

### 3.3 前缀索引（最左匹配原则应用）

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





### 3.4 Left Join & Right Join 索引优化

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



### 3.5 覆盖索引

通过遍历索引树就可以满足查询的字段，不用回表，即索引被覆盖了

是一种高效的性能优化手段



**注意（重要）：**

当 ` SELECT *` 的时候，若是遍历整个索引树（比如 `LIKE %xxx%`），可以认为造成了全表扫描（因为在遍历索引树的过程每次都需要回表）



### 3.6 COUNT(*) 优化



### 3.7 小表驱动大表







**Dirty read**

读到了别的事务未 commit 的数据

<div align="center"> <img src="image-20201220115049237.png" width="45%"/> </div><br>

**Lost to modify**

多个事务同时修改一个数据，造成修改丢失

<div align="center"> <img src="image-20201220115421956.png" width="45%"/> </div><br>

**Non-repeatable read & Phantom read**

多次读的数据不一致（别的事务修改了）/ 多次读的数据条数不一致（别的事务新增/删减了数据）

<div align="center"> <img src="image-20201220120446481.png" width="45%"/> </div><br>











## 4. 存储引擎比较





## 5. 数据类型







## 6. 复制













## References

- 施瓦茨. 高性能 MYSQL(第3版)[M]. 电子工业出版社, 2013.
- [MySQL实战45讲-极客时间](https://time.geekbang.org/column/intro/100020801)
- [事务隔离级别(图文详解)](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/%E4%BA%8B%E5%8A%A1%E9%9A%94%E7%A6%BB%E7%BA%A7%E5%88%AB(%E5%9B%BE%E6%96%87%E8%AF%A6%E8%A7%A3).md)
- [尚硅谷MySQL数据库高级，mysql优化，数据库优化](https://www.bilibili.com/video/BV1KW411u7vy?from=search&seid=11888146484032851728)
- [8.8.2 EXPLAIN Output Format](https://dev.mysql.com/doc/refman/8.0/en/explain-output.html)
- [What does eq_ref and ref types mean in MySQL explain](https://stackoverflow.com/questions/4508055/what-does-eq-ref-and-ref-types-mean-in-mysql-explain)
- [mysql联合索引](https://www.cnblogs.com/softidea/p/5977860.html)
- [MySQL最左匹配原则，道儿上兄弟都得知道的原则](https://blog.csdn.net/qq_39390545/article/details/108540362)
- [mysql 联合索引详解](https://blog.csdn.net/lmh12506/article/details/8879916)
- [【原创】Mysql中select的正确姿势](https://www.cnblogs.com/rjzheng/p/9902911.html)
- [MySQL 覆盖索引详解](https://juejin.cn/post/6844903967365791752)
- [MySQL索引原理及慢查询优化](https://tech.meituan.com/2014/06/30/mysql-index.html)
- [一文读懂MySQL的索引结构及查询优化](https://www.cnblogs.com/itwild/p/13703259.html)
- [mysql怎么让左模糊查询也能走索引？](https://blog.csdn.net/weixin_38106322/article/details/106583450)
- [MySQL - exists与in及any的用法](https://blog.csdn.net/J080624/article/details/72910548)
