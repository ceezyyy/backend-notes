# MyBatis
<div align="center"> <img src="logo.png" width="60%"/> </div><br>

## Category

  * [1. What is MyBatis](#1-what-is-mybatis)
  * [2. Why we use MyBatis](#2-why-we-use-mybatis)
  * [3. Quickstart](#3-quickstart)
    + [3.1 使用 XML 配置](#31----xml---)
    + [3.2 使用注解配置](#32-------)
    + [3.3 踩坑记录](#33-----)
      - [3.3.1 Timezone](#331-timezone)
  * [4. MyBatis 的 CRUD](#4-mybatis---crud)
    + [4.1 插入操作](#41-----)



## 1. What is MyBatis

`MyBatis` 是一个用 Java 编写的持久层框架，



## 2. Why we use MyBatis

开发中讲究极简编程，让开发者更专注于开发本身，`MyBatis` 帮我们封装了许多底层实现，让我们更专注于开发



## 3. Quickstart

### 3.1 使用 XML 配置

1. 创建 `Maven` 工程，添加依赖

<div align="center"> <img src="image-20200508182849525.png" width="100%"/> </div><br>

- `mysql`：使用 `JDBC` 操作 `mysql` 数据库

-  `mybatis`：我们当前使用的框架
- `junit`：单元测试
- `log4j`：提供方便的日志记录

2. 创建数据库，表
3. 创建实体类，`dao` 接口

<div align="center"> <img src="image-20200508200607809.png" width="50%"/> </div><br>

4. `MyBatis` 主配置文件

   在 `SqlMapConfig.xml` 下编写 `MyBatis` 主配置文件（名字不做强求）

<div align="center"> <img src="image-20200508201019098.png" width="100%"/> </div><br>


5. 对应 `dao` 接口的配置文件

<div align="center"> <img src="image-20200508201330321.png" width="100%"/> </div><br>

> :warning:**注意**
>
>`MyBatis` 的映射数据文件需要和 `dao` 接口的包结构一致

<div align="center"> <img src="image-20200508201506417.png" width="40%"/> </div><br>

6. 主函数

![image-20200509232821635](image-20200509232821635.png)



### 3.2 使用注解配置

既然不采用 `XML` 方式配置了，那我们也不需要映射配置文件（`MyBatis` 主配置文件还是需要的）

将 `mapper` 改为 `class` 属性，填写对应的 `dao` 接口

> :warning:**注意**
>
> 包名和文件名的写法不同，前者是 '.' 后者是 '/'

<div align="center"> <img src="image-20200508202949069.png" width="100%"/> </div><br>


并在 `dao` 的接口增加注解

<div align="center"> <img src="image-20200508203328827.png" width="50%"/> </div><br>


可见使用注解配置比 `XML` 要更方便





### 3.3 踩坑记录

#### 3.3.1 Timezone

<div align="center"> <img src="image-20200509232126129.png" width="100%"/> </div><br>

**原因**

<div align="center"> <img src="image-20200509232720408.png" width="100%"/> </div><br>

**解决方案**

```java
jdbc:mysql://localhost:3306/mybatis?serverTimezone=GMT
```



## 4. MyBatis 的 CRUD

### 4.1 插入操作

在 `dao` 接口类定义方法

<div align="center"> <img src="image-20200509234101205.png" width="60%"/> </div><br>

在映射配置文件中编写 `sql` 语句

<div align="center"> <img src="image-20200509234848482.png" width="100%"/> </div><br>

> :bulb:**Tips:**
>
> `#{}` 填属性名称



编写测试类 `UserDaoTest`

<div align="center"> <img src="image-20200510000155678.png" width="80%"/> </div><br>

我们将初始化以及关闭资源方法抽取出来，让测试方法更专注于 `CRUD` 本身

`init` 方法
<div align="center"> <img src="image-20200510000318818.png" width="100%"/> </div><br>

`destroy` 方法
<div align="center"> <img src="image-20200510000656867.png" width="80%"/> </div><br>

> **什么是事务？**





:heavy_check_mark:添加成功

<div align="center"> <img src="image-20200510000921216.png" width="60%"/> </div><br>