# 目录
- [目录](#--)
- [1. 创建库, 表](#1-------)
  * [创建库](#---)
  * [创建表](#---)
- [2. 查询表](#2----)
- [3. 修改表](#3----)
  * [修改表名](#----)
  * [修改字符集](#-----)
  * [修改列名和属性](#-------)
  * [增加列](#---)
  * [删除列](#---)
- [4. 添加数据](#4-----)
- [5. 删除数据](#5-----)
- [6. 修改数据](#6-----)





# 1. 创建库, 表

## 创建库

```sql
CREATE DATABASE mydatabase;
CREATE DATABASE IF NOT EXISTS mydatabase;
USE mydatabase;  
```



## 创建表

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


# 2. 查询表

查看当前的表。

```sql
DESC mytable;
```



# 3. 修改表

## 修改表名

```sql
ALTER TABLE mytable RENAME TO mytable1;
```

关键字：RENAME TO

## 修改字符集

```sql
ALTER TABLE mytable CHARACTER SET utf8;
```

关键字：CHARACTER SET

## 修改列名和属性

```sql
ALTER TABLE mytable CHANGE old_col new_col attribute;
```

其中 `old_col`代表旧的列，`new_col`代表新的列，`attribute`代表属性。

关键字：CHANGE

## 增加列

```sql
ALTER TABLE mytable ADD new_col attribute;
```

关键字：ADD

## 删除列

```sql
ALTER TABLE mytable DROP col;
```

关键字：DROP


<a name="4"></a>
# 4. 添加数据

```sql
INSERT INTO mytable(col_1, col_2, col_n) VALUES (value_1, value_2, value_n);
INSERT INTO mytable VALUES (..,...,...,)  # 为所有列赋值
```

属性与名称要一一对应



# 5. 删除数据

```sql
DELETE FROM mytable WHERE ...
```

删除表中符合条件的记录。



# 6. 修改数据












