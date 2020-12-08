# Core Interview Questions

Table of Content
-----------------

* [Q1. Is Data Passed by Reference or by Value in Java?](#q1-is-data-passed-by-reference-or-by-value-in-java)
* [Q2. What Is the Difference Between Import and Static Imports?](#q2-what-is-the-difference-between-import-and-static-imports)
* [Q3. Which Access Modifiers Are Available in Java and What Is Their Purpose?](#q3-which-access-modifiers-are-available-in-java-and-what-is-their-purpose)
* [Q4. What Is the Difference Between JDK, JRE, and JVM?](#q4-what-is-the-difference-between-jdk-jre-and-jvm)
* [Q5. What Is the Difference Between the <em>Comparable</em> and <em>Comparator</em> Interfaces?](#q5-what-is-the-difference-between-the-comparable-and-comparator-interfaces)
* [Q6. What Are the Methods of the Object Class and What Do They Do?](#q6-what-are-the-methods-of-the-object-class-and-what-do-they-do)
* [Q7. What Is an Enum and How We Can Use It?](#q7-what-is-an-enum-and-how-we-can-use-it)
* [Q8. What Is <strong>a</strong> JAR?](#q8-what-is-a-jar)
* [Q9. What Is <strong>a</strong> <em>NullPointerException</em>?](#q9-what-is-a-nullpointerexception)
* [Q10. What Are Two Types of Casting in Java? Which Exception May Be Thrown While Casting? How Can We Avoid It?](#q10-what-are-two-types-of-casting-in-java-which-exception-may-be-thrown-while-casting-how-can-we-avoid-it)
* [Q11. Why Is String an Immutable Class?](#q11-why-is-string-an-immutable-class)
* [Q12. What Is the Difference Between Dynamic Binding and Static Binding?](#q12-what-is-the-difference-between-dynamic-binding-and-static-binding)
* [Q13. What Is JIT?](#q13-what-is-jit)
* [Q14. What Is Reflection in Java?](#q14-what-is-reflection-in-java)
* [Q15. What Is the Difference Between Static and Dynamic Class Loading?](#q15-what-is-the-difference-between-static-and-dynamic-class-loading)
* [Q16. What Is the Purpose of the <em>Serializable</em> Interface?](#q16-what-is-the-purpose-of-the-serializable-interface)
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



### Q3. Which Access Modifiers Are Available in Java and What Is Their Purpose?

- private：只对当前类暴露

- default：对当前 `package` 暴露

- protected：在 `default` 的基础上，若子类不在当前 `package` 下也可以访问

- public：对所有开放

  



### Q4. What Is the Difference Between JDK, JRE, and JVM?

  <div align="center"> <img src="jdk-jre-jvm.png" width="50%"/> </div><br>






### Q5. What Is the Difference Between the *Comparable* and *Comparator* Interfaces?






### Q6. What Are the Methods of the Object Class and What Do They Do?





### Q7. What Is an Enum and How We Can Use It?







### Q8. What Is **a** JAR?









### Q9. What Is **a** *NullPointerException*?





### Q10. What Are Two Types of Casting in Java? Which Exception May Be Thrown While Casting? How Can We Avoid It?







### Q11. Why Is String an Immutable Class?











### Q12. What Is the Difference Between Dynamic Binding and Static Binding?





### Q13. What Is JIT?





### Q14. What Is Reflection in Java?







### Q15. What Is the Difference Between Static and Dynamic Class Loading?







### Q16. What Is the Purpose of the *Serializable* Interface?







## References

- [Java Interview Questions](https://www.baeldung.com/java-interview-questions)
- [Cannot find symbol assertEquals](https://stackoverflow.com/questions/20631621/cannot-find-symbol-assertequals)
