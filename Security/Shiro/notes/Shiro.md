# Shiro

## 目录

* [1. 知识储备](#1-----)
  + [1.1 什么是认证？](#11-------)
  + [1.2 什么是授权？](#12-------)
  + [1.3 什么是凭证？](#13-------)
  + [1.4 什么是 Cookie?](#14-----cookie-)
  + [1.5 什么是 Session?](#15-----session-)
  + [1.6 Session 认证流程](#16-session-----)
  + [1.7 什么是 Token?](#17-----token-)
  + [1.8 Token 和 Session 的区别](#18-token---session----)
  + [1.9 什么是 JWT?](#19-----jwt-)
  + [1.10 Token 和 JWT 的区别](#110-token---jwt----)
* [2. 什么是 Shiro?](#2-----shiro-)
* [3. 用户，角色，权限的关系](#3------------)
* [4. 核心组件](#4-----)
* [5. 工作流程](#5-----)
* [6. Quickstart](#6-quickstart)
* [参考资料](#----)



## 1. 知识储备

### 1.1 什么是认证？

<img src="https://ceezyyy.oss-cn-beijing.aliyuncs.com/img/authentication.png" style="zoom: 50%;" />

**认证 (Authentication) 就是验证当前用户的身份，证明"你是你自己"**

例如：

- 用户名密码登录
- 邮箱发送验证信息
- bb手机号接受验证码

   

### 1.2 什么是授权？



**用户授权 (Authorization) 给第三方应用**

例如：

- 安装 `APP` 时，会询问用户是否授予（访问相册，地理位置等权限）
- 访问小程序时，会询问是否允许授予权限（获取昵称，头像，地区等个人信息）

实现授权的方式：

- cookie
- session
- token
- OAuth



### 1.3 什么是凭证？



**凭证是一个令牌，用来标识访问者的身份**

例如：你出国旅行或出差时，有护照，标明你是一个中国人

在互联网应用中，许多网站有以下几种模式：

- 访客模式
- 普通用户模式
- 会员模式

访客模式：访客只能浏览帖子而不能发表言论

普通用户模式：当用户登录成功时，服务器会给发送请求的浏览器颁发一个 `token` ，用来表明身份，可以发表言论，点赞之类的

会员模式：类似于普通用户模式，解锁一些普通用户没有的功能



### 1.4 什么是 Cookie?



**cookie 是一种记录服务器和客户端会话状态的机制**

`HTTP` 是无状态的协议，即服务端不会保存任何会话信息

这样会造成服务端无法确认当前访问者的信息，无法分辨上一次发送请求的当前用户是否为同一人 

所以服务器与浏览器为了进行会话跟踪，就必须主动维护一个状态，通过 `cookie` 和 `session` 实现

`cookie` 的特点：

- 存储在客户端
- 不可跨域



### 1.5 什么是 Session?

**session 是一种记录服务器和客户端会话状态的机制**

`session` 是基于 `cookie` 实现的，`session` 存储在服务器端，`sessionId` 会被存储到客户端的 `cookie` 中







### 1.6 Session 认证流程





### 1.7 什么是 Token?













### 1.8 Token 和 Session 的区别

















### 1.9 什么是 JWT?



















### 1.10 Token 和 JWT 的区别





## 2. 什么是 Shiro?

`Shiro` 是一款主流的 `Java` 安全框架，不依赖任何容器，可运行在 `Java SE` 和 `Java EE` 项目中

主要功能：

- 身份认证
- 授权
- 会话管理
- 加密



## 3. 用户，角色，权限的关系

**赋予角色权限**

**赋予用户角色**








## 4. 核心组件

- UsernamePasswordToken

  `Shiro` 用来封装用户登录信息，使用用户登录信息来创建 `token`

- SecurityManager

  `Shiro` 核心，负责安全认证和授权

- Subject

  包含用户信息

- Realm

  开发者自定义的模块，根据项目需求，验证和授权的逻辑全部写在 `Realm` 中

- AuthenticationInfo

  用户角色信息集合，认证时使用

- AuthorizationInfo 

  角色的权限信息集合，授权时使用

- DefaultWebSecurityManager

  安全管理器，自定义的 `Realm` 需注入到次才能生效

- ShiroFilterFactoryBean

  过滤器工厂。`Shiro` 的基本运行机制是开发者制定流程，底层由 `ShiroFilterFactoryBean` 创建的 `filters` 来完成各种功能



## 5. 工作流程



- 用户进入系统先根据 `username` 和 `password` 获取 `token`
- `Subject` 保存用户信息
- `SecurityManager` 根据 `AuthenticationInfo`（你是哪个角色）及 `AuthorizationInfo`（你有哪些权限）进行安全管理
- 其中 `AuthenticationInfo` 以及 `AuthorizationInfo` 根据用户自定义 `Realm` 生成



## 6. Quickstart










## 参考资料

- [傻傻分不清之 Cookie、Session、Token、JWT](https://juejin.im/post/5e055d9ef265da33997a42cc)

- [【硬核干货】2小时学会Spring Boot整合Shiro](https://www.bilibili.com/video/BV16C4y187S9?from=search&seid=10384979958239744928)

  

