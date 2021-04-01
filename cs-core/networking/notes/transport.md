# Transport Layer

Table of Contents
-----------------

* [1. MUX &amp; DEMUX](#1-mux--demux)
* [2. UDP](#2-udp)
* [3. TCP](#3-tcp)
   * [3.1 Overview](#31-overview)
   * [3.2 Connection](#32-connection)
      * [3.2.1 Setup](#321-setup)
      * [3.2.2 Teardown](#322-teardown)
   * [3.3 Reliable Delivery](#33-reliable-delivery)
      * [3.3.1 Go-back-N](#331-go-back-n)
      * [3.3.2 Selective Repeat](#332-selective-repeat)
      * [3.3.3 Fast Retransmit](#333-fast-retransmit)
   * [3.4 Flow Control](#34-flow-control)
   * [3.5 Congestion Control](#35-congestion-control)
      * [3.5.1 Congestion Window](#351-congestion-window)
      * [3.5.2 Slow Start](#352-slow-start)
      * [3.5.3 Why AIMD](#353-why-aimd)
* [References](#references)

## 1. UDP

**UDP segment**

<div align="center"> <img src="image-20210302105457294.png" width="35%"/> </div><br>

## 2. TCP

### 2.1 Overview

**TCP segment**

<div align="center"> <img src="image-20210302115042177.png" width="50%"/> </div><br>



**Example**


<div align="center"> <img src="image-20210302151130634.png" width="40%"/> </div><br>



<div align="center"> <img src="image-20210302151211674.png" width="60%"/> </div><br>



<div align="center"> <img src="image-20210302151311857.png" width="55%"/> </div><br>









### 2.2 Connection-oriented

#### 2.2.1 Setup

**Connection setup**

<div align="center"> <img src="image-20210226173526009.png" width="50%"/> </div><br>

**3-way handshake**

<div align="center"> <img src="image-20210225143351607.png" width="30%"/> </div><br>

*step 1:* SYN = 1, seq = client_isn (*isn* means initial sequence number)

*step 2:* SYN = 1, ACK = client_isn + 1, seq = server_isn

*step 3:* SYN = 0, ACK = server_isn + 1, seq = client_isn + 1 (data)





**TCP connection**

<div align="center"> <img src="what-is-tcp-connection.png" width="70%"/> </div><br>

#### 2.2.2 Teardown

**Connection teardown**

<div align="center"> <img src="image-20210226184427464.png" width="50%"/> </div><br>

**4-way handshake**

<div align="center"> <img src="image-20210225143816877.png" width="30%"/> </div><br>







### 2.3 Reliable Delivery

#### 2.3.1 Go-back-N

<div align="center"> <img src="image-20210227121045315.png" width="65%"/> </div><br>

**Initialization**

send_base = 0, nextseqnum = 0



#### 2.3.2 Selective Repeat

**Sender**

- *Data received above:* If the sequence number is within the sender's window -> the data is packetized and sent
- *Timeout:* Each packet has its own logical timer
- *ACK received:*
  - In the window: marked as received
  - Equal to *send_base*: *send_base* **move forward to the unacknowledged packet w/ the smallest sequence number**

<div align="center"> <img src="image-20210227152729195.png" width="70%"/> </div><br>

**Receiver**

- *Packet in [rcv_base, rcv_base + N - 1]:* 
  - Sent back an ACK
  - And if this packet's number equals to *rcv_base*, and any pre buffered and consecutively numbered -> delivery to the upper layer -> window move forward *x* units
- *Packet in [rcv_base - N, rcv_base - 1]:* Sent back an ACK



<div align="center"> <img src="image-20210227152821480.png" width="70%"/> </div><br>

**Example**

<div align="center"> <img src="image-20210227153243525.png" width="60%"/> </div><br>

#### 2.3.3 Fast Retransmit

> A hybrid of GBN and SR protocol

<div align="center"> <img src="image-20210302152338698.png" width="65%"/> </div><br>



### 2.4 Flow Control

**Sliding window**

<div align="center"> <img src="image-20210304141033128.png" width="60%"/> </div><br>

**Send & Receive buffer**

<div align="center"> <img src="image-20210302114501947.png" width="60%"/> </div><br>

<div align="center"> <img src="image-20210226163617682.png" width="50%"/> </div><br>

**Sending rate for a single flow**

<div align="center"> <img src="image-20210304171350402.png" width="60%"/> </div><br>



**Receive window**

```matlab
rwnd = RcvBuffer - (LastByteRcvd - LastByteRead)
```




<div align="center"> <img src="sliding-window.png" width="60%"/> </div><br>

**Receiver**

```matlab
LastByteRcvd - LastByteRead <= RcvBuffer
```



**Sender**

```matlab
LastByteSend - LastByteAcked <= rwnd
```





### 2.5 Congestion Control

#### 2.5.1 Congestion Window

```matlab
LastByteSent - LastByteAcked <= min{cwnd, rwnd}
```

#### 2.5.2 Slow Start

<div align="center"> <img src="image-20210305113110093.png" width="35%"/> </div><br>

**TCP Tahoe**

<div align="center"> <img src="image-20210305114726950.png" width="50%"/> </div><br>

**TCP Reno**

<div align="center"> <img src="image-20210305114848694.png" width="50%"/> </div><br>

**TCP Tahoe vs. TCP Reno**

<div align="center"> <img src="tcp-congestion-example.png" width="70%"/> </div><br>



#### 2.5.3 Why AIMD

**AIMD**

<div align="center"> <img src="image-20210304151010216.png" width="50%"/> </div><br>

**Chiu Jain Plot**

<div align="center"> <img src="image-20210305120746694.png" width="40%"/> </div><br>



## References

- [Go-Back-N Protocol - Baeldung](https://www.baeldung.com/cs/networking-go-back-n-protocol)
- [Selective Repeat Protocol](https://media.pearsoncmg.com/aw/ecs_kurose_compnetwork_7/cw/content/interactiveanimations/selective-repeat-protocol/index.html)
- [The Difference Between a Port and a Socket](https://www.baeldung.com/cs/port-vs-socket)
- [What is "Fair" ?](http://www.mathcs.emory.edu/~cheung/Courses/558/Syllabus/11-Fairness/Fair.html)

