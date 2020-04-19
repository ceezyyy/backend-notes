# HTTP Protocol

## 1. HTTP 协议

<div align="center"> <img src="logo.png" width="60%"/> </div><br>

### 概念

**`HTTP`协议是 Web 的核心。**



`HTTP` 定义了：

1. 客户端和服务器交换报文的**结构**
2. 进行报文交换的请求方式



### 特点

1. 基于 `TCP` 的运输协议：安全可靠
2. 无状态协议：`HTTP` 服务器不保存任何关于用户请求的消息
3. 默认端口：80



## 2. HTTP 报文格式

### 2.1 Request

#### 2.1.1 预备知识

我们先搞清楚一个概念：

<div align="center"> <img src="image-20200416120953704.png" width="100%"/> </div><br>


当你在`URL`中输入这一串的时候：

`localhost`是主机ip

`8080`是当前进程的端口号（`Tomcat`默认端口是 8080）

`/ServletDemo/`是指当前的虚拟目录（告诉别人你的项目放在哪，这样才可以访问到）



注意，此时是（默认）自动跳转到 `index.jsp`  页面的

<div align="center"> <img src="image-20200416125812624.png" width="40%"/> </div><br>





当你在浏览器网址栏输入：
<div align="center"> <img src="image-20200418212457009.png" width="100%"/> </div><br>

客户端向浏览器发送一个 `request` 请求，请求报文格式由 4 个部分组成：

1. 请求行

2. 请求头

3. 空行

4. 请求体



<div align="center"> <img src="image-20200418213220097.png" width="60%"/> </div><br>

#### 2.1.2 请求行

请求行包括了请求方式，重点了解的是 `GET` 和 `POST` 方法，两者的区别是前者在 `URL` 字段会带有请求对象的标识。

比如：

**GET**

先定义一个表单，指定提交方式为 `GET`：

```html
<form action="/RequestDemo/ServletDemo1" method="get">
```

> 注意：这里的 `RequestDemo/` 是虚拟路径，一般以项目名标识
>
> `ServletDemo1/` 是 Servlet 的路径

<div align="center"> <img src="image-20200419161840057.png" width="40%"/> </div><br>

提交表单之后，`URL` 会显示带有请求对象的标识，且请求体为空。

<div align="center"> <img src="image-20200419163435167.png" width="100%"/> </div><br>


<div align="center"> <img src="image-20200419163525124.png" width="60%"/> </div><br>



**POST**

若提交表单的方式是 `POST` 方法：

```html
<form action="/RequestDemo/ServletDemo1" method="post">
```



点击提交之后，`URL` 没有携带请求参数：


<div align="center"> <img src="image-20200419163714466.png" width="100%"/> </div><br>


这时，**请求体** 派上用场了，请求参数为封装在请求体中：


<div align="center"> <img src="image-20200419163930775.png" width="60%"/> </div><br>



#### 2.1.3 请求头



`Host` ：主机域名

`User-Agent`：你用什么浏览器？

`Accept-language` ：你讲什么语言？



```java
request.getHeader("user-agent");
```



#### 2.1.4 请求体

略。



#### 2.1.5 获取请求参数通用方式

1. 获取参数的 `value` ：

```java
request.getParameter(s);
```

2. 获取所有参数，存储在 `map` 集合中：

```java
Map<String, String[]> parameterMap = request.getParameterMap();
```

**注意**

1. `key`的值是 string 类型，即参数名称
2. `value` 的值是 string 数组类型，因为一个键可能对应多个值



**解决中文乱码问题**

```java
request.setCharacterEncoding("utf-8");
```



#### 2.1.6

#### 2.1.7







### 2.2 Response








