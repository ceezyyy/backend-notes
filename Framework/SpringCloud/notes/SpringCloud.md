# Spring Cloud Quickstart

<div align="center"> <img src="logo.png" width="60%"/> </div><br>

## Category

* [0. References](#0-references)
* [1. 单体应用存在的问题](#1----------)
* [2. 分布式架构](#2------)
* [3. 什么是微服务](#3-------)
* 



## 0. References

**Read these articles before you start**

- [一文详解微服务架构](https://www.cnblogs.com/skabyy/p/11396571.html)
- [如何给老婆解释什么是微服务 - 知乎](https://zhuanlan.zhihu.com/p/34287582)
- [什么是微服务 - 知乎](https://www.zhihu.com/question/65502802/answer/802678798)
- [什么是微服务 - CSDN](https://blog.csdn.net/wuxiaobingandbob/article/details/78642020)

- [Spring Cloud从入门到实战 - bilibili](https://www.bilibili.com/video/BV1p4411K7pz)

<div align="center"> <img src="microservices.png" width="70%"/> </div><br>

<div align="center"> <img src="pic.jpg" width="70%"/> </div><br>



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






