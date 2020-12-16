# MySQL 进阶

Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [1. 架构](#1-架构)
* [2. Joins](#2-joins)
* [3. 子查询](#3-子查询)
* [4. Union](#4-union)
* [5. 索引: B  树](#5-索引-b-树)
* [6. 单表索引优化](#6-单表索引优化)
   * [6.1 表设计 &amp; 初始化](#61-表设计--初始化)
   * [6.2 Demo](#62-demo)
* [7. 两表索引优化](#7-两表索引优化)
* [8. 三表索引优化](#8-三表索引优化)
* [References](#references)


## Brainstorming

  <div align="center"> <img src="mysql-pro.svg" width="100%"/> </div><br>



## 1. 架构

  <div align="center"> <img src="mysql-architecture.png" width="80%"/> </div><br>







## 2. Joins

  <div align="center"> <img src="sql-joins.png" width="70%"/> </div><br>



## 3. 子查询

  <div align="center"> <img src="image-20201215175720297.png" width="60%"/> </div><br>







## 4. Union

`union` 用于连接两个以上的 `select` 语句的结果组合到一个结果集合中。多个 `select` 语句会删除重复的数据



  <div align="center"> <img src="union.png" width="60%"/> </div><br>



```mysql
SELECT column_name(s) FROM table1
UNION
SELECT column_name(s) FROM table2;
```



## 5. 索引: B+ 树

  <div align="center"> <img src="b-plus-tree.png" width="100%"/> </div><br>

## 6. 单表索引优化

### 6.1 表设计 & 初始化

  <div align="center"> <img src="image-20201216110449022.png" width="100%"/> </div><br>



<div align="center"> <img src="image-20201216164123575.png" width="60%"/> </div><br>


**踩坑记录**

- 插入数据时：

  `INSERT INTO TABLE_NAME (col1, col2, ...) VALUES (val1, val2, ...)` 若 `PK` 为自增，则不要写入 `(col1, col2, ...)` 的参数中（对表进行修改后记得手动保存）



### 6.2 Demo

**查询 category_id 为 1 且 comments 大于 1 的情况下，views 最多的 id**

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
















## 7. 两表索引优化









## 8. 三表索引优化















## References

- [MySQL实战45讲-极客时间](https://time.geekbang.org/column/intro/100020801)
- [MySQL 的 crash-safe 原理解析](https://juejin.im/post/6844904167782236167)
- [事务隔离级别(图文详解)](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/%E4%BA%8B%E5%8A%A1%E9%9A%94%E7%A6%BB%E7%BA%A7%E5%88%AB(%E5%9B%BE%E6%96%87%E8%AF%A6%E8%A7%A3).md)
- [10.2 B Trees and B+ Trees. How they are useful in Databases](https://www.youtube.com/watch?v=aZjYr87r1b8&t=15s)
- [Introduction of B-Tree](https://www.geeksforgeeks.org/introduction-of-b-tree-2/)
- [B-Tree Visualization](https://www.cs.usfca.edu/~galles/visualization/BTree.html)
- [平衡二叉树、B树、B+树、B*树 理解其中一种你就都明白了](https://zhuanlan.zhihu.com/p/27700617)
- [The Difference Between B-trees and B+trees](https://www.baeldung.com/cs/b-trees-vs-btrees)
- [MySQL 索引](https://www.runoob.com/mysql/mysql-index.html)
- [尚硅谷MySQL数据库高级，mysql优化，数据库优化](https://www.bilibili.com/video/BV1KW411u7vy?from=search&seid=11888146484032851728)
- [8.8.2 EXPLAIN Output Format](https://dev.mysql.com/doc/refman/8.0/en/explain-output.html)
- [MySQL UNION 操作符](https://www.runoob.com/mysql/mysql-union-operation.html)
- [What does eq_ref and ref types mean in MySQL explain](https://stackoverflow.com/questions/4508055/what-does-eq-ref-and-ref-types-mean-in-mysql-explain)

