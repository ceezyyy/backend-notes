# 实战案例

## 1. 用户登录

**项目需求**

1. 用户登录页面
2. 数据库：`Spring JDBC` 封装 `JDBC Template`，采用 `Druid` 连接池技术
3. 登录成功失败分别转发两个 `Servlet`





**需求分析**

<div align="center"> <img src="image-20200424210546239.png" width="80%"/> </div><br>

`view`：登录页面，前端展示

`LoginServlet`：获取参数，处理逻辑

`UserDao`：进行数据库查询，返回 `User` 或 `null` 

`SucceededServlet`：对查询成功做出响应

`FailServlet`：对查询失败做出相应





**开发流程**

1. 数据库连接池配置，环境依赖，数据库建库建表

<div align="center"> <img src="image-20200424221529951.png" width="40%"/> </div><br>

<div align="center"> <img src="image-20200424222457888.png" width="60%"/> </div><br>


2. `VIEW` 层：展示页面

<div align="center"> <img src="image-20200424222623873.png" width="50%"/> </div><br>


3. `DAO` 层：创建实体类 `Java Bean`，数据库操作类 `UserDao`

   


4. `test` 测试类，测试数据库连接 / 查询是否正常

5. 







## 2.



