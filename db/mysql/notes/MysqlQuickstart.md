# MySQL Quickstart

## Category

* [Create Database / Table](#create-database---table)
  + [Create database](#create-database)
  + [Create table](#create-table)
* [Retrieve table](#retrieve-table)
* [Update table](#update-table)
  + [RENAME TO](#rename-to)
  + [CHARACTER SET](#character-set)
  + [CHANGE](#change)
  + [ADD](#add)
  + [DROP](#drop)
* [Add data](#add-data)
* [Delete data](#delete-data)
* [Update data](#update-data)
* [Query](#query)
  + [DISTINCT](#distinct)
  + [BETWEEN AND](#between-and)
  + [ORDER BY](#order-by)
  + [COUNT](#count)
  + [GROUP BY](#group-by)
  + [分页](#--)
* [Constraint](#constraint)
  + [Primary Key](#primary-key)
  + [Not null](#not-null)
  + [Unique](#unique)
  + [Foreign Key](#foreign-key)





## Create Database / Table

### Create database

```sql
CREATE DATABASE mydatabase;
CREATE DATABASE IF NOT EXISTS mydatabase;
USE mydatabase;  
```



### Create table

```sql
CREATE TABLE mytable(
	# 各个列名用逗号隔开
	num INT,
	name VARCHAR(30),  # VARCHAR(length) 需要指定长度
	age INT，
	score DOUBLE,
	birthday DATE,
	edited_time TIMESTAMP
);
```


## Retrieve table

查看当前的表。

```sql
DESC mytable;
```



## Update table

### RENAME TO

```sql
ALTER TABLE mytable RENAME TO mytable1;
```

关键字：`RENAME TO`

### CHARACTER SET

```sql
ALTER TABLE mytable CHARACTER SET utf8;
```

关键字：`CHARACTER SET`

### CHANGE

```sql
ALTER TABLE mytable CHANGE old_col new_col attribute;
```

其中 `old_col`代表旧的列，`new_col`代表新的列，`attribute`代表属性。

关键字：`CHANGE`

### ADD

```sql
ALTER TABLE mytable ADD new_col attribute;
```

关键字：`ADD`

### DROP 

```sql
ALTER TABLE mytable DROP col;
```

关键字：`DROP`



## Add data

```sql
INSERT INTO mytable(col_1, col_2, col_n) VALUES (value_1, value_2, value_n);
INSERT INTO mytable VALUES (..,...,...,)  # 为所有列赋值
```

属性与名称要一一对应



## Delete data

```sql
DELETE FROM mytable WHERE ...
```

删除表中符合条件的记录。



## Update data

```sql
UPDATE mytable set col = value WHERE ...
```

养成加 `WHERE`语句的好习惯，否则默认改所有数据，十分危险！



## Query

### DISTINCT

```sql
SELECT DISTINCT col FROM mytable;
```

关键字：`DISTINCT` 去重

```sql
SELECT col1, col2, col1 + IFNULL(expr1, expr2) AS col_nickname FROM mytable;
```

关键字：`IFNULL(expr1, expr2) `

如果该值不为`NULL`: expr1

若该值为`NULL`: expr2



`AS` 列别名



### BETWEEN AND

```sql
SELECT col FROM mytable WHERE col BETWEEN xx AND xx;
```

关键字：`BETWEEN x AND y`

该列的值在 `[x, y]` 之间



```sql
SELECT col FROM mytable WHERE col in (value1, value2, valuen);
```

关键字：`IN`

该值在`()`范围内



```	sql
SELECT col FROM mytable WHERE col IS NOT NULL;
SELECT col FROM mytable WHERE col IS NULL;
```

关键字：`IS NOT NULL` 和 `IS NULL`

判断空值只能用 `IS`或者`IS NOT`判断



```sql
SELECT col FROM mytable WHERE col LIKE '%_';
```

`%`代表任意个匹配

`_`代表单个匹配



###  ORDER BY

```sql
SELECT col1, col2, ... FROM mytable WHERE ... ORDER BY col ASC / DESC
```

关键字：`ORDER BY`

`ASC` 是 `Ascending`的简称，升序

`DESC` 是 `Descending`的简称，降序



### COUNT

聚合是以列为单位，对列进行统计，结果往往为一个数值。

`NULL`值不算。

```sql
SELECT COUNT(col) / AVG(col) / SUM(col) / MAX(col) / MIN(col) FROM mytable
```

关键词：

`COUNT` 总个数

`AVG` 平均值

`SUM` 总数

`MAX` 最大值

`MIN` 最小值



### GROUP BY

“物以聚类人以群分”

分组就是将数据依照某列的值分为不同组，例如性别分为男女，年龄分为老中少。

**注意**

分组之后查询的列需要是分组字段 / 聚合函数，因为我们研究的是群体而不是个体。

```sql
SELECT col, 聚合函数 AS .. FROM mytable WHERE ... GROUP BY col HAVING ...
```

**WHERE 与 HAVING 区别**

1. `where` 在分组之前筛选。`having`在分好组之后再进行筛选

2. `having`之后能跟聚合函数而`where`则不行（因为`having`往往是根据分组之后的结果再来进行筛选的）



### 分页

```sql
SELECT col FROM mytable LIMIT 开始的索引, 每页显示的条数;
```

**开始的索引 = （当前页码 - 1） * 每页显示的条数**



## Constraint

### Primary Key

```sql
PRIMARY KEY
```

主键约束，一张表只能一列是主键。

主键唯一且非空，是表的唯一标识。相当于你身份证（号）是每个社会人的唯一标识。



### Not null

```sql
NOT NULL
```

非空。



### Unique

```sql
UNIQUE	
```

不重复。



### Foreign Key

```sql
CONSTRAINT 外键名称 FOREIGN KEY (列名) REFERNCE mytable(id)
```

