# Redis

## Table of Contents

- [1. 概览](#1-概览)
- [2. 数据结构](#2-数据结构)
	- [2.1 SDS](#21-sds)
	- [2.2 链表](#22-链表)
	- [2.3 字典](#23-字典)
	- [2.4 跳跃表](#24-跳跃表)
	- [2.5 整数集合](#25-整数集合)
	- [2.6 压缩列表](#26-压缩列表)
	- [2.7 对象](#27-对象)
- [References](#references)

## 1. 概览

**Overview**

- 访问框架
  - 动态库
  - 网络访问框架
- 操作模块 (PUT/GET/SCAN/DELETE)
- 索引模块
- 存储模块
  - 分配器
  - 持久化

**三条主线**

<div align="center"> <img src="./pics/image-20210627160643569.png" width="70%"/> </div><br>

## 2. 底层数据结构

### 2.1 SDS

> Simple Dynamic String

**sds.h**

```c
// redis 3.0
struct sdshdr {
    int len;
    int free;
    char buf[];
};
```

**设计意义**

- 杜绝缓冲区溢出
  - 扩容
- 减少修改字符串导致的频繁内存重分配
  - 空间预分配
  - 惰性空间释放
- 二进制安全

### 2.2 链表

**adlist.h**

```c
typedef struct list {
    listNode *head;
    listNode *tail;
    void *(*dup)(void *ptr);
    void (*free)(void *ptr);
    int (*match)(void *ptr, void *key);
    unsigned long len;
} list;


typedef struct listNode {
    struct listNode *prev;
    struct listNode *next;
  	// 对所保存值的类型不作限制
    void *value;
} listNode;
```

<div align="center"> <img src="./pics/list.png" width="60%"/> </div><br>

**设计意义**

- 作为 *LIST* 的底层实现
- 作为通用数据结构，被其他模块使用

### 2.3 字典

**dict.h**

```c
typedef struct dict {
    dictType *type;
    void *privdata;
  	// 2 个哈希表
    dictht ht[2];
  	// rehash 进度
    long rehashidx; /* rehashing not in progress if rehashidx == -1 */
    int16_t pauserehash; /* If >0 rehashing is paused (<0 indicates coding error) */
} dict;


typedef struct dictht {
  	// bucket
    dictEntry **table;
    unsigned long size;
    unsigned long sizemask;
    unsigned long used;
} dictht;


typedef struct dictEntry {
  	// 键
    void *key;
  	// 值
    union {
        void *val;
        uint64_t u64;
        int64_t s64;
        double d;
    } v;
  	// 拉链法, 头插
    struct dictEntry *next;
} dictEntry;
```

<div align="center"> <img src="./pics/dict.png" width="60%"/> </div><br>

**Rehash**

```c
int dictRehash(dict *d, int n) {
    int empty_visits = n*10; /* Max number of empty buckets to visit. */
    if (!dictIsRehashing(d)) return 0;

    while(n-- && d->ht[0].used != 0) {
        dictEntry *de, *nextde;

        assert(d->ht[0].size > (unsigned long)d->rehashidx);
        while(d->ht[0].table[d->rehashidx] == NULL) {
            d->rehashidx++;
            if (--empty_visits == 0) return 1;
        }
        de = d->ht[0].table[d->rehashidx];
        // 处理ht[0]的每个bucket: 渐进式
        while(de) {
            uint64_t h;
						
          	// 1）遍历链表
            nextde = de->next;
          
          	// 计算新的 hash 值
            h = dictHashKey(d, de->key) & d->ht[1].sizemask;
          	// 头插法
            de->next = d->ht[1].table[h];
            d->ht[1].table[h] = de;
          
          	// 更新计数器
            d->ht[0].used--;
            d->ht[1].used++;
          
          	// 2）遍历链表
            de = nextde;
        }
      	
      	// 更新
        d->ht[0].table[d->rehashidx] = NULL;
        d->rehashidx++;
    }

    // 是否 rehash 完成
    if (d->ht[0].used == 0) {
        zfree(d->ht[0].table);
        d->ht[0] = d->ht[1];
        _dictReset(&d->ht[1]);
        d->rehashidx = -1;
      	// rehash 成功
        return 0;
    }

    /* More to rehash... */
    return 1;
}
```

### 2.4 跳跃表

**skip list**

<div align="center"> <img src="./pics/skiplist.png" width="55%"/> </div><br>

**server.h**

```c
typedef struct zskiplist {
    struct zskiplistNode *header, *tail;
    unsigned long length;
    int level;
} zskiplist;


typedef struct zskiplistNode {
    sds ele;
    double score;
    struct zskiplistNode *backward;
    struct zskiplistLevel {
        struct zskiplistNode *forward;
      	// 用于计算元素排名（跳表扩展）
        unsigned long span;
    } level[];
} zskiplistNode;
```

**设计意义**

- *zset* 的底层实现

### 2.5 整数集合

**设计意义**

- 



### 2.6 压缩列表

**设计意义**

- 



## 3. Redis 对象














## References

- [Redis Documentation](https://redis.io/)
- *Redis In Action*
- *Redis 核心技术与实战*
- *Redis 设计与实现*
- [Skip Lists: A Probabilistic Alternative to Balanced Trees](https://15721.courses.cs.cmu.edu/spring2018/papers/08-oltpindexes1/pugh-skiplists-cacm1990.pdf)
- [Alg-2C: Skip List](https://www.youtube.com/watch?v=UGaOXaXAM5M)
- [为什么 Redis 快照使用子进程](https://draveness.me/whys-the-design-redis-bgsave-fork/)
- [Copy on Write](https://www.geeksforgeeks.org/copy-on-write/)
- [Double Pointer (Pointer to Pointer) in C](https://www.geeksforgeeks.org/double-pointer-pointer-pointer-c/)
- [C 函数指针与回调函数](https://www.runoob.com/cprogramming/c-fun-pointer-callback.html)
- [C 语言中 void* 详解及应用](https://www.runoob.com/w3cnote/c-void-intro.html)
