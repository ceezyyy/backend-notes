# ArrayList 

Table of Contents
-----------------

* [1. 概述](#1-概述)
* [2. 继承关系](#2-继承关系)
   * [2.1 Serializable](#21-serializable)
   * [2.2 Cloneable](#22-cloneable)
   * [2.3 RandomAccess](#23-randomaccess)
   * [2.4 AbstractList](#24-abstractlist)
* [3. 源码分析](#3-源码分析)
* [4. 面试题](#4-面试题)
* [5. 自定义 ArrayList](#5-自定义-arraylist)
* [参考链接](#参考链接)


## 1. 概述

优点：

- 查询快，根据地址和索引直接获取元素

缺点：

- 数组增删慢，需要创建新的数组，且移动元素位置



## 2. 继承关系

```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
```

### 2.1 Serializable

**实现该接口作用：**使得对象可以序列化

```java
public interface Serializable {
}
```


序列化：将对象的数据写入到文件中

反序列化：将对象数据从文件中读取出来



### 2.2 Cloneable

**实现该接口作用：**使得对象可以序列化根据已有的数据，创造一份新的拷贝

```java
/**
 * A class implements the <code>Cloneable</code> interface to
 * indicate to the {@link java.lang.Object#clone()} method that it
 * is legal for that method to make a
 * field-for-field copy of instances of that class.
 * <p>
 * Invoking Object's clone method on an instance that does not implement the
 * <code>Cloneable</code> interface results in the exception
 * <code>CloneNotSupportedException</code> being thrown.
 * <p>
 * By convention, classes that implement this interface should override
 * <tt>Object.clone</tt> (which is protected) with a public method.
 * See {@link java.lang.Object#clone()} for details on overriding this
 * method.
 * <p>
 * Note that this interface does <i>not</i> contain the <tt>clone</tt> method.
 * Therefore, it is not possible to clone an object merely by virtue of the
 * fact that it implements this interface.  Even if the clone method is invoked
 * reflectively, there is no guarantee that it will succeed.
 *
 * @author  unascribed
 * @see     java.lang.CloneNotSupportedException
 * @see     java.lang.Object#clone()
 * @since   JDK1.0
 */
public interface Cloneable {
}
```





**Java 中的深浅拷贝**







### 2.3 RandomAccess

**实现该接口作用**：支持高效随机访问（通过索引获取元素的值）

```java
/**
 * Marker interface used by <tt>List</tt> implementations to indicate that
 * they support fast (generally constant time) random access.  The primary
 * purpose of this interface is to allow generic algorithms to alter their
 * behavior to provide good performance when applied to either random or
 * sequential access lists.
 *
 * <p>The best algorithms for manipulating random access lists (such as
 * <tt>ArrayList</tt>) can produce quadratic behavior when applied to
 * sequential access lists (such as <tt>LinkedList</tt>).  Generic list
 * algorithms are encouraged to check whether the given list is an
 * <tt>instanceof</tt> this interface before applying an algorithm that would
 * provide poor performance if it were applied to a sequential access list,
 * and to alter their behavior if necessary to guarantee acceptable
 * performance.
 *
 * <p>It is recognized that the distinction between random and sequential
 * access is often fuzzy.  For example, some <tt>List</tt> implementations
 * provide asymptotically linear access times if they get huge, but constant
 * access times in practice.  Such a <tt>List</tt> implementation
 * should generally implement this interface.  As a rule of thumb, a
 * <tt>List</tt> implementation should implement this interface if,
 * for typical instances of the class, this loop:
 * <pre>
 *     for (int i=0, n=list.size(); i &lt; n; i++)
 *         list.get(i);
 * </pre>
 * runs faster than this loop:
 * <pre>
 *     for (Iterator i=list.iterator(); i.hasNext(); )
 *         i.next();
 * </pre>
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @since 1.4
 */
public interface RandomAccess {
}
```



### 2.4 AbstractList








## 3. 源码分析





## 4. 面试题





## 5. 自定义 ArrayList







## 参考链接

- [java进阶教程丨全面深入解析ArrayList原理（源码分析+面试讲解）](https://www.bilibili.com/video/BV1gE411A7H8?p=2)

