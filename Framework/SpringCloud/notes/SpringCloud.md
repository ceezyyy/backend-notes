# Spring Cloud Quickstart

<div align="center"> <img src="logo.png" width="60%"/> </div><br>

## Category

* [0. References](#0-references)
* [1. 单体应用存在的问题](#1----------)
* [2. 分布式架构](#2------)
* [3. 什么是微服务](#3-------)
* [4. 服务治理 Eureka](#4------eureka)
  + [4.1 Quickstart](#41-quickstart)





## 0. References

- [Spring Cloud从入门到实战 - bilibili](https://www.bilibili.com/video/BV1p4411K7pz)
- [Introduction to Spring Cloud Netflix – Eureka](https://www.baeldung.com/spring-cloud-netflix-eureka)

<div align="center"> <img src="microservices.png" width="60%"/> </div><br>

<div align="center"> <img src="pic.jpg" width="60%"/> </div><br>



## 1. 单体应用存在的问题

- 随着开发越来越复杂，模块之间的耦合度也更高
- 当需要修改时，需要重新测试，重新部署
- 一个模块出现问题，容易导致整个系统崩溃
- 各个模块使用同一种技术框架开发，灵活性低



## 2. 分布式架构

将一个复杂问题拆分成若干个小问题，即将一个大型项目拆分成若干个微服务，分而治之
<div align="center"> <img src="mm.png" width="50%"/> </div><br>



## 3. 什么是微服务

<div align="center"> <img src="newmm.png" width="80%"/> </div><br>

**优点**

- 独立开发，独立部署，互不影响
- 加入新需求时较方便，只需添加新的微服务
- 只需提供服务，接口供调用，而不关心是如何实现（可以使用不同语言框架）

**缺点**

- 如何将复杂的大项目拆分成不同的微服务
- 调用接口时需找到服务提供方，会造成沟通成本
- 多个微服务访问数据库时的一致性问题



## 4. 服务治理 Eureka

三大重要组件：

- 服务提供者（外卖商家）
- 服务消费者（消费者）
- 注册中心（外卖平台饿了么）

<div align="center"> <img src="image-20200614212638252.png" width="70%"/> </div><br>

两个概念：

- 服务注册：服务提供者将服务信息存入注册中心

- 服务发现：服务消费者到注册中心查询相关服务



### 4.1 Eureka Server 注册中心

创建父工程 `springcloudall`

**pom.xml**

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.6.RELEASE</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Finchley.SR2</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

创建子工程 `eurekaserver`

**pom.xml**

```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-server -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

添加配置

**application.yml**

```yaml
server:
  port: 8761
eureka:
  client:
    registerWithEureka: false
    fetchRegistry: false
```

`port` 指定注册中心的端口号

`registerWithEureka` 为 `false` 是指不注册自己（作为 `server`）

编写启动类

**EurekaServerApplication.java**

```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

:hammer: ​ BUILD 

:heavy_check_mark: SUCCEEDED!

<div align="center"> <img src="image-20200615121528370.png" width="100%"/> </div><br