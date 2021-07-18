# Kafka

## Table of Contents

- [1. Brainstorming](#1-brainstorming)
- [2. 概述](#2-概述)
	- [2.1 三大角色](#21-三大角色)
	- [2.2 架构](#22-架构)
- [3. 生产者](#3-生产者)
- [4. 消费者](#4-消费者)
- [References](#references)

## 1. Brainstorming

<div align="center"> <img src="./pics/kafka.svg" width="100%"/> </div><br>

## 2. 概述

### 2.1 三大角色

- 消息系统
- 存储系统
  - 消息持久化
  - 多副本机制
- 流式处理平台

### 2.2 架构

**Outline**

<div align="center"> <img src="./pics/structure.png" width="60%"/> </div><br>

- 由多个 *broker* 组成（多个节点）
- **每个 *topic*，可以划分为多个 *partition*，每个 *partition* 有多个副本，保存在不同的 *broker* 上**

## 3. 生产者

**Client**

<div align="center"> <img src="./pics/kafka-client.png" width="70%"/> </div><br>

## 4. 消费者

> 消费者是实际的应用实例，可以是一个线程/进程

**消费组与消费者模型**

<div align="center"> <img src="./pics/consumers.png" width="30%"/> </div><br>

- 如果所有 *consumer* 都隶属于同一个 *consumer group* -> 每条消息只会被**一个** *consumer* 处理 (**P2P**)
- 如果所有 *consumer* 都隶属于不同 *consumer group* -> 每条消息会被**所有**的 *consumer* 处理 (**Pub/Sub**)


## References

- [Kafka](https://kafka.apache.org/)
- [Apache Kafka 101](https://www.youtube.com/watch?v=j4bqyAMMb7o&list=PLa7VYi0yPIH0KbnJQcMv5N9iW8HkZHztH)
- *Kafka: The Definitive Guide*
- *深入理解 Kafka 核心设计与实践原理*
- [Kafka简明教程](https://zhuanlan.zhihu.com/p/37405836)
- [Kafka in a Nutshell](https://sookocheff.com/post/kafka/kafka-in-a-nutshell/)
