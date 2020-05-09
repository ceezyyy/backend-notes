# MyBatis
<div align="center"> <img src="logo.png" width="60%"/> </div><br>

## Category

  * [What is MyBatis](#what-is-mybatis)
  * [Why we use MyBatis](#why-we-use-mybatis)
  * [Quickstart](#quickstart)
    + [使用 XML 配置](#---xml---)
    + [使用注解配置](#------)
    + [Quickstart 中的设计模式](#quickstart-------)



## 1. What is MyBatis

`MyBatis` 是一个用 Java 编写的持久层框架，



## 2. Why we use MyBatis

开发中讲究极简编程，让开发者更专注于开发本身，`MyBatis` 帮我们封装了许多底层实现，让我们更专注于开发



## 3. Quickstart

### 3.1 使用 XML 配置

1. 创建 `Maven` 工程，添加依赖


<div align="center"> <img src="image-20200508182849525.png" width="80%"/> </div><br>

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

**Hello World Demo**

```java
public class UserDaoTest {
    public static void main(String[] args) throws IOException {
        // load config
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // create sqlsession factory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // create sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // generate mapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // execute
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);
        }
        // close
        sqlSession.close();
        inputStream.close();
    }
}

```



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



### 3.3 Quickstart 中的设计模式

<div align="center"> <img src="image-20200509094736676.png" width="100%"/> </div><br>


1. 加载主配置文件

   `mybatis` 既然是持久层框架，必然得和数据库打交道。在主配置文件中，包含了数据库相关的信息，例如驱动，端口和数据库名称，登录账号以及密码

   <div align="center"> <img src="image-20200509102122580.png" width="100%"/> </div><br>
   有了它，就可以有 `Connection` 对象
   
<div align="center"> <img src="image-20200509102208165.png" width="70%"/> </div><br>
   
   
   

   此外，（在主配置文件中）还得告诉 `mybatis` 是以注解还是以 `xml` 方式配置映射文件的，注意路径写法的不同
   
   
   
   其中：
   
   ```java
   Resources.getResourceAsStream(resource);
   ```
   <div align="center"> <img src="image-20200509100027487.png" width="100%"/> </div><br>
   
2. 创建 `sqlsession` 工厂

   

