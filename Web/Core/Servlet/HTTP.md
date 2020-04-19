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

### 2.1 Request 对象

#### 2.1.1 预备知识

我们先搞清楚一个概念：

<div align="center"> <img src="image-20200416120953704.png" width="100%"/> </div><br>


当你在`URL`中输入这一串的时候：

`localhost`是主机ip

`8080`是当前进程的端口号（`Tomcat`默认端口是 8080）

`/ServletDemo/`是指当前的虚拟目录（告诉别人你的项目放在哪，这样才可以访问到）



注意，此时是（默认）自动跳转到 `index.jsp`  页面的

<div align="center"> <img src="image-20200416125812624.png" width="35%"/> </div><br>





当你在浏览器网址栏输入：
<div align="center"> <img src="image-20200418212457009.png" width="100%"/> </div><br>

客户端向浏览器发送一个 `request` 请求，请求报文格式由 4 个部分组成：

1. 请求行

2. 请求头

3. 空行

4. 请求体



<div align="center"> <img src="image-20200418213220097.png" width="55%"/> </div><br>

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

<div align="center"> <img src="image-20200419163525124.png" width="55%"/> </div><br>



**POST**

若提交表单的方式是 `POST` 方法：

```html
<form action="/RequestDemo/ServletDemo1" method="post">
```



点击提交之后，`URL` 没有携带请求参数：


<div align="center"> <img src="image-20200419163714466.png" width="100%"/> </div><br>


这时，**请求体** 派上用场了，请求参数为封装在请求体中：

<div align="center"> <img src="image-20200419163930775.png" width="55%"/> </div><br>



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



#### 2.1.6 请求转发

一种在服务器**内部**转发资源的方式

```java
request.getRequestDispatcher("path").forward(request, response);
```

**特点**

1. 资源内部转发方式，浏览器 `URL` 不发生变化（不能转发到外部，压根找不到）
2. `path` 是指资源内部的路径
3. 一次请求



#### 2.1.7 共享数据



#### 2.1.8 实战

**开发步骤**











### 2.2 Response 对象

服务器端发给客户端的消息



#### 2.2.1 预备知识

**数据格式**

1. 响应行
2. 响应头
3. 空行
4. 响应体



#### 2.2.2 响应行

在客户端发送请求消息之后，服务器端会告诉客户端这次请求 / 通信的效果如何，就有以下状态码。

**状态码**

`200`：成功，我们最喜欢看到的

`302`：重定向。对于客户端的请求，不在此（请求的）路径上，服务器端告诉客户端：你应该去找另一个路径

`404`：找不到路径。要请求的路径不在服务器资源里

`405`：请求方式没有对应的响应方法

`500`：服务器内部出现异常



这里需要讲一下`重定向`，先举个例子：



<div align="center"> <img src="image-20200419232313653.png" width="80%"/> </div><br>

举一个例子，假设你要想吃牛排，你去到一家餐馆，

Q：请问有牛排吗？（请求）

A：没有，牛排馆在隔壁（重定向）

Q：请问是牛排馆吗？（再次请求）

A：是的，请进（响应）



```java
response.sendRedirect("path");
```



**:warning: 注意 **



`sendRedirect` 与 `forward` 的区别？

1. 前者是两次请求，后者是一次

2. 前者可以重定向到服务器资源外的网站（Google，Baidu......），后者只能在服务器资源内进行转发

3. 前者不能共享数据（因为不是单单在服务器内部），后者可以

   


#### 2.2.3 响应头

当我们输入百度的网址：
<div align="center"> <img src="image-20200419230447296.png" width="100%"/> </div><br>


<div align="center"> <img src="image-20200419230509984.png" width="60%"/> </div><br>

`Content-type` ：响应体的格式以及编码

#### 2.2.4 响应体














