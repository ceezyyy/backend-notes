# Optional

Table of Contents
-----------------

* [Table of Contents](#table-of-contents)
* [1. 什么是 Optional?](#1-什么是-optional)
* [2. 为什么要使用 Optional?](#2-为什么要使用-optional)
* [3. Quickstart](#3-quickstart)
   * [3.1 Creating Optional Objects](#31-creating-optional-objects)
   * [3.2 Checking Value Presence: isPresent() and isEmpty()](#32-checking-value-presence-ispresent-and-isempty)
   * [3.3 Conditional Action With ifPresent()](#33-conditional-action-with-ifpresent)
   * [3.4 Default Value With orElse()](#34-default-value-with-orelse)
   * [3.5 Default Value With orElseGet()](#35-default-value-with-orelseget)
   * [3.6 Difference Between orElse and orElseGet()](#36-difference-between-orelse-and-orelseget)
* [4. Conclusion](#4-conclusion)
* [5. References](#5-references)



## 1. 什么是 Optional?

`Optional` 是个容器，可以保存类型 `T` 的值，或者仅仅保存 `null`







## 2. 为什么要使用 Optional?

- 不用显式地进行空值检测
- 很好地解决空指针异常







## 3. Quickstart

### 3.1 Creating Optional Objects

```java
/*
 * To create an empty Optional object, we simply need to use its empty() static method
 *
 * */
Optional<Object> empty = Optional.empty();
System.out.println(empty.isPresent());  // false


/*
 * However, the argument passed to the of() method can't be null.
 * Otherwise, we'll get a NullPointerException:
 *
 * */
Optional<String> hello = Optional.of("hello");
System.out.println(hello.isPresent());  // true


/*
 * But, in case we expect some null values, we can use the ofNullable() method
 *
 * */
Optional<Object> opt = Optional.ofNullable(null);
System.out.println(opt.isPresent());  // false
opt = Optional.ofNullable("world");
System.out.println(opt.isPresent());  // true
```



### 3.2 Checking Value Presence: isPresent() and isEmpty()

```java
/*
 * Optional makes us deal with nullable values explicitly as a way of enforcing good programming practices
 *
 * */
Optional<String> world = Optional.of("world");
world.ifPresent(name -> System.out.println(name));
```













### 3.3 Conditional Action With ifPresent()





















### 3.4 Default Value With orElse()





















### 3.5 Default Value With orElseGet()

























### 3.6 Difference Between orElse and orElseGet()

























## 4. Conclusion

- 看源码 看源码 看源码













## 5. References

- [Java Optionals | Crash Course](https://www.youtube.com/watch?v=1xCxoOuDZuU&t=459s)
- [Guide To Java 8 Optional - baeldung](https://www.baeldung.com/java-optional)

