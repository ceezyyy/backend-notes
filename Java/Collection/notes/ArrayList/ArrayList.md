# ArrayList 源码分析

## 目录

* [1. ArrayList 初探](#1-arraylist---)
  + [1.1 Serializable](#11-serializable)
  + [1.2 Cloneable](#12-cloneable)









## 1. ArrayList 初探

```java
public class ArrayList<E> extends AbstractList<E>
    implements List<E>, RandomAccess, Cloneable, java.io.Serializable
```

### 1.1 Serializable

```java
public interface Serializable {
}
```

序列化：将对象的数据写入到文件（写对象）

反序列化：将文件中对象的数据读取出来（读数据）



### 1.2 Cloneable

```java
public interface Cloneable {
}
```






