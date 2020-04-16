# Request 对象原理

## 什么是 Request 对象 （原理）

1. `Tomcat` 服务器会根据 `@WebServlet` 的注解，即我们所写的 `URL pattern`，创建当前的 `Demo2` （`Servlet` 接口实现类）；

2. 创建 `Request` 和 `Response` 对象，其中前者会封装请求消息的数据。例如，我们从 `URL`输入的 网址，或者页面表单提交的信息；

3. `Tomcat` 将上述两个对象作为 `service` 方法的参数，并调用`service`方法；

4. 由开发者在`service`方法写逻辑 / 任务需求，以达到将所需的`response`；

5. 浏览器先从`response`中获取数据，并响应。

   

<div align="center"> <img src="image-20200416105056019.png" width="80%"/> </div><br>



## 为什么要用 Request 对象（功能）

先上一张思维导图：







我们先搞清楚一个概念：
<div align="center"> <img src="image-20200416120953704.png" width="100%"/> </div><br>


当你在`URL`中输入这一串的时候：

`localhost`是主机ip

`8080`是当前进程的端口号（`Tomcat`默认端口是 8080）

`/ServletDemo/`是指当前的虚拟目录（告诉别人你的项目放在哪，这样才可以访问到）



注意，此时是（默认）自动跳转到 `index.jsp`  页面的

<div align="center"> <img src="image-20200416125812624.png" width="50%"/> </div><br>



**获取请求数据 —— 行数据**


<div align="center"> <img src="image-20200416115315524.png" width="80%"/> </div><br>

其中，最重要的两个方法：

```java
request.getContextPath();
```

```java
request.getRequestURI();
```

查看 API 文档：

<div align="center"> <img src="image-20200416115916470.png" width="100%"/> </div><br>

此时的 `context path` 路径就是我们的虚拟目录。

<div align="center"> <img src="image-20200416120649907.png" width="80%"/> </div><br>

**获取请求参数**







## Request 实战



















**遇到问题常见的解决方案：**

1. 重启 `Tomcat`服务器

2. 若是`form` 表单的话，按钮类型一定要是 `submit` !

   