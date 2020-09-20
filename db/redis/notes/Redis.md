# Redis 

<div align="center"> <img src="logo.png" width="50%"/> </div><br>





Table of Contents
-----------------

* [1. NoSQL](#1-nosql)
* [2. 什么是 Redis?](#2-什么是-redis)
* [3. 为什么要用 Redis?](#3-为什么要用-redis)
* [4. 基本操作](#4-基本操作)
* [5. 数据类型](#5-数据类型)
   * [5.1 数据类型设计理念](#51-数据类型设计理念)
   * [5.2 string](#52-string)
   * [5.3 hash](#53-hash)
   * [5.4 list](#54-list)
   * [5.5 set](#55-set)
   * [5.6 sorted set](#56-sorted-set)
* [6. 通用命令](#6-通用命令)
* [7. 持久化](#7-持久化)
* [8. redis.conf](#8-redisconf)
* [9. 事务](#9-事务)
* [10. 集群](#10-集群)
* [11. 企业级解决方案](#11-企业级解决方案)
* [参考资料](#参考资料)


## 1. NoSQL

泛指非关系型数据库



**特点：**

- 易扩展：此类型数据存储不需要固定的模式，无需多余操作就可以横向扩展
- 高性能：非常高的读写性能
- 灵活的数据模型：无需事先为存储的数据建立字段（关系型数据库增删字段会对先前影响较大）

 

**目的：**

- 应对基于海量用户和海量数据前提下的数据处理问题



## 2. 什么是 Redis?

使用 `C` 语言开发的高性能 `KV` 数据库

**特征：**

- 数据间没有必然的关联关系
- 单线程机制
- 高性能
- 多数据类型支持
- 持久化支持

## 3. 为什么要用 Redis?

- 为热点数据加速查询（主要场景）：如热点商品 / 新闻等高访问量信息 
- 任务队列
- 即时信息查询
- 时效性信息



## 4. 基本操作

**命令行模式工具使用思考**

- 功能性命令
- 清屏
- 帮助信息
- 如何退出

 



启动 `redis-server`

<div align="center"> <img src="image-20200919174424027.png" width="80%"/> </div><br>

启动 `redis-cli`



<div align="center"> <img src="image-20200919175051343.png" width="60%"/> </div><br>



清屏：

```bash
clear
```

获取帮助：

```bash
help
```

退出：

```bash
exit
```



## 5. 数据类型（针对 Value）

### 5.1 数据类型设计理念

**中心思想：** 作缓存以提高查询速度


- 业务：秒杀，双 11，京东 618
- 突发热榜：微博热榜，突发新闻
- 高频，复杂统计数据：在线人数预览，选秀节目实时投票



`Redis` 中 `k` 为 `string`，数据类型只针对 `v` 讨论

 

### 5.2 string

- 存 / 批量存 / 追加存

- 取 / 批量取 / 取长度



`m` 代表 `multiply`

```bash
127.0.0.1:6379> set 23 KingJames
OK
127.0.0.1:6379> MSET 6 AD 9 Rondo 12 DW
OK
127.0.0.1:6379> APPEND 23 LBJ
(integer) 12
127.0.0.1:6379> get 23
"KingJamesLBJ"
127.0.0.1:6379> MGET 6 9 12
1) "AD"
2) "Rondo"
3) "DW"
127.0.0.1:6379> del 12
(integer) 1
127.0.0.1:6379> STRLEN 6
(integer) 2
```



### 5.3 string 应用场景

**缓存**

`redis` 应用于各种结构型和非结构型高热度数据访问加速

<div align="center"> <img src="image-20200920112038444.png" width="80%"/> </div><br>

举个例子，微博中大 V 的粉丝数量属于高热度数据，可以使用 `redis` 作缓存加快访问 / 反馈速度

```bash
127.0.0.1:6379> set user:id:001:fans 25890
OK
127.0.0.1:6379> get user:id:001:fans
"25890"
127.0.0.1:6379> INCR user:id:001:fans
(integer) 25891
```

该场景下，`K` 的命名规则一般为：

表名 : 主键 : 主键值 : 字段  







**验证码**

验证码讲究时效性，在 `redis` 我们可以设置键的过期时间

```bash
127.0.0.1:6379> help setex

  SETEX key seconds value
  summary: Set the value and expiration of a key
  since: 2.0.0
  group: string

127.0.0.1:6379> SETEX vertification_code 60 8888
OK
127.0.0.1:6379> GET vertification_code
"8888"
127.0.0.1:6379> GET vertification_code
(nil)
```



### 5.4 hash·

<div align="center"> <img src="hash.png" width="80%"/> </div><br>





```bash
127.0.0.1:6379> HSET user:mac_ova_seas following 167
(integer) 1
127.0.0.1:6379> HSET user:mac_ova_seas followers 25890
(integer) 1
127.0.0.1:6379> HSET user:mac_ova_seas weibos 393
(integer) 1
127.0.0.1:6379> HGET user:mac_ova_seas weibos
"393"
127.0.0.1:6379> HLEN user:mac_ova_seas
(integer) 3
127.0.0.1:6379> HEXISTS user:mac_ova_seas nums
(integer) 0
127.0.0.1:6379> HKEYS user:mac_ova_seas
1) "following"
2) "followers"
3) "weibos"
127.0.0.1:6379> HVALS user:mac_ova_seas
1) "167"
2) "25890"
3) "393"
```





注意⚠️：

- `value` 只能存储 `string`



### 5.5 hash 应用场景

**电商购物车场景**


<div align="center"> <img src="image-20200920151814899.png" width="80%"/> </div><br>



<div align="center"> <img src="image-20200920152500733.png" width="80%"/> </div><br>


### 5.6 list

**双向列表**

<div align="center"> <img src="list_new.png" width="80%"/> </div><br>



```bash
127.0.0.1:6379> LPUSH user:mac_ova_seas:msg a b c
(integer) 3
127.0.0.1:6379> RPUSH user:mac_ova_seas:msg d e f
(integer) 6
127.0.0.1:6379> LRANGE user:mac_ova_seas:msg 0 -1
1) "c"
2) "b"
3) "a"
4) "d"
5) "e"
6) "f"
127.0.0.1:6379> lpop user:mac_ova_seas:msg
"c"
127.0.0.1:6379> rpop user:mac_ova_seas:msg
"f"
127.0.0.1:6379>
```









### 5.7 list 应用场景

对顺序有要求的业务场景，例如：日志，粉丝排行榜...







### 5.8 set







### 5.9 set 应用场景









### 5.10 sorted set

















### 5.11 sorted set 应用场景











## 6. 通用命令











## 7. 持久化









## 8. redis.conf











## 9. 事务









## 10. 集群









## 11. 企业级解决方案











































## 参考资料

- [尚硅谷超经典Redis教程,redis实战,阳哥版从入门到精通](https://www.bilibili.com/video/BV1oW411u75R?from=search&seid=10969912493121588561)
- [黑马112节Redis入门到精通](https://www.bilibili.com/video/BV1CJ411m7Gc?from=search&seid=17692164217584292457)
- [NoSQL 简介](https://www.runoob.com/mongodb/nosql.html)
- [快速上手Spring Boot整合Redis](https://www.bilibili.com/video/BV18E411e7WJ)
- [使用brew services管理服务](https://www.jianshu.com/p/6c3b26490861)