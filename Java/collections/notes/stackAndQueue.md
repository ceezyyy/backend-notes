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

```java
public class ArrayDeque<E> extends AbstractCollection<E>
                           implements Deque<E>, Cloneable, Serializable
{
```



<div align="center"> <img src="image-20200904151827074.png" width="70%"/> </div><br>

要想透彻了解 `ArrayDeque`，首先需要了解 `Deque`：双端队列

<div align="center"> <img src="image-20200904151827074.png" width="70%"/> </div><br>



`ArrayDeque` （用来表示 `Stack` / `Queue`）以及 `LinkedList` 都实现了这个接口

<div align="center"> <img src="image-20200904163301147.png" width="70%"/> </div><br>

**Queue.java**

```java
// Deque is short for "double ended queue"
// which supports element insertion and removal at both ends
public interface Deque<E> extends Queue<E> {


  // Inserts the specified element at the front of this deque
  // Otherwise, throw an IllegalStateException
  void addFirst(E e);


  // Inserts the specified element at the end of this deque
  // Otherwise, throw an IllegalStateException
  void addLast(E e);


  // Inserts the specified element at the front of this deque 
  // unless it would violate capacity restrictions
  // 推荐使用
  boolean offerFirst(E e);


  // Inserts the specified element at the end of this deque 
  // unless it would violate capacity restrictions
  // 推荐使用
  boolean offerLast(E e);

  // Retrieves and removes the first element of this deque
  // it throws an exception if this deque is empty
  E removeFirst();


  // Retrieves and removes the last element of this deque
  // it throws an exception if this deque is empty
  E removeLast();


  // Retrieves and removes the first element of this deque
  // returns {@code null} if this deque is empty
  E pollFirst();


  // Retrieves and removes the last element of this deque
  // returns {@code null} if this deque is empty
  E pollLast();


  // Retrieves, but does not remove, the first element of this deque
  // it throws an exception if this deque is empty
  E getFirst();


  // Retrieves, but does not remove, the last element of this deque
  // it throws an exception if this deque is empty
  E getLast();


  // Retrieves, but does not remove, the first element of this deque
  // or returns {@code null} if this deque is empty
  E peekFirst();

  // Retrieves, but does not remove, the last element of this deque
  // or returns {@code null} if this deque is empty
  E peekLast();


  // Removes the first occurrence of the specified element from this deque
  // If the deque does not contain the element, it is unchanged
  boolean removeFirstOccurrence(Object o);


  // Removes the last occurrence of the specified element from this deque
  // If the deque does not contain the element, it is unchanged
  boolean removeLastOccurrence(Object o);


  // *** Queue methods ***


  // Inserts the specified element into the queue(at the tail of this deque) represented by this deque
  // 插入成功返回 true
  // 否则抛出异常
  boolean add(E e);


  // Inserts the specified element into the queue(at the tail of this deque) represented by this deque
  // 插入成功返回 true
  // 否则返回 false
  boolean offer(E e);


  // Retrieves and removes the head of the queue represented by this deque
  // it throws an exception if this deque is empty
  E remove();


  // Retrieves and removes the head of the queue represented by this deque
  // 若 deque 为空，返回 null
  E poll();


  // Retrieves, but does not remove, the head of the queue represented by this deque
  // 若 deque 为空，抛出异常
  E element();


  // Retrieves, but does not remove, the head of the queue represented by this queue
  // 若 deque 为空，返回 null
  E peek();


  // *** Stack methods ***



  // Pushes an element onto the stack represented by this deque
  // 若没有空间，抛出异常
  void push(E e);



  // Pops an element from the stack represented by this deque
  // 若 deque 为空，抛出异常
  E pop();


  // Removes the first occurrence of the specified element from this deque
  // 成功移除返回 true，否则抛出异常
  boolean remove(Object o);


  // Returns {@code true} if this deque contains the specified element
  boolean contains(Object o);


  // Returns the number of elements in this deque
  public int size();


  Iterator<E> iterator();


  Iterator<E> descendingIterator();

}
```















## Constructor

















