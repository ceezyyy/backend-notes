



# Redis 

<div align="center"> <img src="logo.png" width="50%"/> </div><br>





Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [数据类型（针对 Value）](#数据类型针对-value)
   * [Strings](#strings)
   * [Hashes](#hashes)
   * [Lists](#lists)
   * [Sets](#sets)
   * [Sorted sets](#sorted-sets)
* [References](#references)


## Brainstorming

<div align="center"> <img src="redis.svg" width="100%"/> </div><br>





## 数据类型（针对 Value）

### Strings

> Strings are the most basic kind of Redis value. Redis Strings are binary safe, this means that a Redis string can contain any kind of data, for instance a JPEG image or a serialized Ruby object.

最简单的类型，做 `KV` 缓存

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



**热点数据**

关注微博大 V 后粉丝数的增加如何立即反馈给用户？ `string` 提供原子计数器功能

<div align="center"> <img src="image-20200920112038444.png" width="80%"/> </div><br>

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

验证码如何实现 60s 自动过期？ `string` 提供键过期策略

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



### Hashes

> Redis Hashes are maps between string fields and string values, so they are the perfect data type to represent objects (e.g. A User with a number of fields like name, surname, age, and so forth)

一个存储空间保存多个 `KV` 数据

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



**电商购物车场景**


<div align="center"> <img src="image-20200920151814899.png" width="80%"/> </div><br>



<div align="center"> <img src="image-20200920152500733.png" width="80%"/> </div><br>

### Lists

> Redis Lists are simply lists of strings, sorted by insertion order. It is possible to add elements to a Redis List pushing new elements on the head (on the left) or on the tail (on the right) of the list.

底层基于双向列表：增删快，按索引读慢

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
127.0.0.1:6379> LPOP user:mac_ova_seas:msg
"c"
127.0.0.1:6379> RPOP user:mac_ova_seas:msg
"f"
```



### Sets

> Redis Sets are an unordered collection of Strings. It is possible to add, remove, and test for existence of members in O(1) (constant time regardless of the number of elements contained inside the Set).
>
> Redis Sets have the desirable property of not allowing repeated members. Adding the same element multiple times will result in a set having a single copy of this element. Practically speaking this means that adding a member does not require a *check if exists then add* operation.
>
> A very interesting thing about Redis Sets is that they support a number of server side commands to compute sets starting from existing sets, so you can do unions, intersections, differences of sets in very short time.

无序集合，自动去重

```bash
127.0.0.1:6379> SADD lakers LBJ AD KCP Rondo
(integer) 4
127.0.0.1:6379> SMEMBERS lakers
1) "Rondo"
2) "KCP"
3) "LBJ"
4) "AD"
127.0.0.1:6379> SREM lakers Rondo
(integer) 1
127.0.0.1:6379> SMEMBERS lakers
1) "KCP"
2) "LBJ"
3) "AD"
127.0.0.1:6379> SCARD lakers
(integer) 3
127.0.0.1:6379> SISMEMBER lakers LBJ
(integer) 1
127.0.0.1:6379> SISMEMBER lakers Rondo
(integer) 0
```



**热点推荐**

网站中的热点推荐是如何实现的？

```bash
127.0.0.1:6379> SADD news n1 n2 n3 n4 n5 n6 n7 n8 n9
(integer) 9
127.0.0.1:6379> SCARD news
(integer) 9
127.0.0.1:6379> SRANDMEMBER news 3
1) "n7"
2) "n2"
3) "n1"
127.0.0.1:6379> SCARD news
(integer) 9
127.0.0.1:6379> SPOP news 2
1) "n8"
2) "n2"
127.0.0.1:6379> SCARD news
(integer) 7
```



**关联操作**

本质上是 **交, 并, 差**

不同用户的兴趣点有哪些？不同用户有哪些共同好友？可能认识的人？

```bash
127.0.0.1:6379> SADD user:1 local business arts sports tech politics
(integer) 6
127.0.0.1:6379> SADD user:2 business sports international
(integer) 3
127.0.0.1:6379> SINTER user:1 user:2
1) "sports"
2) "business"
127.0.0.1:6379> SUNION user:1 user:2
1) "arts"
2) "politics"
3) "international"
4) "local"
5) "tech"
6) "sports"
7) "business"
127.0.0.1:6379> SDIFF user:1 user:2
1) "tech"
2) "local"
3) "arts"
4) "politics"
127.0.0.1:6379> SDIFF user:2 user:1
1) "international"
```





**网站访问量**

`PV`：访问量（通过刷新页面提高访问量）

`UV`：不同用户访问次数（通过 `cookie`）

`IP`：不同 `IP` 访问总次数

利用 `set` 作数据去重





### Sorted sets

> Redis Sorted Sets are, similarly to Redis Sets, non repeating collections of Strings. The difference is that every member of a Sorted Set is associated with score, that is used in order to take the sorted set ordered, from the smallest to the greatest score. While members are unique, scores may be repeated.
>
> With sorted sets you can add, remove, or update elements in a very fast way (in a time proportional to the logarithm of the number of elements). Since elements are *taken in order* and not ordered afterwards, you can also get ranges by score or by rank (position) in a very fast way. Accessing the middle of a sorted set is also very fast, so you can use Sorted Sets as a smart list of non repeating elements where you can quickly access everything you need: elements in order, fast existence test, fast access to elements in the middle!













## References

- [尚硅谷超经典Redis教程,redis实战,阳哥版从入门到精通](https://www.bilibili.com/video/BV1oW411u75R?from=search&seid=10969912493121588561)
