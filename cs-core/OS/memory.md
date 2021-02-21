# Memory Management

Table of Contents
-----------------

* [1. Overview](#1-overview)
* [2. Base and Bound](#2-base-and-bound)
* [3. Segmentation](#3-segmentation)
* [4. Free-space Management](#4-free-space-management)
   * [4.1 Mechanism](#41-mechanism)
      * [4.1.1 Splitting &amp; merging](#411-splitting--merging)
      * [4.1.2 Tracking](#412-tracking)
* [5. Paging](#5-paging)
   * [5.1 Basic](#51-basic)
      * [5.1.1 Page](#511-page)
      * [5.1.2 Page frame](#512-page-frame)
      * [5.1.3 Page table](#513-page-table)
      * [5.1.4 A memory trace](#514-a-memory-trace)
   * [5.2 TLB](#52-tlb)
      * [5.2.1 Cache](#521-cache)
      * [5.2.2 Composition](#522-composition)
   * [5.3 Smaller table](#53-smaller-table)
      * [5.3.1 Segmentation   paging](#531-segmentation--paging)
      * [5.3.2 Multi-level page table](#532-multi-level-page-table)

## 1. Overview

<div align="center"> <img src="virtual-address-space.png" width="40%"/> </div><br>

## 2. Base and Bound

<div align="center"> <img src="base-and-bound.jpg" width="35%"/> </div><br>

**Example**

physical address = virtual address (offset) + base

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



## 3. Segmentation

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



## 4. Free-space Management

**FreeSpaceManagement.c**

```c
// Allocates the requested memory and returns a pointer to it
void *malloc(size_t size)


// Deallocates the memory previously allocated by a call to calloc/malloc/realloc
void free(void *ptr)
```

### 4.1 Mechanism

#### 4.1.1 Splitting & merging

<div align="center"> <img src="splitting-merging-1.png" width="40%"/> </div><br>

free list

<div align="center"> <img src="splitting-merging-2.png" width="40%"/> </div><br>

`malloc(1)`

<div align="center"> <img src="splitting-merging-3.png" width="40%"/> </div><br>

`free(10)`（10 is a pointer）

<div align="center"> <img src="splitting-merging-4.png" width="50%"/> </div><br>

merging

<div align="center"> <img src="splitting-merging-5.png" width="30%"/> </div><br>



#### 4.1.2 Tracking

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

free: header + space allocated to users



**Example**

memory: 4KB (4096 bytes)

header: 8 bytes -> rest: 4088 bytes

<div align="center"> <img src="1023521-20200503210318164-1907980045.png" width="50%"/> </div><br>



request: 100 bytes

<div align="center"> <img src="1023521-20200503210427959-1653820691.png" width="50%"/> </div><br>



## 5. Paging

### 5.1 Basic

#### 5.1.1 Page

<div align="center"> <img src="page.png" width="40%"/> </div><br>

#### 5.1.2 Page frame

<div align="center"> <img src="page-frame.png" width="40%"/> </div><br>

#### 5.1.3 Page table

**Example**

process: 64 bytes

page: 16 bytes

<div align="center"> <img src="virtual-address-1.png" width="30%"/> </div><br>

VPN: virtual page number

<div align="center"> <img src="virtual-address-2.png" width="30%"/> </div><br>

<div align="center"> <img src="virtual-address-3.png" width="30%"/> </div><br>

PFN: page frame number

<div align="center"> <img src="virtual-address-4.png" width="35%"/> </div><br>

**PTE: page table entry**

<div align="center"> <img src="pte.png" width="60%"/> </div><br>



#### 5.1.4 A memory trace

> Reference: the use of a source of information in order to ascertain something

**Example**

```c
int arr[1000];
// do something
for (int i = 0; i < 1000; i++) {
  arr[i] = 0;
}
```

**assembly code**

<div align="center"> <img src="image-20210221123515826.png" width="50%"/> </div><br>

**virtual space: 64 KB**

page: 1 KB

code: VPN 1

arr: VPN 39 - 42



**physical space**

page table: 1 KB



**memory access**

前 5 次循环迭代的过程（假设 page table 在物理内存中）



<div align="center"> <img src="image-20210221123604766.png" width="60%"/> </div><br>

### 5.2 TLB

#### 5.2.1 Cache 

**Example**

virtual address: 256 bytes

page: 16 bytes

int a[10];

**ExampleOfTLB.c**

```c
int sum = 0;
doe (int i = 0; i < 10; i++) {
  sum += a[i];
}
```

**result**

```
miss hit hit miss hit hit hit miss hit hit
```



<div align="center"> <img src="image-20210221152502598.png" width="40%"/> </div><br>

#### 5.2.2 Composition

**ASID: address space identifier**

<div align="center"> <img src="image-20210221163801316.png" width="50%"/> </div><br>

<div align="center"> <img src="image-20210221163816134.png" width="50%"/> </div><br>

### 5.3 Smaller table

#### 5.3.1 Segmentation + paging

<div align="center"> <img src="image-20210221170735548.png" width="45%"/> </div><br>

**Example**

virtual address: 32 bits

page: 4 KB

<div align="center"> <img src="image-20210221170902428.png" width="60%"/> </div><br>

#### 5.3.2 Multi-level page table

<div align="center"> <img src="image-20210221181839504.png" width="70%"/> </div><br>

**Example**

virtual address: 16 KB, page: 64 bytes -> at least 256 PTEs

PTE: 4 bytes -> page table: 1 KB



<div align="center"> <img src="image-20210221184037946.png" width="50%"/> </div><br>



so, page table has 16 units -> 4 bits

<div align="center"> <img src="image-20210221190148926.png" width="50%"/> </div><br>

