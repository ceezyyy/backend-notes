# Stack & Queue

## 前言

```java
public class Stack<E>
  extends Vector<E>
```

The `Stack` class represents a last-in-first-out (LIFO) stack of objects. It extends class `Vector` with five operations that allow a vector to be treated as a stack. The usual `push` and `pop` operations are provided, as well as a method to `peek` at the top item on the stack, a method to test for whether the stack is `empty`, and a method to `search` the stack for an item and discover how far it is from the top.

When a stack is first created, it contains no items.

A more complete and consistent set of LIFO stack operations is provided by the [`Deque`](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html) interface and its implementations, which should be used in preference to this class. For example:

```java
Deque<Integer> stack = new ArrayDeque<Integer>();
```

`Java` 官方推荐使用 `ArrayDequeue` 来实现栈和队列，本文重点介绍 `ArrayDeque` 的实现和原理



## Overview











## Constructor

















