# Transport Layer

Table of Contents
-----------------

* [1. TCP](#1-tcp)
   * [1.1 Header](#11-header)
   * [1.2 Setup and Teardown](#12-setup-and-teardown)
      * [1.2.1 Setup: 3-way handshake](#121-setup-3-way-handshake)
      * [1.2.2 Teardown: 4-way handshake](#122-teardown-4-way-handshake)
   * [1.3 Flow Control](#13-flow-control)
      * [1.3.1 Sliding Window](#131-sliding-window)
* [2. UDP](#2-udp)



## 1. TCP

### 1.1 Header

**TCP header**


<div align="center"> <img src="image-20210226165610010.png" width="50%"/> </div><br>

### 1.2 Setup and Teardown

#### 1.2.1 Setup: 3-way handshake

<div align="center"> <img src="image-20210226173526009.png" width="50%"/> </div><br>

- step 1: **SYN**, S<sub>A</sub>

- step 2:

  - **SYN**, S<sub>B</sub>

  - **ACK**, S<sub>A+1</sub>

- step 3:

  - S<sub>A+1</sub>
  - **ACK**, S<sub>B+1</sub>

<div align="center"> <img src="image-20210225143351607.png" width="30%"/> </div><br>



#### 1.2.2 Teardown: 4-way handshake

<div align="center"> <img src="image-20210226184427464.png" width="50%"/> </div><br>



<div align="center"> <img src="image-20210225143816877.png" width="30%"/> </div><br>

**FSM**

P.S: *action taken on state transition* is optional

<div align="center"> <img src="image-20210225180344409.png" width="40%"/> </div><br>

**TCP Connection**

<div align="center"> <img src="image-20210225183359173.png" width="90%"/> </div><br>



### 1.3 Flow Control

**Problem**

<div align="center"> <img src="image-20210226120224860.png" width="50%"/> </div><br>



**Stop and wait FSM**

<div align="center"> <img src="image-20210226121825605.png" width="50%"/> </div><br>




#### 1.3.1 Sliding Window

<div align="center"> <img src="image-20210226125825295.png" width="50%"/> </div><br>

**Receive window (rwnd)**

<div align="center"> <img src="sliding-window.png" width="60%"/> </div><br>

**Reciever keep tracking of**

- LastByteRead
- LastByteRcvd
- LastByteRcvd - LastByteRead <= RcvBuffer



**Sender keep tracking of**

- LastByteSent
- LastByteAcked

- LastByteSent - LastByteAcked <= rwnd



**TCP flow control**

Initialization: rwnd = RcvBuffer

<div align="center"> <img src="image-20210226163617682.png" width="50%"/> </div><br>





## 2. UDP


