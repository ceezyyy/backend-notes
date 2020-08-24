# Stream

Table of Contents
-----------------





## 1. 什么是 Stream

**Java 8 新特性**

Java 8 API 添加了一个新的抽象称为流 Stream，可以让你以一种声明的方式处理数据。

<div align="center"> <img src="image-20200731171956524.png" width="60%"/> </div><br>

这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。




## 2. 为什么要使用 Stream

方便开发，主要用于集合类（与 `lambda expression` 连用）



## 3. 如何实现 Stream

- 生成流：通过数据源（集合）生成流
- 中间操作：一个流后面可以跟随 0 或多个中间操作，目的是打开流，做出某种程度的数据过滤 / 映射，然后返回一个新的流，交给下一个操作使用
- 终结操作：一个流有且仅有一个终结操作



## 4. Demo

在进行 `demo` 之前需要配置单测和日志

**pom.xml**

```xml
<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
  </dependency>
  <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
  <dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.30</version>
  </dependency>
  <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-simple -->
  <dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>1.7.30</version>
    <scope>test</scope>
  </dependency>
  <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.12</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

### 4.1 filter

















## 参考链接

- [Java 8 Stream](https://www.runoob.com/java/java8-streams.html)
- [Java Streams Tutorial | 2020](https://www.youtube.com/watch?v=Q93JsQ8vcwY)