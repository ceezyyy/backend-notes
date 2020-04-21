# JavaScript


<div align="center"> <img src="javascript.jpg" width="60%"/> </div><br>



## 目录

  * [1. 什么是 JavaScript ?](#1-----javascript--)
  * [2. 为什么要用 JavaScript ?](#2-------javascript--)
  * [3. JavaScript 快速入门](#3-javascript-----)
    + [3.1 数据类型](#31-----)
    + [3.2 运算符](#32----)
      - [3.2.1 `+` 号妙用](#321--------)
      - [3.2.2 `==` 与 `===`](#322-------------)
    + [3.3 基本对象](#33-----)
      - [3.3.1 Function 对象](#331-function---)
      - [3.3.2 Array 对象](#332-array---)
      - [3.3.3 Regex 对象](#333-regex---)
  * [4. JavaScript 进阶](#4-javascript---)
    + [4.1 DOM](#41-dom)
      - [4.1.1 什么是 `DOM` ?](#411------dom---)
      - [4.1.2 `DOM` 有什么用 ?](#412--dom--------)
    + [4.2 BOM](#42-bom)
    + [4.3 事件](#43---)





## 1. 什么是 JavaScript ?

**`JavaScript`是一门客户端脚本语言**

特点：

1. 运行在客户端（每个浏览器都有 JS 解析引擎）
2. 脚本语言（不需要编译，直接被浏览器引擎解析）



## 2. 为什么要用 JavaScript ?

在前端三件器中：

`HTML`：显示页面（最基础的页面）

`CSS`：美观页面

`JavaScript`：增强与用户之间的交互，做动态内容



## 3. JavaScript 快速入门

### 3.1 数据类型

1. `number`
2. `string`
3. `boolean`
4. `null`
5. `undefined`



:warning:注意

Js 是一本弱类型语言

声明变量用 `var` 关键字

```javascript
var a
```
<div align="center"> <img src="image-20200421113334363.png" width="30%"/> </div><br>

**number**

1. 整数
2. 小数
3. NaN

<div align="center"> <img src="image-20200421113432919.png" width="30%"/> </div><br>

**string**

1. 字符

2. 字符串

   

<div align="center"> <img src="image-20200421113656666.png" width="25%"/> </div><br>

**boolean**

1. true
2. false

<div align="center"> <img src="image-20200421113827407.png" width="25%"/> </div><br>

**null**

<div align="center"> <img src="image-20200421114021078.png" width="25%"/> </div><br>

Js 的一个bug :smile:



**undefined**

<div align="center"> <img src="image-20200421113925994.png" width="30%"/> </div><br>

### 3.2 运算符

#### 3.2.1 `+` 号妙用

在 Js 中，`+` 不仅仅是加法运算符

<div align="center"> <img src="image-20200421115135829.png" width="30%"/> </div><br>

还可以用来：**类型转换**

1. `string` 类型

   - 纯数字->  转 `字面值`

     <div align="center"> <img src="image-20200421115440096.png" width="30%"/> </div><br>

   - 非纯数字：转 `NaN`
   
     <div align="center"> <img src="image-20200421115509656.png" width="40%"/> </div><br>




2. `boolean` 类型

   - `true`：1

   - `false`：0

<div align="center"> <img src="image-20200421115948403.png" width="30%"/> </div><br>



#### 3.2.2 `==` 与 `===`

在 Js 中，`==` 号用来判断两个变量的值是否相等

- 若两个变量是同一类型：直接判断

- 若不同类型：转成同一类型再判断

  


<div align="center"> <img src="image-20200421161141701.png" width="30%"/> </div><br>



`===`：判断两个变量的类型和值是否完全相同


<div align="center"> <img src="image-20200421161441995.png" width="30%"/> </div><br>



### 3.3 基本对象

1. `Function` 对象
2. `Array` 对象



#### 3.3.1 Function 对象



```javascript

```

:warning:注意

1. 形参类型可省略（弱类型），返回参数可省略
2. 方法调用只与函数名称有关，与参数列表无关
3. `function.length` 返回函数形参的个数
4. 



#### 3.3.2 Array 对象



```javascript
var arr = new Array()  // 创建空数组
var arr = new Array(5)  // 长度为 5 的数组，默认为空
var arr = [1,2,3]  // 直接赋值
```



<div align="center"> <img src="image-20200421164751259.png" width="60%"/> </div><br>


:warning:注意

1. 列表中元素类型可不统一
2. 数组长度可变（可自动扩容，不存在 `index` 溢出）



**常用方法**

**join()：拼接字符串**

<div align="center"> <img src="image-20200421165445260.png" width="30%"/> </div><br>

**push()：动态增加元素**

<div align="center"> <img src="image-20200421165753451.png" width="40%"/> </div><br>

#### 3.3.3 Regex 对象

**正则表达式**

1. 单个字符 `[]`

   `\d`：[0-9]（英文：digit）

   `\w`：[a-zA-Z0-9_] （英文：word）

2. 量词符号

   `?`：出现 0 次或 1 次

   `*`：出现 0 次或多次

   `+`：出现 1 次或多次

   `{m,n}`：出现 `m <= x <= n` 次

3. 开始结束

   `^`：开始

   `$`：结束



**正则对象**

1. 创建

```javascript
var reg = /regular expression/
```

 

2. 用法

   **判断一个字符串是否符合定义的 `reg` 规则**

   ```javascript
   var reg = /^\w{1,9}$/
   reg.test()  // 返回 true / false
   ```

   



## 4. JavaScript 进阶

### 4.1 DOM

#### 4.1.1 什么是 `DOM` ? 

<div align="center"> <img src="image-20200421224823030.png" width="60%"/> </div><br>



`DOM` 用来操作 html 的内容



#### 4.1.2 `DOM` 有什么用 ?

`DOM`可以修改 `html` 里面标签的属性 / 标签体内容







### 4.2 BOM







### 4.3 事件



