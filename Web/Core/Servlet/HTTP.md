# HTTP Protocol

## HTTP 协议

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



## HTTP 报文格式

### Request

当你在浏览器网址栏输入：
<div align="center"> <img src="image-20200418212457009.png" width="100%"/> </div><br>

客户端向浏览器发送一个 `request` 请求，请求报文格式由 4 个部分组成：

1. 请求行

2. 请求头

3. 空行

4. 请求体



<div align="center"> <img src="image-20200418213220097.png" width="60%"/> </div><br>

**请求行**

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














































1. `Tomcat` 服务器会根据 `@WebServlet` 的注解，即我们所写的 `URL pattern`，创建当前的 `Demo2` （`Servlet` 接口实现类）；

2. 创建 `Request` 和 `Response` 对象，其中前者会封装请求消息的数据。例如，我们从 `URL`输入的 网址，或者页面表单提交的信息；

3. `Tomcat` 将上述两个对象作为 `service` 方法的参数，并调用`service` 方法；

4. 由开发者在`service`方法写逻辑 / 任务需求，以达到将所需的`response`；

5. 浏览器先从`response`中获取数据，并响应。

   

<div align="center"> <img src="image-20200416105056019.png" width="80%"/> </div><br>



我们先搞清楚一个概念：
<div align="center"> <img src="image-20200416120953704.png" width="100%"/> </div><br>


当你在`URL`中输入这一串的时候：

`localhost`是主机ip

`8080`是当前进程的端口号（`Tomcat`默认端口是 8080）

`/ServletDemo/`是指当前的虚拟目录（告诉别人你的项目放在哪，这样才可以访问到）



注意，此时是（默认）自动跳转到 `index.jsp`  页面的

<div align="center"> <img src="image-20200416125812624.png" width="40%"/> </div><br>





### Response








