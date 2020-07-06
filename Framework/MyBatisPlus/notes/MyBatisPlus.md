# MyBatis Plus

<div align="center"> <img src="logo.png" width="80%"/> </div><br>

## 目录

* [1. Quickstart](#1-quickstart)
  + [1.1 添加依赖](#11-----)
  + [1.2 配置文件](#12-----)
  + [1.3 数据库](#13----)
  + [1.4 实体类](#14----)
  + [1.5 Mapper](#15-mapper)
  + [1.6 Test](#16-test)







## 1. Quickstart

### 1.1 添加依赖

**pom.xml**

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!--mybatis-plus-->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.3.2</version>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
        <exclusions>
            <exclusion>
                <groupId>org.junit.vintage</groupId>
                <artifactId>junit-vintage-engine</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>
```

### 1.2 配置文件

```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8

mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```



### 1.3 数据库

**创建数据表**

```sql
create table user(
    id int primary key auto_increment,
    username varchar(20),
    age int
)
```



**插入数据**

```sql
insert into user(id, username, age)
values (null, "张三", 11);

insert into user(id, username, age)
values (null, "李四", 12);

insert into user(id, username, age)
values (null, "王五", 13);
```



<div align="center"> <img src="image-20200706171731983.png" width="50%"/> </div><br>

**填坑指南**

遇到中文无法插入问题，修改数据表的字符集

```sql
alter table user convert to character set utf8 ; 
```

### 1.4 实体类

**User.java**

```
@Data
public class User {
    private Integer id;  // pk
    private String username;
    private Integer age;
}
```

### 1.5 Mapper

**UserMapper.java**

```java
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
```

其中，泛型填的是实体类类型

<div align="center"> <img src="image-20200706172329333.png" width="60%"/> </div><br>

### 1.6 Test

```java
@SpringBootTest
class UserMapperTest {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // find all
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users);
        }
    }
}
```
:heavy_check_mark: Succeeded!

<div align="center"> <img src="image-20200706173432318.png" width="60%"/> </div><br>

<div align="center"> <img src="image-20200706173439382.png" width="80%"/> </div><br>