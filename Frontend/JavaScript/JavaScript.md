# JavaScript


<div align="center"> <img src="javascript.jpg" width="60%"/> </div><br>



## Category

* [1. What is JavaScript](#1-what-is-javascript)
* [2. Why we use JavaScript](#2-why-we-use-javascript)
* [3. JavaScript Quickstart](#3-javascript-quickstart)
  + [3.1 Data type](#31-data-type)
  + [3.2 Operator](#32-operator)
    - [3.2.1 `+`](#321----)
    - [3.2.2 `==` and `===`](#322------and------)
  + [3.3 Object](#33-object)
    - [3.3.1 Function](#331-function)
    - [3.3.2 Array](#332-array)
    - [3.3.3 Regex](#333-regex)
* [4. JavaScript Advanced](#4-javascript-advanced)
  + [4.1 DOM](#41-dom)
    - [4.1.1 What is DOM](#411-what-is-dom)
    - [4.1.2 Why we use DOM](#412-why-we-use-dom)
    - [4.1.3 DOM Quickstart](#413-dom-quickstart)
  + [4.2 BOM](#42-bom)
    - [What is BOM](#what-is-bom)
    - [Why we use BOM](#why-we-use-bom)
    - [Quickstart](#quickstart)
  + [4.3 Event](#43-event)
    - [4.3.1 What is Event](#431-what-is-event)
    - [4.3.2 Quickstart](#432-quickstart)

## 1. What is JavaScript 

**`JavaScript`是一门客户端脚本语言**

特点：

1. 运行在客户端（每个浏览器都有 JS 解析引擎）
2. 脚本语言（不需要编译，直接被浏览器引擎解析）



## 2. Why we use JavaScript 

在前端三件器中：

`HTML`：显示页面（最基础的页面）

`CSS`：美观页面

`JavaScript`：增强与用户之间的交互，做动态内容



## 3. JavaScript Quickstart

### 3.1 Data type

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

### 3.2 Operator

#### 3.2.1 `+` 

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



#### 3.2.2 `==` and `===`

在 Js 中，`==` 号用来判断两个变量的值是否相等

- 若两个变量是同一类型：直接判断

- 若不同类型：转成同一类型再判断

  


<div align="center"> <img src="image-20200421161141701.png" width="30%"/> </div><br>



`===`：判断两个变量的类型和值是否完全相同


<div align="center"> <img src="image-20200421161441995.png" width="30%"/> </div><br>



### 3.3 Object

1. `Function` 对象
2. `Array` 对象



#### 3.3.1 Function 



```javascript

```

:warning:注意

1. 形参类型可省略（弱类型），返回参数可省略
2. 方法调用只与函数名称有关，与参数列表无关
3. `function.length` 返回函数形参的个数
4. 



#### 3.3.2 Array 



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

#### 3.3.3 Regex 

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

   :warning:注意
   
   `\w` 为反斜杠



## 4. JavaScript Advanced

### 4.1 DOM

#### 4.1.1 What is DOM 

`DOM` 是将标记语言的各个（组成）部分封装成对象，便于进行 `CRUD` 操作 

<div align="center"> <img src="DOM.png" width="80%"/> </div><br>





#### 4.1.2 Why we use DOM 

`DOM` 通过特定 `id` 值来获取`html` 元素，通过调用方法来修改其属性



#### 4.1.3 DOM Quickstart

1. 获取 `html` 标签对象

   ```javascript
   document.getElementById("id")  // 获取 html tag 对象
   ```

2. 查 `API` 修改属性


```html
<body>
    <img id="laptop" src="../img/lenovo.jpg">
    <p id="text"> Hello World! </p>


    <script>
        var laptop = document.getElementById("laptop")
        alert("I'm gonna change!")
        laptop.src = "../img/mbp.jpg"

        var text = document.getElementById("text")
        text.innerHTML = "Succeeded!"
    </script>
</body>

```

<div align="center"> <img src="image-20200422100154652.png" width="100%"/> </div><br>



<div align="center"> <img src="image-20200422100207596.png" width="100%"/> </div><br>

#### 4.1.4 Demo 实战

**效果**

<div align="center"> <img src="image-20200427203157303.png" width="50%"/> </div><br>

<div align="center"> <img src="image-20200427203131045.png" width="50%"/> </div><br>

点击 `Turn on` 按钮：文本显示为超链接，链接到 `baidu`

点击 `Turn off` 按钮：文本去除超链接



```javascript
    <script>
        var a = document.getElementById("hello")
        
        var change = function () {
            a.setAttribute("href", "https://www.baidu.com")
        }

        var withdraw = function () {
            a.removeAttribute("href")
        }
    </script>
```



**总结**

获取元素之后：

1. 设置属性
2. 移除属性



### 4.2 BOM

#### What is BOM 

`BOM` 就是 `Browser Object Model`

将浏览器封装成一个对象



<div align="center"> <img src="Window.png" width="40%"/> </div><br>


:warning:注意

1. 是 `Window`，单数，当前窗口只有一个，可以默认不写

2. `Location` 和 `History` 属于 `Window` 窗口

   

**Screen**

<div align="center"> <img src="image-20200422142847674.png" width="80%"/> </div><br>

****

**Window**

<div align="center"> <img src="image-20200422142950818.png" width="60%"/> </div><br>



**Location**

<div align="center"> <img src="image-20200422143008352.png" width="100%"/> </div><br>





**History**

<div align="center"> <img src="image-20200422143034349.png" width="60%"/> </div><br>



#### Why we use BOM 





#### Quickstart



1. 使用 `Js` 实现轮播图

```html
<body>
    <img id="img" src="../img/1.jpg">

    <script>
        var number = 1
        function move() {
            var img = document.getElementById("img")
            if (number == 4) {
                number = 1;
            } else {
                img.src = "../img/" + number + ".jpg";
                number++;
            }
        }

        setInterval(move, 1000)  // 设置调用函数时间间隔
    </script>
</body>
```


<div align="center"> <img src="image-20200422122113533.png" width="80%"/> </div><br>


<div align="center"> <img src="image-20200422122123384.png" width="80%"/> </div><br>

<div align="center"> <img src="image-20200422122134552.png" width="80%"/> </div><br>

2. 自动跳转首页



<div align="center"> <img src="image-20200422144335200.png" width="80%"/> </div><br>



<div align="center"> <img src="image-20200422144345286.png" width="80%"/> </div><br>



```html
<body>
    <p>
        <span id="countdown">
            5
        </span>
        秒之后，自动跳转到 Google
    </p>

    <script>
        var countdown = 5;
        var time = document.getElementById("countdown");

        function count() {
            if (countdown <= 0) {
                location.href = "http://www.google.com";
            } else {    
                time.innerHTML = countdown - 1;
                countdown--;
            } 
        }

        setInterval(count, 1000)

    </script>
</body>
```





### 4.3 Event

#### 4.3.1 What is Event 

用户在 `html` 页面上会执行某些事件，比如：

1. 单击

2. 双击

3. 鼠标移动

4. 键盘按下

   ......



**`Js` 可以应对这些事件**



<div align="center"> <img src="image-20200427204957429.png" width="70%"/> </div><br>

#### 4.3.2 Quickstart

需求：

当用户点击灯泡时：（时间）

1. 熄灭的灯泡会点亮（应对事件）
2. 点亮的灯泡会熄灭（应对事件）



这里的 `onclick=""` 指用户点击这个行为发生之后，`Js` 通过调用 `control()` 方法来应对这个事件



```html
<body>
    <img id="bulb" src="../img/bulb_off.jpg" onclick="control()">
</body>
```



<div align="center"> <img src="image-20200422105631779.png" width="80%"/> </div><br>

<div align="center"> <img src="image-20200422105640476.png" width="80%"/> </div><br>