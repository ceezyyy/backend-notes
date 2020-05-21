# Spring MVC

## 目录

* [1. Wiki](#1-wiki)
  + [1.1 What is Spring mvc?](#11-what-is-spring-mvc-)
  + [1.2 Understanding the flow of Spring Web MVC](#12-understanding-the-flow-of-spring-web-mvc)
  + [1.3 Advantages of Spring MVC Framework](#13-advantages-of-spring-mvc-framework)
* [2. Quickstart](#2-quickstart)
  + [2.1 项目需求](#21-----)
  + [2.2 项目结构](#22-----)
  + [2.3 步骤](#23---)
  + [2.4 总结](#24---)
    - [2.4.1 组件化开发思想](#241--------)
    - [2.4.2 为什么要有 web.xml?](#242-------webxml-)
    - [2.4.3 为什么要有 spring-servlet.xml?](#243-------spring-servletxml-)
* [3. 请求参数的绑定](#3--------)
  + [3.1 Quickstart](#31-quickstart)
    - [3.1.1 基本类型](#311-----)
    - [3.1.2 Java Bean 类型](#312-java-bean---)
    - [3.1.3 Collection 类型](#313-collection---)
    - [3.1.4 总结](#314---)





## 1. Wiki

### 1.1 What is Spring mvc?

A Spring MVC is a Java framework which is used to build web applications. It follows the Model-View-Controller design pattern. It implements all the basic features of a core spring framework like Inversion of Control, Dependency Injection.

A Spring MVC provides an elegant solution to use MVC in spring framework by the help of  **DispatcherServlet**. Here, **DispatcherServlet** is a class that receives the incoming request and maps it to the right resource such as controllers, models, and views.



<div align="center"> <img src="spring-web-model-view-controller.png" width="50%"/> </div><br>



### 1.2 Understanding the flow of Spring Web MVC
<div align="center"> <img src="1.png" width="80%"/> </div><br>

- As displayed in the figure, all the incoming request is intercepted by the DispatcherServlet that works as the front controller.
- The DispatcherServlet gets an entry of handler mapping from the XML file and forwards the request to the controller.
- The controller returns an object of ModelAndView.
- The DispatcherServlet checks the entry of view resolver in the XML file and invokes the specified view component.



### 1.3 Advantages of Spring MVC Framework

- **Separate roles** - The Spring MVC separates each role, where the model object, controller, command object, view resolver, DispatcherServlet, validator, etc. can be fulfilled by a specialized object.
- **Light-weight** - It uses light-weight servlet container to develop and deploy your application.
- **Powerful Configuration** - It provides a robust configuration for both framework and application classes that includes easy referencing across contexts, such as from web controllers to business objects and validators.
- **Rapid development** - The Spring MVC facilitates fast and parallel development.
- **Reusable business code** - Instead of creating new objects, it allows us to use the existing business objects.
- **Easy to test** - In Spring, generally we create JavaBeans classes that enable you to inject test data using the setter methods.
- **Flexible Mapping** - It provides the specific annotations that easily redirect the page.



## 2. Quickstart

### 2.1 项目需求

<div align="center"> <img src="image-20200521203418242.png" width="50%"/> </div><br>

<div align="center"> <img src="image-20200521203512528.png" width="50%"/> </div><br>


### 2.2 项目结构

<div align="center"> <img src="image-20200521201609117.png" width="35%"/> </div><br>

### 2.3 步骤

<div align="center"> <img src="1.png" width="80%"/> </div><br>

- `pom.xml`：搭建环境（这里使用 `tomcat 7` 的 plugin 直接部署）
- `web.xml`：配置 `DispatcherServlet`
- `HandlerMapping & Controller`：编写 `controller` 函数方法
- `springmvc.xml`：编写 `ViewResolver`，以及开启 `mvc annotation`
- `view`：跳转成功的页面



**index.jsp**

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quickstart</title>
</head>
<body>
<h1>Quickstart</h1>
<a href="hello">Hello</a>
</body>
</html>
```

**pom.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ceezyyy</groupId>
    <artifactId>SpringmvcQuickstart</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <name>SpringmvcQuickstart Maven Webapp</name>
    <!-- FIXME change it to the project's website -->
    <url>http://www.example.com</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
    </properties>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->


    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-web -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>5.2.5.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>5.2.5.RELEASE</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.1.5.RELEASE</version>
        </dependency>

    </dependencies>

    <build>
        <finalName>SpringmvcQuickstart</finalName>
        <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
            <plugins>
                <plugin>
                    <groupId>org.apache.tomcat.maven</groupId>
                    <artifactId>tomcat7-maven-plugin</artifactId>
                    <version>2.2</version>
                    <configuration>
                        <port>9090</port>
                    </configuration>
                </plugin>


                <plugin>
                    <artifactId>maven-clean-plugin</artifactId>
                    <version>3.1.0</version>
                </plugin>
                <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
                <plugin>
                    <artifactId>maven-resources-plugin</artifactId>
                    <version>3.0.2</version>
                </plugin>
                <plugin>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.8.0</version>
                </plugin>
                <plugin>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>2.22.1</version>
                </plugin>
                <plugin>
                    <artifactId>maven-war-plugin</artifactId>
                    <version>3.2.2</version>
                </plugin>
                <plugin>
                    <artifactId>maven-install-plugin</artifactId>
                    <version>2.5.2</version>
                </plugin>
                <plugin>
                    <artifactId>maven-deploy-plugin</artifactId>
                    <version>2.8.2</version>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
</project>

```

**web.xml**

```xml
<!DOCTYPE web-app PUBLIC
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
    <display-name>Archetype Created Web Application</display-name>

    <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

**HelloController.java**

```java
@Controller("HelloController")
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        System.out.println("Hello Spring mvc");
        return "Succeeded";
    }
}
```

**spring-servlet.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!-- Provide support for component scanning -->
    <context:component-scan base-package="com.ceezyyy.controller"/>

    <!--Provide support for conversion, formatting and validation -->
    <mvc:annotation-driven/>

    <bean id="internalResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/pages/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>

</beans>
```

**Succeeded.jsp**

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Succeeded</title>
</head>
<body>
<h1>Congratulations! Succeeded!</h1>
</body>
</html>
```



### 2.4 总结

#### 2.4.1 组件化开发思想

- `DispatcherServlet`

  定义在 `web.xml` 中，角色相当于篮球场上的组织控卫，负责总体调度
  
  <div align="center"> <img src="lbj.jpg" width="50%"/> </div><br>


- `HandlerMapping` 

  可以使用注解的方式定义在 `controller` 中，作用是将 `url` 的参数 `map` 到对应的 `controller` 业务逻辑（方法），并返回给 `Dispatcher`，`Dispatcher` 再（根据返回结果）找特定的 `controller`

  <div align="center"> <img src="image-20200521210008872.png" width="50%"/> </div><br>
  
  <div align="center"> <img src="image-20200521210151962.png" width="80%"/> </div><br>


- `Controller`

  处理各种逻辑

- `ViewResolver`

  解析 `controller` 返回的 `view`，并返回给 `Dispatcher`，再转发到特定的 `page`

- `View`

  视图，呈现在浏览器中



#### 2.4.2 为什么要有 web.xml?

<div align="center"> <img src="image-20200521205756799.png" width="80%"/> </div><br>

**需要加载 spring-servlet 配置文件！！！**


<div align="center"> <img src="image-20200521212829302.png" width="80%"/> </div><br>


#### 2.4.3 为什么要有 spring-servlet.xml?

<div align="center"> <img src="image-20200521205853074.png" width="80%"/> </div><br>

## 3. 请求参数的绑定

### 3.1 Quickstart

#### 3.1.1 基本类型

<div align="center"> <img src="image-20200521232020693.png" width="30%"/> </div><br>

**index.jsp**

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quickstart</title>
</head>
<body>
<h1>Quickstart</h1>
<form action="hello" method="post">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br>
    <label for="age">Age:</label><br>
    <input type="text" id="age" name="age"><br>
    <input type="submit" value="submit"><br>
</form>

</body>
</html>
```



**HelloController.java**

```java
@Controller("HelloController")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public void hello(String username, String password, Integer age) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
    }
}
```



:heavy_check_mark:Succeeded!

<div align="center"> <img src="image-20200521232219793.png" width="50%"/> </div><br>

#### 3.1.2 Java Bean 类型


<div align="center"> <img src="image-20200521232803254.png" width="30%"/> </div><br>

**index.jsp**

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quickstart</title>
</head>
<body>
<h1>Quickstart</h1>
<form action="hello" method="post">
    <label for="accountId">AccountId:</label><br>
    <input type="text" id="accountId" name="id"><br>
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="money">Money:</label><br>
    <input type="text" id="money" name="money"><br>
    <input type="submit" value="submit"><br>
</form>

</body>
</html>
```



**HelloController.java**

```java
@Controller("HelloController")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public void hello(Account account) {
        System.out.println(account.getId());
        System.out.println(account.getUsername());
        System.out.println(account.getMoney());
    }
}
```



:heavy_check_mark:Succeeded!

<div align="center"> <img src="image-20200521233109870.png" width="30%"/> </div><br>

#### 3.1.3 Collection 类型



#### 3.1.4 总结

- 参数类型是以 `key-value` 形式，从浏览器发来的请求参数都是 `string` 类型
- 