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

        assertEquals(1, x);
        assertEquals(2, y);

        modifyPrimitives(x, y);

        // Test passed
        assertEquals(1, x);
        assertEquals(2, y);

    }

    public void modifyPrimitives(int x, int y) {
        x = 5;
        y = 10;
    }

    @Test
    public void testNonPrimitives() {

        Person a = new Person(1);
        Person b = new Person(2);

        assertEquals(1, a.age);
        assertEquals(2, b.age);

        modifyNonPrimitives(a, b);

        // Test passed
        assertEquals(2, a.age);
        assertEquals(2, b.age);

    }

    public void modifyNonPrimitives(Person a, Person b) {

        a.age++;

        Person newPerson = new Person(23);
        newPerson.age++;

    }

    public class Person {

        int age;

        public Person(int age) {
            this.age = age;
        }

    }

}
```





### Q2. What Is the Difference Between Import and Static Imports?



```java
import java.util.ArrayList; //specific class
import java.util.*; //all classes in util package

import static java.util.Collections.EMPTY_LIST;
```



**区别：** 调用方法 / 变量的时候可以直接写，而不用以  `className.function()` 的形式调用







## References

- [Java Interview Questions](https://www.baeldung.com/java-interview-questions)
- [Cannot find symbol assertEquals](https://stackoverflow.com/questions/20631621/cannot-find-symbol-assertequals)
