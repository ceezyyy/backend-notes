

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
* [5. MyBatis 连接池及事务控制](#5-mybatis---------)
* [6. 基于 XML 配置的动态 sql 查询](#6----xml-------sql---)
  + [6.1 where 和 if 的使用](#61-where---if----)
  + [6.2 for each 的使用](#62-for-each----)
* [7. MyBatis 多表操作](#7-mybatis-----)
  + [7.1 一对一关联](#71------)
  + [7.2 一对多](#72----)
  + [7.3 多对多](#73----)




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

​	在 `MyBatis` 中，当选择一个查询进行映射时，返回类型可以是结果类型或结果映射，结果类型可以是返回类型的直接表示，而结果映射是对外部的 `ResultMap` 的引用，但结果类型和结果映射不能同时存在。当 `MyBatis` 执行查询映射时，实际上，每个被查询的属性都会被放置在对应的 `Map` 中，其中 `key` 是属性名，`value` 是其对应的值。当所提供的返回类型属性为 `resultType` 时，`MyBatis` 会将 `Map` 中的 `key-value` 对取出，并将相应的属性分配给 `resultType` 指定的对象。所以实际上，`MyBatis` 的每一个查询映射都是 `ResultMap`，但是当我们提供的返回类型属性为 `resultType` 时，`MyBatis` 会自动将相应的值分配给由 `resultType` 指定的对象的属性。当我们提供的返回类型为 `resultMap` 时，因为 `Map` 不能很好的表示域模型，所以需要我们自己。进一步将其转换为相应的对象，在复杂的查询中往往很有用。



举个例子

**Blog.java**

```java
import java.util.List;

public class Blog {
    private int id;
    private String title;
    private String content;
    private String owner;
    private List<Comment> comments;

    //getter and setter methods
}
```



**SQL Mapping file BlogMapper.xml**

`resultType` 类型：

```xml
<typeAlias alias="Blog" type="com.tiantian.mybatis.model.Blog"/>
<select id="selectBlog" parameterType="int" resultType="Blog">
        select * from t_blog where id = #{id}
</select><!--Come from SQL Mapping file BlogMapper.xml-->
```

`resultMap` 类型：


```xml
<resultMap type="Blog" id="BlogResult">
    <id column="id" property="id"/>
    <result column="title" property="title"/>
    <result column="content" property="content"/>
    <result column="owner" property="owner"/>
</resultMap>
<select id="selectBlog" parameterType="int" resultMap="BlogResult">
    select * from t_blog where id = #{id}
</select>
```



- `typeAlias` ：别名

  **那有什么用？**

  我们知道，必须写出全限定类名，`mybatis` 才能找到相应的类和对应的方法，但在实际开发中，预先定义好类名，可以起到简化的作用

- `parameterType` ：传入参数的类型

- `resultType`：封装结果类型（用于简单情况以及封装结果对象属性与数据库列名一致的情况）

- `resultMap`：封装结果映射

- `resultMap` 十分强大

举个例子

假如我们的 `Blog` 实体类对象的属性名与数据库列名不一致：

```java
import java.util.List;
  
public class Blog {
    private int blogId;
    private String blogTitle;
    private String blogContent;
    private String blogOwner;
    private List<Comment> comments;
  
      //getter and setter methods
}
```

那我们应该手动编写一个 `resultMap`：

```xml
<resultMap type="Blog" id="BlogResult">
    <id column="id" property="blogId"/>
    <result column="title" property="blogTitle"/>
    <result column="content" property="blogContent"/>
    <result column="owner" property="blogOwner"/>
</resultMap>
```

做一个简单的字段映射

并将查询语句中改为 `resultMap`：

```xml
<select id="selectBlog" parameterType="int" resultMap="BlogResult">
    select * from t_blog where id = #{id}
</select>
```

当然，这是最简单的映射







## 5. MyBatis 连接池及事务控制









## 6. 基于 XML 配置的动态 sql 查询

### 6.1 where 和 if 的使用

用 `<where>` 以及 `<if test>` 标签可以实现动态查询

<div align="center"> <img src="image-20200510212329012.png" width="100%"/> </div><br>

其实很简单，`#{}` 代表参数占位符，我们的参数类型是 `user`

`#{username}` 就相当于 `User.getUsername()` ，只不过省略了 `get` 关键字以及 `User` 变量（因为在 `parameterType` 已经声明了）



### 6.2 for each 的使用

首先我们先定义一个 `Query` 对象，也称为复合查询对象。对于复杂查询的结果，可能不止一个类

<div align="center"> <img src="image-20200510214216119.png" width="70%"/> </div><br>

其中 `ids` 集合定义为要查询的 `id` 集合

接着我们在 `dao` 接口定义根据用户 `id` 查找用户方法


<div align="center"> <img src="image-20200510214443255.png" width="70%"/> </div><br>

编写映射配置文件，交给 `mybatis` 来帮我们完成

<div align="center"> <img src="image-20200510214555399.png" width="100%"/> </div><br>

我们原先的数据库语句应该为：

```sql
select * from user where id in (id1, id2, ..., idn)
```

这里也一样，用 `<where>` 标签取代了 `where` 关键字

- `<for each>` 取代了 后面的部分

- `open` 代表开头， `close` 代表结尾

- `separator` 代表分隔符（显然这里是逗号分隔）

- `collections` 代表要遍历的集合，也就是我们 `query` 下的 `ids` 属性（相当于 `query.getIds()`）

- `item` 代表单个变量，用`#{item}` 来获取每次遍历的值

这点和 `python` 下的 `for loop` 很像

```python
for a in A:
	print(a)
```



## 7. MyBatis 多表操作

多表操作，字如其名，涉及到多张表。多表操作中有以下几种关系

- **一对一**

  一个人只能有一个身份证号

  一个身份证号只能属于同一个人

- **一对多**

  一个用户可以有多张订单 / 账号

- **多对一**

  多个订单 / 账号属于同一个用户

  （在 `mybatis` 中 "多对一" 属于一对一，因为每张订单 / 账号属于一个用户）

- **多对多**

  一个学生可以选多门课程

  一门课程也可以由多门学生来上
  
  

### 7.1 一对一关联

**背景：**

用户与账号。生活中一个用户可以有多个微信账号 / 多张银行卡

**输出：**

1. 当查询用户时，可以得到所有该用户下包含的账户信息
2. 当查询账户时，可以得到账户所属用户信息



**需求一：查询账户时，获得账户所属用户信息**





<div align="center"> <img src="image-20200510232339124.png" width="60%"/> </div><br>



`sql` 语句如下：

```sql
USE mybatis;
SELECT 
	a.id as aid, 
	a.UID as uid,
	a.MONEY as money,
	u.*
FROM
	user u, account a 
WHERE
	u.id = a.UID;
```

这是我们预期的结果：

<div align="center"> <img src="image-20200511162605961.png" width="60%"/> </div><br>


那么如何让 `mybatis` 来完成呢？



**Account.java**

```java
public class Account implements Serializable {
    private Integer ID;
    private Integer UID;
    private Double MONEY;

    // find the info of USER by account
    private User user;
    
    // getter and setter
```

要想通过查询账户获得所属用户信息，我们得在 `account` 增加 `User` 实体类属性

这时，如果单单的 `resultType = account` 已经不能满足我们了（因为查询结果对象是 `account` 的话，我们无法获取 `user` 实体类详细的属性）



此时，强大的 `resultMap` 就出现了！

我们在 `resultMap` 中定义关联对象，`javaType` 的作用是告诉 `mybatis` 查询后封装的对象

```xml
<resultMap id="accountUserMap" type="account">
        <id property="id" column="aid"></id>
        <result property="uid" column="uid"></result>
        <result property="money" column="money"></result>
        <association property="user" column="uid" javaType="user">
            <id property="id" column="id"></id>
            <result property="username" column="username"></result>
            <result property="birthday" column="birthday"></result>
            <result property="sex" column="sex"></result>
            <result property="address" column="address"></result>
        </association>
</resultMap>
```

:heavy_check_mark:查询成功


<div align="center"> <img src="image-20200511170218636.png" width="100%"/> </div><br>


### 7.2 一对多

**需求二：查询所有用户名下所有账户信息**

不管用户用没有账号，都需显示，所以我们要用左（外连接）

> :bulb: **三张图彻底搞懂内连接，左连接，右连接**
>
> **内连接**
>
> ```sql
> select * from a_table a inner join b_table bon a.a_id = b.b_id;
> ```
>
> <div align="center"> <img src="20171209135846780.png" width="70%"/> </div><br>
> 
> **左（外）连接**
>
> ```sql
> select * from a_table a left join b_table bon a.a_id = b.b_id;
> ```
><div align="center"> <img src="20171209142610819.png" width="70%"/></div><br>
>
> **右（外）连接**
>
> ```sql
> select * from a_table a right outer join b_table b on a.a_id = b.b_id;
> ```
><div align="center"> <img src="20171209144056668.png" width="70%"/></div><br>



**数据库查询语句**

<div align="center"> <img src="image-20200511204027426.png" width="100%"/></div><br>

**User.java**

```java
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    // the total accounts of specific user
    private List<Account> accountList;
    
    // getter and setter
```

**UserDao.xml**

```xml
    <resultMap id="userAccountMap" type="User">
        <id property="id" column="id"></id>
        <result property="username" column="username"></result>
        <result property="birthday" column="birthday"></result>
        <result property="sex" column="sex"></result>
        <result property="address" column="address"></result>
        <collection property="accountList" ofType="account">
            <id property="id" column="aid"></id>
            <result property="uid" column="uid"></result>
            <result property="money" column="money"></result>
        </collection>
    </resultMap>

    <select id="findAllAccountsOfUser" resultMap="userAccountMap">
    SELECT
	    u.*,
	    a.ID as aid,
	    a.UID as uid,
	    a.MONEY as money
    FROM
	    user u
    LEFT JOIN
	    account a
    ON
	u.id = a.uid
    </select>

```

其中  `collection`  代表集合映射，也就是一对多中的"多"，`ofType` 代表封装的对象

对于重复元素，`mybatis` 会自动封装（太强大了！）



:heavy_check_mark:测试成功

<div align="center"> <img src="image-20200511205914752.png" width="90%"/> </div><br>



### 7.3 多对多

