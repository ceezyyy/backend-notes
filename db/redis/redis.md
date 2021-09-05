# Redis

## Table of Contents

- [1. Brainstorming](#1-brainstorming)
- [2. 数据类型](#2-数据类型)
	- [2.1 RedisObject](#21-redisobject)
	- [2.2 String](#22-string)
		- [2.2.1 raw & embstr](#221-raw--embstr)
	- [2.3 List](#23-list)
		- [2.3.1 Quicklist](#231-quicklist)
	- [2.4 Hash](#24-hash)
		- [2.4.1 Ziplist](#241-ziplist)
		- [2.4.2 Hashtable](#242-hashtable)
- [References](#references)

## 1. Brainstorming

<div align="center"> <img src="./pics/redis.svg" width="100%"/> </div><br>

## 2. 数据类型

### 2.1 RedisObject

```c
typedef struct redisObject {
    unsigned type:4;  // 数据类型, e.g: string, list, set...
    unsigned encoding:4;  // 底层编码
    unsigned lru:LRU_BITS; /* lru time (relative to server.lruclock) */
    int refcount;
    void *ptr;  // 数据指针
} robj;
```

### 2.2 String

**sds.h**

```c
struct sdshdr {
    int len;
    int free;
    char buf[];
};
```

#### 2.2.1 SDS

**为什么要设计 SDS？**

- 杜绝缓冲区溢出
  - 会先判断 *SDS* 的容量是否足够，不够会扩容
- **减少修改字符串时带来的内存重分配次数**
  - 空间预分配
  - 惰性空间释放
- 二进制安全

#### 2.2.2 raw & embstr

**相同**

- 基于 *SDS* 实现

**不同**

- *embstr* 分配/释放仅需要**一次**，即 *redisObject* 和 *sdshdr* 一次到位，而 *raw* 需要**两次**

### 2.3 List

> 从 3.2 开始，*list* 的内部编码为 *quicklist*

#### 2.3.1 Quicklist

> 每个节点为 ziplist 的双向链表

3.2 版本之前，采用 *ziplist* + *linkedlist* 作为列表对象的底层实现，但为了减少**内存碎片**，从 3.2 开始采用 *quicklist* 作为其底层实现

**quicklist**

<div align="center"> <img src="./pics/quicklist.png" width="65%"/> </div><br>

**quicklist.h**

```c
/* quicklist.h - A generic doubly linked quicklist implementation */
typedef struct quicklist {
    quicklistNode *head;
    quicklistNode *tail;
    unsigned long count;        /* total count of all entries in all ziplists */
    unsigned int len;           /* number of quicklistNodes */
    int fill : 16;              /* fill factor for individual nodes */
    unsigned int compress : 16; /* depth of end nodes not to compress;0=off */
} quicklist;


typedef struct quicklistNode {
    struct quicklistNode *prev;
    struct quicklistNode *next;
    unsigned char *zl;  // 数据指针, 若没被压缩 -> ziplist, 否则 -> quicklistLZF
    unsigned int sz;             /* ziplist size in bytes */
    unsigned int count : 16;     /* count of items in ziplist */
    unsigned int encoding : 2;   /* RAW==1 or LZF==2 */
    unsigned int container : 2;  /* NONE==1 or ZIPLIST==2 */
    unsigned int recompress : 1; /* was this node previous compressed? */
    unsigned int attempted_compress : 1; /* node can't compress; too small */
    unsigned int extra : 10; /* more bits to steal for future usage */
} quicklistNode;


typedef struct quicklistLZF {
    unsigned int sz; /* LZF size in bytes*/
    char compressed[];
} quicklistLZF;
```

### 2.4 Hash

#### 2.4.1 Ziplist

**Ziplist**

<div align="center"> <img src="./pics/ziplist.png" width="70%"/> </div><br>

**Entry**

- *previous_entry_length* : 用于从尾向头遍历
- *encoding*
- *content*
  - 字节数组
  - 整数值

**什么时候采用 ziplist 的编码方式？**

- 键和值的长度都小于 *hash-max-ziplist-value*
- 键值对数量小于 *hash-max-ziplist-entries*

#### 2.4.2 Hashtable

**dict.h**

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

### 2.5 Set

**inset.h**

```c
typedef struct intset {
    uint32_t encoding;  // 编码方式
    uint32_t length;  // 内容集合的元素数量
    int8_t contents[];  // 元素数组, 从小到大, 不含重复项
} intset;
```

#### 2.5.1 升级

**为什么要这样设计？**

确保升级操作在有需要的时候进行（**灵活性**），尽量**节约内存**

### 2.6 Sorted Set



## References

- [Redis Documentation](https://redis.io/)
- *Redis In Action*
- *Redis 核心技术与实战*
- *Redis 设计与实现*
- [Skip Lists: A Probabilistic Alternative to Balanced Trees](https://15721.courses.cs.cmu.edu/spring2018/papers/08-oltpindexes1/pugh-skiplists-cacm1990.pdf)
- [Alg-2C: Skip List](https://www.youtube.com/watch?v=UGaOXaXAM5M)
- [Redis内部数据结构详解(4)——ziplist](http://zhangtielei.com/posts/blog-redis-ziplist.html)
- [Redis内部数据结构详解(5)——quicklist](http://zhangtielei.com/posts/blog-redis-quicklist.html)
