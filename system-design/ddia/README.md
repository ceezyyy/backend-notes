# Data-Intensive Application

## Brainstorming

<div align="center"> <img src="./pics/DDIA.svg" width="100%"/> </div><br>

## Table of Contents

- [1. Overview](#1-overview)
- [2. Data Models](#2-data-models)
- [3. Storage and Retrieval](#3-storage-and-retrieval)
	- [3.1 Hash](#31-hash)
- [References](#references)

## 1. Overview

**Reliable**

- Making system work correctly, even when the faults occur

**Scalable**

- Having strategies for keeping performance good, even when load increases

**Maintainable**

- Making life better for the engineering and operations teams who need to work with the system

**Data system**

<div align="center"> <img src="./pics/image-20210919170945287.png" width="70%"/> </div><br>

## 2. Data Models

**Relational model**

<div align="center"> <img src="./pics/image-20210919143110231.png" width="70%"/> </div><br>

**Document model**

<div align="center"> <img src="./pics/image-20210919140757990.png" width="70%"/> </div><br>

- storage locality (stored as a single continuous string)
- one to many
- no relationships

**Graph model**

<div align="center"> <img src="./pics/image-20210919154701784.png" width="70%"/> </div><br>

- many to many

## 3. Storage and Retrieval

> How we can store the data that we're given, and how we can find it again when we're asked for

### 3.1 Hash

**Append-only log**

<div align="center"> <img src="./pics/image-20210919202706768.png" width="70%"/> </div><br>

**Compaction**

<div align="center"> <img src="./pics/image-20210919202407681.png" width="70%"/> </div><br>

**Pros**

- *Sequential write* operations, which are much faster than *random writes*
- Concurrency and crash recovery are much simpler if segment files are *append-only*

**Cons**

- The *hash table* must fit in memory, so it's not suitable for a very large number of keys
- *Range queries* are not efficient

## References

- *Designing Data-Intensive Applications: The Big Ideas Behind Reliable, Scalable, and Maintainable Systems*

