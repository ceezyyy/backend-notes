# Spring

Table of Contents
-----------------

* [1. Overview](#1-overview)
   * [1.1 IoC](#11-ioc)
   * [1.2 AOP](#12-aop)
* [2. Wiring beans](#2-wiring-beans)
   * [2.1 Autowiring](#21-autowiring)
   * [2.2 Config in Java](#22-config-in-java)
   * [2.3 Config in XML](#23-config-in-xml)
* [References](#references)

## 1. Overview

> Spring makes *Java* simple

### 1.1 IoC

> Inversion of Control: makes it possible to tie software components together loosely 

**Container**

- *BeanFactory*
- *ApplicationContext* (recommended)

<div align="center"> <img src="image-20210310111944788.png" width="35%"/> </div><br>

### 1.2 AOP

> Aspect Oriented Programming: enables you to capture functionality that's used throughout your application in reusable components

**Why AOP?**

<div align="center"> <img src="image-20210309211432313.png" width="55%"/> </div><br>



**AOP**

<div align="center"> <img src="image-20210309211605138.png" width="60%"/> </div><br>



## 2. Wiring beans

### 2.1 Autowiring

**Component Scanning**

- All `@Component`-annotated classes will be created as beans whose ID is uncapitalized class name
- `@ComponentScan` -> discovery beans



**Autowired & Qualifier**

- The para given to `@Qualifier` is the ID of the bean that you want to inject




### 2.2 Config in Java

**Scoping beans**

- *Singleton*
- *Prototype*
- *Session*
- *Request*



### 2.3 Config in XML

- When *Spring* sees this `<bean>` element, it will create bean by calling its **default constructor**
- Constructor injection
- Setting properties





## References

- *Spring in Action, Fourth Edition*