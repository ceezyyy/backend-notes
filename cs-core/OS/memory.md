# Memory Management

Table of Contents
-----------------

* [1. Dynamic Relocation](#1-dynamic-relocation)
   * [1.1 Base and Bound](#11-base-and-bound)
* [2. Segmentation](#2-segmentation)
* [3. Free-space Management](#3-free-space-management)
   * [3.1 Mechanism](#31-mechanism)
      * [3.1.1 Splitting &amp; merging](#311-splitting--merging)
      * [3.1.2 Tracking](#312-tracking)
   * [3.2 Strategy](#32-strategy)


## 1. Dynamic Relocation

<div align="center"> <img src="virtual-address-space.png" width="40%"/> </div><br>

### 1.1 Base and Bound

<div align="center"> <img src="base-and-bound.jpg" width="35%"/> </div><br>

**Example**

physical address = virtual address + base

| virtual address | physical address     |
| --------------- | -------------------- |
| 0               | 16KB                 |
| 1KB             | 17KB                 |
| 3000            | 19384                |
| 4400            | error (out of bound) |

**Internal Fragmentation**

> allocated but not in use

<div align="center"> <img src="process-address-space.png" width="20%"/> </div><br>



<div align="center"> <img src="physical-memory.png" width="25%"/> </div><br>



## 2. Segmentation

**Example**

<div align="center"> <img src="segmentation-2.png" width="20%"/> </div><br>

<div align="center"> <img src="segmentation-3.png" width="20%"/> </div><br>

**段寄存器**

| segment | base address | size |是否反向增长|
| ------- | ------------ | ---- |----|
| code    | 32KB         | 2KB  |1|
| heap    | 34KB         | 2KB  |1|
| stack   | 28KB         | 2KB  |0|



**code**

virtual address: 100 -> offset: 100

physical address: 32868



**heap**

virtual address: 4200 -> offset: 104

physical address: 34920



**stack**

virtual address: 15KB -> offset: 1KB

physical address: 27KB



**External Fragmentation**

<div align="center"> <img src="external-fragmentation.png" width="50%"/> </div><br>



## 3. Free-space Management

**FreeSpaceManagement.c**

```c
// Allocates the requested memory and returns a pointer to it
void *malloc(size_t size)


// Deallocates the memory previously allocated by a call to calloc/malloc/realloc
void free(void *ptr)
```

### 3.1 Mechanism

#### 3.1.1 Splitting & merging

<div align="center"> <img src="splitting-merging-1.png" width="40%"/> </div><br>

对应的空闲列表

<div align="center"> <img src="splitting-merging-2.png" width="40%"/> </div><br>



假如 `malloc(1)`

<div align="center"> <img src="splitting-merging-3.png" width="40%"/> </div><br>

接着 `free(10)`

<div align="center"> <img src="splitting-merging-4.png" width="50%"/> </div><br>

最后 merging

<div align="center"> <img src="splitting-merging-5.png" width="30%"/> </div><br>



#### 3.1.2 Tracking

**header**

```c
typedef struct header_t {
  int size;
  int magic;
} header_t;
```

<div align="center"> <img src="header.png" width="50%"/> </div><br>

**free**

```c
void free(void *ptr) {
  header_t *hptr = (void *)ptr - sizeof(header_t);
}
```

<div align="center"> <img src="free.png" width="50%"/> </div><br>

实际释放的是 header 加上分配给用户空间的大小



**Example**

假设内存块大小：4KB（4096 bytes）

header 占了 8 bytes -> 剩下 4088 bytes

<div align="center"> <img src="1023521-20200503210318164-1907980045.png" width="50%"/> </div><br>



假设一个 100 bytes 的内存请求

<div align="center"> <img src="1023521-20200503210427959-1653820691.png" width="50%"/> </div><br>



### 3.2 Strategy

**Example**



