# Redis

## Table of Contents

- [1. 命令](#1-命令)
- [References](#references)

## 1. 命令

```shell
# 配置文件: /usr/local/etc/redis.conf
# 启动服务
redis-server

# 启动 cli
redis-cli

# 关闭服务器 
shutdown
quit
```

## 2. 数据类型

**String**

<div align="center"> <img src="./pics/string.png" width="40%"/> </div><br>

- 使用 *INCR / DECR* 时，可实现 *counters*（**原子**指令）
- 使用 *EXPIRE* 设置 *key* 过期时间
  - -1 不过期
  - -2 键不存在



**List**

<div align="center"> <img src="./pics/list.png" width="35%"/> </div><br>

- 头尾 *O(1)* 插入删除



**Set**

<div align="center"> <img src="./pics/set.png" width="40%"/> </div><br>

**Sorted Set**

<div align="center"> <img src="./pics/sorted-set.png" width="40%"/> </div><br>



**Hash**

<div align="center"> <img src="./pics/hash.png" width="35%"/> </div><br>

- 表示对象



## References

- [Redis Documentation](https://redis.io/)
- [CyC2018 / CS-Notes](https://github.com/CyC2018/CS-Notes/blob/master/notes/Redis.md)
