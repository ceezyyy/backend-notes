# 操作系统

Table of Contents
-----------------

* [Brainstorming](#brainstorming)
* [1. 操作系统内核图](#1-操作系统内核图)
* [2. 操作系统四大特征](#2-操作系统四大特征)
* [3. Process Life Cycle](#3-process-life-cycle)
* [4. 算法调度评价指标](#4-算法调度评价指标)
* [5. 交互式系统：时间片轮转调度算法](#5-交互式系统时间片轮转调度算法)
* [References](#references)



## Brainstorming

<div align="center"> <img src="os.svg" width="100%"/> </div><br>

## 1. 操作系统内核图

<div align="center"> <img src="image-20201226132040321.png" width="80%"/> </div><br>

## 2. 操作系统四大特征

- 并发：计算机系统同时存在着多个运行的程序
- 共享：系统资源可供内存中多个并发的进程共同使用
- 虚拟：将物理实体映射成多个逻辑实体
- 异步：并发下，进程的执行不是一步到底，而是走走停停



## 3. Process Life Cycle

<div align="center"> <img src="process-life-cycle.png" width="80%"/> </div><br>

- `new` -> `ready`：操作系统完成进程创建工作
- `ready` -> `running`：进程准备就绪，等待 `CPU` 调度
- `running` -> `ready`：`CPU` 时间片到 / 有优先级很高的进程抢占调度
- `running` -> `blocked`：等待系统调度 / 等待某事件（**主动**）
- `blocked` -> `ready`：资源分配已到位 / 等待的时间已发生（**被动**）
- `running` -> `terminated`：进程运行结束 / 运行过程中遇到不可修复错误



## 4. 算法调度评价指标

- `CPU` 利用率：忙碌的时间 / 总时间
- 系统吞吐量：完成的总作业数 / 总时间
- 周转时间：作业完成时间 - 作业提交时间
- 等待时间：作业等待调度时间总和
- 响应时间：首次相应与提交请求时间差



## 5. 交互式系统：时间片轮转调度算法

<div align="center"> <img src="image-20201226192757466.png" width="40%"/> </div><br>

当时间片为 2 时：

<div align="center"> <img src="image-20201226193253039.png" width="60%"/> </div><br>



当时间片为 5 时：





**注意：**

- 在时间片内，若进程执行完毕，会主动放弃 `CPU`（进行下一次调度）



## References

- [趣谈Linux操作系统](https://time.geekbang.org/column/intro/164)
- [Process Life Cycle](https://zitoc.com/process-life-cycle/#:~:text=The%20process%20life%20cycle%20can,process%20control%20block%20(PCB).)

