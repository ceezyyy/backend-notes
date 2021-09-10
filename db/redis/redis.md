# Redis

## Table of Contents

- [1. 数据类型](#1-数据类型)
	- [1.1 RedisObject](#11-redisobject)
	- [1.2 String](#12-string)
	- [1.3 List](#13-list)
	- [1.4 Hash](#14-hash)
	- [1.5 Set](#15-set)
	- [1.6 Sorted Set](#16-sorted-set)
- [References](#references)

## 1. 数据类型

### 1.1 RedisObject

```c
typedef struct redisObject {
    unsigned type:4;  // 数据类型, e.g: string, list, set...
    unsigned encoding:4;  // 底层编码
    unsigned lru:LRU_BITS; /* lru time (relative to server.lruclock) */
    int refcount;
    void *ptr;  // 数据指针
} robj;
```

### 1.2 String

**sds.h**

```c
struct sdshdr {
    int len;
    int free;
    char buf[];
};
```

### 1.3 List

**quicklist**

3.2 版本之前，采用 *ziplist* + *linkedlist* 作为列表对象的底层实现，但为了减少**内存碎片**，从 3.2 开始采用 *quicklist* 作为其底层实现

**quicklist**

<div align="center"> <img src="./pics/quicklist.jpeg" width="90%"/> </div><br>

### 1.4 Hash

**ziplist**

<div align="center"> <img src="./pics/ziplist.png" width="70%"/> </div><br>

**dict**

```c
/* 字典对象（更高层次抽象）*/
typedef struct dict {
    dictType *type;
    void *privdata;
    dictht ht[2];  // 两个哈希表, 用于渐进式哈希
    long rehashidx; /* rehashing not in progress if rehashidx == -1 */
    int16_t pauserehash; /* If >0 rehashing is paused (<0 indicates coding error) */
} dict;


/* 哈希表 */
typedef struct dictht {
    dictEntry **table;  // bucket
    unsigned long size;
    unsigned long sizemask;
    unsigned long used;
} dictht;


/* 哈希表节点 */
typedef struct dictEntry {
    void *key;
    union {
        void *val;
        uint64_t u64;
        int64_t s64;
        double d;
    } v;
    struct dictEntry *next;  // 头插法解决冲突
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
      
      	/* 渐进式处理 ht[0] 的每个 bucket, 也就是 de */
        de = d->ht[0].table[d->rehashidx];   
        while(de) {
            uint64_t h;
						
            nextde = de->next;
          
            h = dictHashKey(d, de->key) & d->ht[1].sizemask;  // 计算新的 hash 值

          	/* 头插法解决冲突 */
          	de->next = d->ht[1].table[h];
            d->ht[1].table[h] = de;
          
            d->ht[0].used--;
            d->ht[1].used++;
          	
            de = nextde;  // 继续处理下一个哈希节点
        }
      	
        d->ht[0].table[d->rehashidx] = NULL; 
        d->rehashidx++;
    }

		/* 判断是否 rehash 完成 */  
    if (d->ht[0].used == 0) {
      	/* 释放原来的空间, 交换两个哈希表 */
        zfree(d->ht[0].table);
        d->ht[0] = d->ht[1];
        _dictReset(&d->ht[1]);
        d->rehashidx = -1;
        return 0;  
    }

    /* More to rehash... */
    return 1;
}
```

**为什么要渐进式？**

- **分而治之**
- 将 *rehash* 的操作均摊到每次操作上，避免了集中式引发的庞大计算量

### 1.5 Set

**inset**

```c
typedef struct intset {
    uint32_t encoding;  // 编码方式
    uint32_t length;  // 内容集合的元素数量
    int8_t contents[];  // 元素数组, 从小到大, 不含重复项
} intset;
```

### 1.6 Sorted Set

**ziplist**

<div align="center"> <img src="./pics/zset_ziplist.png" width="60%"/> </div><br>

**zset (skiplist + dict)**

<div align="center"> <img src="./pics/skiplist.png" width="60%"/> </div><br>

**skiplist**

<div align="center"> <img src="./pics/image-20210910101942692.png" width="65%"/> </div><br>


**结构**

```c
typedef struct zskiplistNode {
    struct zskiplistNode *backward;  // 后退指针, 用于反向遍历
    double score;  // 分值（可重复）, 小到大排列
    robj *obj;  // SDS（唯一）
    struct zskiplistLevel {  // 层（数组）
        struct zskiplistNode *forward;  // 前进指针
        unsigned int span;  // 跨度, 用于计算排名
    } level[];
} zskiplistNode;
```

**search: O(n)**

<div align="center"> <img src="./pics/image-20210910103035459.png" width="70%"/> </div><br>

**insert**



**delete**





## References

- [Redis Documentation](https://redis.io/)
- *Redis In Action*
- *Redis 核心技术与实战*
- *Redis 设计与实现*
- [Skip Lists: A Probabilistic Alternative to Balanced Trees](https://15721.courses.cs.cmu.edu/spring2018/papers/08-oltpindexes1/pugh-skiplists-cacm1990.pdf)
- [Alg-2C: Skip List](https://www.youtube.com/watch?v=UGaOXaXAM5M)
- [Redis内部数据结构详解(4)——ziplist](http://zhangtielei.com/posts/blog-redis-ziplist.html)
- [Redis内部数据结构详解(5)——quicklist](http://zhangtielei.com/posts/blog-redis-quicklist.html)
