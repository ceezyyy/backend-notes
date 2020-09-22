# HTTP 协议

Table of Contents
-----------------

* [1. 什么是 HTTP?](#1-什么是-http)
* [2. 什么是 URI 和 URL?](#2-什么是-uri-和-url)
* [3. URI 格式](#3-uri-格式)
* [4. 什么是 stateless?](#4-什么是-stateless)
* [5. HTTP 有哪些常见方法?](#5-http-有哪些常见方法)
   * [GET](#get)
   * [POST](#post)
   * [PUT](#put)
   * [DELETE](#delete)
* [6. 什么是状态码? HTTP 有哪些状态码?](#6-什么是状态码-http-有哪些状态码)
* [参考资料](#参考资料)


## 1. 什么是 HTTP?


<div align="center"> <img src="pre.jpg" width="70%"/> </div><br>

当我们从浏览器网址栏输入一串网址时，呈现到我们面前的 Web 页面是如何实现的？



简单地来讲：

1. Web 浏览器（客户端）根据输入的 `URL` 找到特定的 Web 资源服务器（服务器端）
2. 服务器端收到请求后会返回特定的 Web 页面
3. 浏览器呈现页面



而 `HTTP` 协议指的是完成从客户端到服务器端一系列运作流程的规范





## 2. 什么是 URI 和 URL?

`HTTP` 请求的内容统称为资源，它可以是一份文档，一张图片，一段视频。那如何标识每一份资源呢？

用 `URI` （Uniform Resource Identifier，统一资源标识符）来标识



标识了资源，如何找到它？

`URI` 最常见的形式是 `URL`（Uniform Resource Locator，统一资源定位符），即 Web 地址，来找到资源在互联网所处的位置









<div align="center"> <img src="image-20200922073111389.png" width="40%"/> </div><br>







## 3. URI 格式

```http
http://www.example.com:80/path/to/myfile.html?key1=value1&key2=value2#SomewhereInTheDocument
```

- `http://`：方案或协议（对于大部分 Web 资源，通常使用 `http` / `https`）
- `www.example.com`：主机（它指示了需要向网络上哪一台主机发送请求）
- `:80`：端口（表示用于访问 Web 服务器上资源技术 “门”）
- `/path/to/myfile.html`：路径（Web 服务器上资源路径）
- `?key1=value1&key2=value2`：查询（Web 服务器额外参数）
- `#SomewhereInTheDocument`：片段（资源本身的某一部分的一个锚点 / 书签）







## 4. 什么是 stateless?

`HTTP` 是一种无状态协议，即协议对于发送过的请求 / 响应都不做持久化处理



## 5. HTTP 有哪些常见方法?

### GET

获取资源

### POST

传输实体主体

### PUT

上传文件

由于自身不带验证机制，因此存在安全性问题，一般不使用

### DELETE

删除文件

与 `PUT` 功能相反，并且同样不带验证机制



## 6. 什么是状态码? HTTP 有哪些状态码?

状态码的作用是当客户端向服务器发送了请求，描述响应结果

有了它，我们可以知道服务器是否正确处理了请求



| 状态码 | 类别                             | 含义                       |
| ------ | -------------------------------- | -------------------------- |
| 1XX    | Informational（信息性状态码）    | 接收的请求正在处理         |
| 2XX    | Success（成功状态码）            | 请求正常处理完毕           |
| 3XX    | Redirection（重定向状态码）      | 需要进行附加操作以完成请求 |
| 4XX    | Client Error（客户端错误状态码） | 服务器无法处理请求         |
| 5XX    | Server Error（服务器错误状态码） | 服务器处理请求出错         |









## 参考资料

- [HTTP Made Easy: Understanding the Web Client-Server Communication](https://hackernoon.com/http-made-easy-understanding-the-web-client-server-communication-yz783vg3)
- [What’s the Difference Between a URI and a URL?](https://danielmiessler.com/study/difference-between-uri-url/)
- [What is the difference between a URI, a URL and a URN?](https://stackoverflow.com/questions/176264/what-is-the-difference-between-a-uri-a-url-and-a-urn)
- [标识互联网上的内容](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Basics_of_HTTP/Identifying_resources_on_the_Web)
- [Why is it said that “HTTP is a stateless protocol”?](https://stackoverflow.com/questions/13200152/why-is-it-said-that-http-is-a-stateless-protocol)
