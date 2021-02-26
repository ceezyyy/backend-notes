# Network Layer

Table of Contents
-----------------

* [1. Internet Protocol](#1-internet-protocol)
* [2. Routing](#2-routing)
   * [2.1 CIDR](#21-cidr)
   * [2.2 Longest Prefix Match](#22-longest-prefix-match)


## 1. Internet Protocol

**Error Detection**

<div align="center"> <img src="image-20210225170804254.png" width="50%"/> </div><br>



## 2. Routing

### 2.1 CIDR

**Example**

| Source       | Destination  | Netmask         | Same Network? |
| ------------ | ------------ | --------------- | ------------- |
| 128.34.1.15  | 128.35.1.15  | 255.255.0.0     | No            |
| 10.0.1.4     | 10.0.1.5     | 255.255.255.0   | Yes           |
| 10.0.1.4     | 10.0.2.5     | 255.255.255.0   | No            |
| 171.64.15.33 | 171.64.15.5  | 255.255.255.224 | No            |
| 171.64.15.33 | 171.19.201.2 | 255.0.0.0       | Yes           |

### 2.2 Longest Prefix Match

**Example**

<div align="center"> <img src="image-20210225122324138.png" width="30%"/> </div><br>



|     Dest     | Link |
| :----------: | :--: |
|  63.19.5.3   |  3   |
| 171.15.15.0  |  4   |
|  63.19.5.32  |  1   |
| 44.199.230.1 |  1   |
| 171.128.16.0 |  2   |



