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
  + [4.2 更新操作](#42-----)
  + [4.3  删除操作](#43------)
  + [4.4 查询操作](#44-----)
  + [4.5 参数 & 结果集深入](#45-----------)
  + [4.6 别名](#46---)
* [5. MyBatis 连接池及事务控制](#5-mybatis---------)
* [6. 基于 XML 配置的动态 sql 查询](#6----xml-------sql---)
* [7. MyBatis 多表操作](#7-mybatis-----)




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

在映射配置文件中编写 `sql` 语句（让 `mybatis` 框架帮你创建代理对象实现）

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

> **:bulb:事务**



**什么是事务？**

如果一个包含多个步骤的业务操作被事务管理，则他们要不同时成功，要不同时失败

**事务操作**

- 开启事务
- 回滚
- 提交

**事务四大特征（需记忆）**

1. 原子性
2. 持久性
3. 隔离性
4. 一致性

举个例子，小明和小红各有 1000 元，现在小明要向小红转帐 500 元，则有以下业务操作：

1. 判断小明账户是否大于 500 元（不够钱当然没法转帐）

2. 小明账户减去 500 元

3. 小红账户加上 500 元

   

若以上业务操作没有被事务管理：当第二步之后出现问题了，小明账户的钱少了，但是小红账户却没有收到钱，造成了 500 元不翼而飞，显然这在现实生活中是不可容忍的



反之，若业务操作被事务管理，当其中的步骤出现问题，事务会回滚，即恢复到最初状态；若没有出现问题，最终会提交，永久存储（写入硬盘）



:heavy_check_mark:添加成功

<div align="center"> <img src="image-20200510000921216.png" width="60%"/> </div><br>

### 4.2 更新操作

1. 在 `dao` 接口定义方法


   <div align="center"> <img src="image-20200510113243656.png" width="60%"/> </div><br>

2. 在映射配置文件中编写 `sql` 语句，让 `mybatis` 框架为我们创建代理对象

```xml
    <update id="updateUser" parameterType="com.ceezyyy.domain.User">
        update user set username = #{username}, birthday = #{birthday}, sex = #{sex}, address = #{address} where id = #{id};
    </update>
```

3. 在测试类中执行方法，查看结果

   
    <div align="center"> <img src="image-20200510113411291.png" width="60%"/> </div><br>

4. :heavy_check_mark:更新成功


<div align="center"> <img src="image-20200510111358671.png" width="60%"/> </div><br>

### 4.3  删除操作

1. 在 `dao` 接口中定义方法


<div align="center"> <img src="image-20200510112422979.png" width="60%"/> </div><br>
2. 在映射配置文件中编写 `sql` 语句，让 `mybatis` 框架为我们创建代理对象

```xml
   <delete id="deleteUserById" parameterType="integer">
        delete from user where id = #{id};
    </delete>
```

3. 在测试类中执行方法，查看结果

<div align="center"> <img src="image-20200510113629693.png" width="80%"/> </div><br>

4. :heavy_check_mark:删除成功

   

> **:warning:注意**
>
> 当参数只有一个的时候，`#{}` 里面的名称不作强求
>
> `parameterType` 中，



### 4.4 查询操作

1. `dao` 接口定义方法


<div align="center"> <img src="image-20200510113024978.png" width="60%"/> </div><br>
2. 在映射配置文件编写 `sql` 语句，让 `mybatis` 为我们创建实现类

```xml
    <select id="findUserById" parameterType="integer" resultType="com.ceezyyy.domain.User">
        select * from user where id = #{id};
    </select>
```

3. 在测试类中执行语句，查看结果


<div align="center"> <img src="image-20200510113119036.png" width="60%"/> </div><br>

4. :heavy_check_mark:查询成功

<div align="center"> <img src="image-20200510112945059.png" width="80%"/> </div><br>




**模糊查询**

1. `dao` 接口中定义方法
<div align="center"> <img src="image-20200510114116223.png" width="60%"/> </div><br>


2. 在映射配置文件编写 `sql` 语句，让 `mybatis` 为我们创建实现类

   ```xml
       <select id="findUserByName" parameterType="string" resultType="com.ceezyyy.domain.User">
           select * from user where username like #{username};
       </select>
   ```

   `resultType` 代表需要封装的结果对象


3. 在测试类中执行语句，查看结果
<div align="center"> <img src="image-20200510114312399.png" width="60%"/> </div><br>

> **:warning:注意**
>
> 模糊查询的需在传入参数时指定`%`，`*` 等符号

4. :heavy_check_mark:查询成功

<div align="center"> <img src="image-20200510114453626.png" width="80%"/> </div><br>

**聚合函数**

1. `dao` 接口中定义方法

   <div align="center"> <img src="image-20200510121002281.png" width="50%"/> </div><br>

2. 在映射配置文件编写 `sql` 语句，让 `mybatis` 为我们创建实现类

   ```xml
       <select id="findTotal" resultType="integer">
           select count(*) from user;
       </select>
   ```

3. 在测试类中执行语句，查看结果

   <div align="center"> <img src="image-20200510120946065.png" width="60%"/> </div><br>

4. :heavy_check_mark:查询成功

   <div align="center"> <img src="image-20200510121013728.png" width="40%"/> </div><br>



### 4.5 参数 & 结果集深入

- `id`：方法名

- `parameterType`：参数类型

  当参数为 JavaBean 时，`#{}` 里面的内容为实体类属性值

- `resultType`：结果类型

- `resultMap`：查询结果的列名与实体类属性的对应关系（用于列名与属性名不一致的情况）

  >  **:warning:注意**
  >
  > `resultType` 和 `resultMap` 只能二选一！

### 4.6 别名

<div align="center"> <img src="image-20200510131557743.png" width="80%"/> </div><br>


通过 `typeAliases` 设置别名，达到简化开发的效果

当参数是基本类型或者是包装类型时，我们可以直接写 `int`，`integer` 等等，都是基于这个原理

<div align="center"> <img src="image-20200510131618183.png" width="90%"/> </div><br>



## 5. MyBatis 连接池及事务控制









## 6. 基于 XML 配置的动态 sql 查询

用 `<where>` 以及 `<if test>` 标签可以实现动态查询

![image-20200510155212535](image-20200510155212535.png)

在 `sql` 语句中，凡是 `#{}` 里面的值都是 `mybatis` 通过反射寻找出来的属性（值)，这种特殊的语法省略了 `get` 关键字。

  <div align="center"> <img src="image-20200510153457044.png" width="80%"/> </div><br>


**:warning:注意**

  <div align="center"> <img src="image-20200510153837141.png" width="80%"/> </div><br>

若将 `<if test>` 标签中的属性值故意改错，则会报错

  <div align="center"> <img src="image-20200510153933281.png" width="100%"/> </div><br>



## 7. MyBatis 多表操作

