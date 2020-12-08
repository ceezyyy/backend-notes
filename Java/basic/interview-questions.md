# Java Interview Questions

Table of Contents
-----------------

 * [Q1. Is Data Passed by Reference or by Value in Java?](#q1-is-data-passed-by-reference-or-by-value-in-java)
* [References](#references)


### Q1. Is Data Passed by Reference or by Value in Java?

首先理清楚两个概念：

- 值传递：传递该 `object` 的一份拷贝
- 引用传递：传递该 `object` 的引用



在 `Java` 中，

1. 对于原始数据类型：

- byte
- short
- int
- long
- float
- double
- char
- boolean

存放的是其确切的值

2. 对于非原始数据类型（对象，包装类等）存放的是其引用值（address）



**两者都存放于栈内存中**



举个例子：

**App.java**

```java
public class App {

    @Test
    public void testPrimitives() {

        int x = 1;
        int y = 2;

        assertEquals(x, 1);
        assertEquals(y, 2);

        modify(x, y);

        // Test passed
        assertEquals(x, 1);
        assertEquals(y, 2);

    }

    public void modify(int x, int y) {
        x = 5;
        y = 10;
    }

}
```



对于 `testPrimitives`：



  <div align="center"> <img src="pass-by-value-primitives.jpg" width="70%"/> </div><br>

## References

- [Java Interview Questions](https://www.baeldung.com/java-interview-questions)
- [Cannot find symbol assertEquals](https://stackoverflow.com/questions/20631621/cannot-find-symbol-assertequals)
