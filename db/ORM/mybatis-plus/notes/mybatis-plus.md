# MyBatis Plus

<div align="center"> <img src="logo.png" width="60%"/> </div><br>




Table of Contents
-----------------

* [前期准备](#前期准备)
* [1. 查询方法](#1-查询方法)
* [2. 自定义 sql](#2-自定义-sql)
* [3. 分页](#3-分页)
* [4. 更新 &amp; 删除](#4-更新--删除)
* [5. AR 模式 &amp; 主键策略](#5-ar-模式--主键策略)
* [6. 通用 service](#6-通用-service)
* [7. 逻辑删除](#7-逻辑删除)
* [8. 自动填充](#8-自动填充)
* [9. 乐观锁](#9-乐观锁)
* [10. 性能分析](#10-性能分析)
* [11. 多租户](#11-多租户)
* [12. 动态表](#12-动态表)
* [13. SQL 注入器](#13-sql-注入器)
* [参考链接](#参考链接)


## 前期准备

建表：

```sql
SHOW DATABASES;

CREATE DATABASE mp;

USE mp;

-- 创建用户表
CREATE TABLE user (
  id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '主键',
  name VARCHAR(30) DEFAULT NULL COMMENT '姓名',
  age INT(11) DEFAULT NULL COMMENT '年龄',
  email VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  manager_id BIGINT(20) DEFAULT NULL COMMENT '直属上级id',
  create_time DATETIME DEFAULT NULL COMMENT '创建时间',
  CONSTRAINT manager_fk FOREIGN KEY (manager_id)
  REFERENCES user (id)
)  ENGINE=INNODB CHARSET=UTF8;

-- 初始化数据：
INSERT INTO user (id, name, age, email, manager_id
                  , create_time)
VALUES (1087982257332887553, '大boss', 40, 'boss@baomidou.com', NULL
        , '2019-01-11 14:20:20'),
	(1088248166370832385, '王天风', 25, 'wtf@baomidou.com', 1087982257332887553
   , '2019-02-05 11:12:22'),
	(1088250446457389058, '李艺伟', 28, 'lyw@baomidou.com', 1088248166370832385
   , '2019-02-14 08:31:16'),
	(1094590409767661570, '张雨琪', 31, 'zjq@baomidou.com', 1088248166370832385
   , '2019-01-14 09:15:15'),
	(1094592041087729666, '刘红雨', 32, 'lhm@baomidou.com', 1088248166370832385
   , '2019-01-14 09:48:16');
```

<div align="center"> <img src="image-20200826100803752.png" width="80%"/> </div><br>

引入依赖：

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
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
  <!-- https://mvnrepository.com/artifact/com.baomidou/mybatis-plus -->
  <dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus</artifactId>
    <version>3.3.2</version>
  </dependency>

</dependencies>
```

数据源配置：

```yaml
#用来控制使用哪个配置文件deve/prod 开发环境/生产环境
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mp?useSSL=false&serverTimezone=GMT%2B8&allowMultiQueries=true&autoReconnect=true&characterEncoding=utf-8
    username: root
    password: yourpassword

#日志配置:trace,最低级别日志输出
logging:
  level:
    #    root: info
    root: warn
    com.lf.mp.dao: trace
```





## 1. 查询方法



## 2. 自定义 sql 

## 3. 分页

## 4. 更新 & 删除

## 5. AR 模式 & 主键策略

## 6. 通用 service

## 7. 逻辑删除

## 8. 自动填充

## 9. 乐观锁

## 10. 性能分析

## 11. 多租户

## 12. 动态表

## 13. SQL 注入器





## 参考链接

- [MyBatis-Plus](https://baomidou.com/)
- [【最新版】4小时学会MyBatis Plus通俗易懂，从入门到部署上线 - 楠哥教你学Java](https://www.bilibili.com/video/BV1yA411t782?p=1)
- [MyBatis-Plus入门](https://www.imooc.com/learn/1130)
- [MyBatis-Plus进阶](https://www.imooc.com/learn/1171)
- [国内钟情于Mybatis，而国外却喜欢Hibernate/JPA，为啥](https://itworld520.com/2020/01/12/%E5%9B%BD%E5%86%85%E9%92%9F%E6%83%85%E4%BA%8Emybatis%EF%BC%8C%E8%80%8C%E5%9B%BD%E5%A4%96%E5%8D%B4%E5%96%9C%E6%AC%A2hibernate-jpa%EF%BC%8C%E4%B8%BA%E5%95%A5%EF%BC%9F/)
- [Mac下Mysql服务启动/停止/重启](https://juejin.im/post/6844903956305412104)
