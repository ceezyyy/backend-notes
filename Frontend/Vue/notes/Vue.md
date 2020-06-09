# Vue

## 目录
* [0. Hello World!](#0-hello-world-)
* [1. data](#1-data)
* [2. v-text](#2-v-text)
* [3. v-html](#3-v-html)
* [4. @click](#4--click)
* [5. Counter demo](#5-counter-demo)



## 0. Hello World!

```html
<body>
    <div id="app">
        <h1>{{message}}</h1>
    </div>
</body>
```

```javascript
var app = new Vue({
    el: "#app",
    data: {
        message: "Hello World!"
    }
})
```

<div align="center"> <img src="image-20200609185506612.png" width="20%"/> </div><br>



## 1. data

```html
<body>
    <div id="app">
        <h1>{{person.first_name}}</h1>
        <h2>{{city[1]}}</h2>
    </div>
</body>
```

```javascript
var app = new Vue({
    el: "#app",
    data: {
        message: "Hello World!",
        person: {
            first_name: "Yi",
            last_name: "Cai"
        },
        city: ["Beijing", "Shanghai"]
    }
})
```

<div align="center"> <img src="image-20200609195323383.png" width="30%"/> </div><br>

## 2. v-text

```html
<body>
    <div id="app">
        <h1 v-text="message">Shanghai</h1>
        <h1>{{message}} Shanghai</h1>
    </div>
</body>
```

```javascript
var app = new Vue({
    el: "#app",
    data: {
        message: "Hello World!"
    }
})
```
<div align="center"> <img src="image-20200609195957329.png" width="30%"/> </div><br>

**:bulb:Hint**

与插值表达式的区别：`v-text` 不能插入，`{{}}` 可以



## 3. v-html

```html
<body>
    <div id="app">
        <p v-text="message"></p>
        <p v-html="message"></p>
        <p>{{message}}</p>
    </div>
</body>
```

```javascript
var app = new Vue({
    el: "#app",
    data: {
        message: "<h1>Hello World</h1>"
    }
})
```

<div align="center"> <img src="image-20200609200655326.png" width="30%"/> </div><br>

## 4. @click

`vue` 通过数据来改变 `dom` 属性

```html
<body>
    <div id="app">
        <h1>{{ num }}</h1>
        <button @click="plus_one">Click me</button>
    </div>
</body>
```

```javascript
var app = new Vue({
    el: "#app",
    data: {
        num: 1,
    },
    methods: {
        plus_one: function () {
            this.num++
        }
    }
})
```



## 5. Counter demo

实现一个简单的 `counter` ，其中下界是 0，上界是 10

```html
<body>
    <div id="app">
        <button @click="minus">minus</button>
        <input type="text" v-model="num">
        <button @click="plus">plus</button>
    </div>
</body>
```

注意，操作 `data` 要使用 `this` 

```javascript
var app = new Vue({
    el: "#app",
    data: {
        num: 2,
    },
    methods: {
        plus: function () {
            if (this.num < 10) {
                this.num++;
            } else {
                alert("Plus failed!");
            }
        },
        minus: function () {
            if (this.num > 0) {
                this.num--
            } else {
                alert("Minus failed")
            }
        }
    }
})
```
<div align="center"> <img src="image-20200609203733149.png" width="40%"/> </div><br>
















