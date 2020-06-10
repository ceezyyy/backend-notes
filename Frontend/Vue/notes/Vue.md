# Vue Quickstart

## Category
* [0. Hello World!](#0-hello-world-)
* [1. Vue basic](#1-vue-basic)
  + [1.1 data](#11-data)
  + [1.2 v-text](#12-v-text)
  + [1.3 v-html](#13-v-html)
  + [1.4 @click](#14--click)
  + [1.5 Counter demo](#15-counter-demo)
  + [1.6 v-show](#16-v-show)
  + [1.7 v-if](#17-v-if)
  + [1.8 Slideshow demo](#18-slideshow-demo)
  + [1.9 v-for](#19-v-for)
  + [1.10 v-model](#110-v-model)
* [2. Vue cli](#2-vue-cli)
* [3. axios & Vue](#3-axios---vue)






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



## 1. Vue basic

### 1.1 data

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

### 1.2 v-text

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



### 1.3 v-html

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

### 1.4 @click

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



### 1.5 Counter demo

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





### 1.6 v-show

```html
<body>
    <div id="app">
        <button @click="changeToFalse">CHANGE</button>
        <h1 v-show="flag">Can u see me</h1>
    </div>
</body>
```

```javascript
var app = new Vue({
    el: "#app",
    data: {
        num: 2,
        flag: true,
    },
    methods: {
        changeToFalse: function () {
            this.flag = !this.flag
        }
    }
})
```


<div align="center"> <img src="image-20200609214149452.png" width="30%"/> </div><br>



### 1.7 v-if

与 `v-show` 类似

### 1.8 Slideshow demo

```html
<body>
    <div id="app">
        <img :src="images[index]"><br>
        <button @click="left" v-show="index > 0">LEFT</button>
        <button @click="right" v-show="index < images.length - 1">RIGHT</button>
    </div>
</body>
```

```javascript
var app = new Vue({
    el: "#app",
    data: {
        index: 1,
        images: [
            "./img/1.jpg",
            "./img/2.jpg",
            "./img/3.jpg"
        ],
    },
    methods: {
        left: function () {
            this.index--;
        },
        right: function () {
            this.index++;
        }
    }
})
```



<div align="center"> <img src="image-20200609223716790.png" width="50%"/> </div><br>

<div align="center"> <img src="image-20200609223725512.png" width="50%"/> </div><br>

<div align="center"> <img src="image-20200609223734850.png" width="50%"/> </div><br>

在 `v-show` 里面写 `js` 逻辑十分便捷！

### 1.9 v-for

```html
<body>
    <div id="app">
        <ul>
            <li v-for="car in cars">{{car}}</li>
        </ul>
    </div>
</body>
```

```javascript
var app = new Vue({
    el: "#app",
    data: {
        nums: [1, 2, 3, 4],
        cars: [
            "Bentley",
            "Lamborghini",
            "Benz",
            "BMW",
        ]
    },
    methods: {
    }
})
```

<div align="center"> <img src="image-20200609230242967.png" width="40%"/> </div><br>

### 1.10 v-model

```html
<body>
    <div id="app">
      <input type="text" v-model="message">
      <h2>{{message}}</h2>
    </div>
</body>
```

```javascript
var app = new Vue({
    el: "#app",
    data: {
        message: "Hello"
    },
    methods: {
    }
})
```

<div align="center"> <img src="image-20200609230625074.png" width="30%"/> </div><br>



## 2. Vue cli





## 3. axios & Vue





