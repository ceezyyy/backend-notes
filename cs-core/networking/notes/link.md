# Link Layer

Table of Contents
-----------------

* [1. Ethernet Switching](#1-ethernet-switching)


## 1. Ethernet Switching

**Explained**

1. Examine the header of each arriving frame
2. If the Ethernet *dest address* is in the *forwarding table*, forward the frame to the correct output ports
3. If the Ethernet *dest address* is not in the table, broadcast the frame to **all** ports (expect the one through which the frame arrived)
4. Entries in the table are learned by examining the Ethernet *source address* of arriving packets

