# RabbitMQ

<div align="center"> <img src="rabbitMQ.png" width="50%"/> </div><br>

Table of Contents
-----------------

* [1. 什么是 MQ?](#1-什么是-mq)
   * [1.1 生产者](#11-生产者)
   * [1.2 消费者](#12-消费者)
* [2. 为什么要使用 MQ?](#2-为什么要使用-mq)
   * [2.1 解耦](#21-解耦)
   * [2.2 削峰](#22-削峰)
   * [2.3 数据分发](#23-数据分发)
* [3. 消息队列存在的问题](#3-消息队列存在的问题)
* [4. 同类产品比较](#4-同类产品比较)
* [5. Quickstart](#5-quickstart)
   * [5.1 安装 rabbitmq](#51-安装-rabbitmq)
* [参考资料](#参考资料)



## 1. 什么是 MQ?

<div align="center"> <img src="mq.png" width="50%"/> </div><br>





`MQ` 即为 `message queue`，消息队列是应用程序和应用程序之间的通信方法



### 1.1 生产者

- 生产者：把数据放到队列中的执行者



### 1.2 消费者

- 消费者：将数据从队列中取出的执行者





<div align="center"> <img src="new-mq.jpg" width="50%"/> </div><br>



## 2. 为什么要使用 MQ?

- 应用解耦
- 流量削峰
- 数据分发 



### 2.1 解耦

解耦是消息队列所要解决最本质的问题。

解耦，一个事务，只关心核心的流程，而需要依赖其他系统但不那么重要的事情，有通知即可，无需等待结构。



举个例子，在一个订单系统中

<div align="center"> <img src="image-20200809151522494.png" width="40%"/> </div><br>

包含以下功能（流程）：

- 订单支付
- 库存
- 物流



在没有加入消息队列时：



当用户成功支付订单后，

库存或物流模块功能出故障了，则整个订单系统需要长时间等待，此时用户的体验感极差





当加入了消息队列后：



当用户成功支付订单后（完成核心流程），程序立马返回“支付成功”

活动进入 `mq`，剩下的库存模块和物流模块已经不是系统的核心流程（订单是否支付成功才是）

<div align="center"> <img src="image-20200809151754415.png" width="45%"/> </div><br>





### 2.2 削峰

<div align="center"> <img src="image-20200809170311265.png" width="35%"/> </div><br>

在没有引入消息队列前：

若服务器在某一时间段的访问量陡增，例如常见的秒杀，双 11 等，公司原有的服务器承受不了高强度的访问量，会造成数据库崩溃（频繁地与系统 `IO` 打交道）



这时需引入消息队列：

<div align="center"> <img src="image-20200809170207889.png" width="30%"/> </div><br>

起到削峰的作用







### 2.3 数据分发























## 3. 消息队列存在的问题









## 4. 同类产品比较

<div align="center"> <img src="111.jpg" width="60%"/> </div><br>




## 5. Quickstart

### 5.1 安装 rabbitmq

采用 `homebrew` 安装 `rabbitmq`

<div align="center"> <img src="image-20200808164521398.png" width="60%"/> </div><br>



通过 `homebrew` 安装的软件位于 `/usr/local/Cellar` 上


<div align="center"> <img src="image-20200808164750922.png" width="60%"/> </div><br>

启动 `rabbitmq-server`


<div align="center"> <img src="image-20200808165033549.png" width="60%"/> </div><br>



输入网址：

```html
http://localhost:15672/
```

<div align="center"> <img src="image-20200808165134031.png" width="50%"/> </div><br>

默认账号密码都为 `guest`

搭建成功

<div align="center"> <img src="image-20200808165224073.png" width="100%"/> </div><br>



设置新账号


<div align="center"> <img src="image-20200808205850672.png" width="100%"/> </div><br>

添加成功！

<div align="center"> <img src="image-20200808205922733.png" width="50%"/> </div><br>

























## 参考资料

- [rabbitmq](https://www.rabbitmq.com/)
- [RocketMQ系统精讲，经受历年双十一狂欢节考验的分布式消息中间件](https://www.bilibili.com/video/BV1L4411y7mn?p=1)
- [什么是消息队列？](https://juejin.im/post/6844903817348136968)
- [消息队列的使用场景是怎样的？](https://www.zhihu.com/question/34243607)
- [mac 安装 RabbitMQ](https://blog.csdn.net/u010046908/article/details/54773323)
- [消息队列设计精要](https://tech.meituan.com/2016/07/01/mq-design.html)
