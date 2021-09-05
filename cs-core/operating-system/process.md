# Process Management

Table of Contents
-----------------

- [Table of Contents](#table-of-contents)
- [1. 进程](#1-进程)
	- [1.1 进程模型](#11-进程模型)
	- [1.2 进程创建与销毁](#12-进程创建与销毁)
	- [1.3 进程状态](#13-进程状态)
- [2. 线程](#2-线程)
- [3. 进程间通信](#3-进程间通信)
- [4. 调度](#4-调度)
- [5. 经典 IPC 问题](#5-经典-ipc-问题)


## 1. 进程

> An abstraction of a running program

### 1.1 进程模型

**Process**

<div align="center"> <img src="./pics/process.png" width="80%"/> </div><br>

**进程与程序的区别?**

A process is an **activity** of some kind, including a program, input, output, and a state.

### 1.2 进程创建与销毁

**fork**

- In *UNIX*, the only one system call to create a new process
- **No writable memory is shared**

**copy-on-write**

Whenever either of the two processes wants to modify part of the memory, that chunk of memory is explicitly **copied first** to make sure the modification occurs in a private memory area. **Again, no writable memory is shared**

### 1.3 进程状态

<div align="center"> <img src="./pics/image-20210905165120289.png" width="40%"/> </div><br>

**四种转换**

1. *Process* blocks for input
2. Scheduler picks another *process*
3. Scheduler picks this *process*
4. Input becomes available




## 2. 线程

## 3. 进程间通信



## 4. 调度



## 5. 经典 IPC 问题







