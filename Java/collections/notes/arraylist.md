# ArrayList 

Table of Contents
-----------------









## 1. 全览

<div align="center"> <img src="ArrayList_base.png" width="70%"/> </div><br>

优点：

- 查询快，根据地址和索引直接获取元素

缺点：

- 数组增删慢，需要创建新的数组，且移动元素位置



```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
  
}
```

<div align="center"> <img src="image-20200901120242133.png" width="70%"/> </div><br>



- RandomAccess：支持 `O(1)` 级别的随机访问 / 顺序访问
- Cloneanle：支持克隆（需重写 `clone` 方法）
- Serializable：可支持序列化



```java
private static final long serialVersionUID = 8683452581122892189L;

/**
 * Default initial capacity.
 */
private static final int DEFAULT_CAPACITY = 10;

/**
 * Shared empty array instance used for empty instances.
 */
private static final Object[] EMPTY_ELEMENTDATA = {};

/**
 * Shared empty array instance used for default sized empty instances. We
 * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
 * first element is added.
 */
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

/**
 * The array buffer into which the elements of the ArrayList are stored.
 * The capacity of the ArrayList is the length of this array buffer. Any
 * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
 * will be expanded to DEFAULT_CAPACITY when the first element is added.
 */
transient Object[] elementData; // non-private to simplify nested class access

/**
 * The size of the ArrayList (the number of elements it contains).
 *
 * @serial
 */
private int size;
```

## 2. Constructor

**默认空参**

```java
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
```

**有参构造 1**

```java
// Constructs an empty list with the specified initial capacity
public ArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    }
}
```

传入 `initialCapacity` 参数：

- 若参数 > 0：创建容量为 `initialCapacity` 的列表（根据入参）
- 若参数为 0：创建 `EMPTY_ELEMENTDATA` 空列表
- 若参数 < 0：抛异常 



**有参构造 2**

```java
// Constructs a list containing the elements of the specified collection
public ArrayList(Collection<? extends E> c) {
    elementData = c.toArray();
    if ((size = elementData.length) != 0) {
        // c.toArray might (incorrectly) not return Object[] (see 6260652)
        if (elementData.getClass() != Object[].class)
            elementData = Arrays.copyOf(elementData, size, Object[].class);
    } else {
        // replace with empty array.
        this.elementData = EMPTY_ELEMENTDATA;
    }
}
```



## 3. set()

`set()` 方法逻辑比较简单，先检查 `index` 是否合法，若合法只需要在 `index` 位置替换掉原先的元素即可 

```java
// Setter
public E set(int index, E element) {
  rangeCheck(index);

  E oldValue = elementData(index);
  elementData[index] = element;
  return oldValue;
}

// Check if the given index is in range
private void rangeCheck(int index) {
  if (index >= size)
    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}

// Get element by specific index
E elementData(int index) {
  return (E) elementData[index];
}
```



## 4. get()

`get()` 方法和 `set()` 逻辑相似

```java
// Returns the element at the specified position in this list
public E get(int index) {
  rangeCheck(index);

  return elementData(index);
}

// Check if the given index is in range
private void rangeCheck(int index) {
  if (index >= size)
    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}

// Get element by specific index
E elementData(int index) {
  return (E) elementData[index];
}
```



## 参考链接

- [Java Collections Framework Internals - ArrayList](https://github.com/CarpenterLee/JCFInternals/blob/master/markdown/2-ArrayList.md)