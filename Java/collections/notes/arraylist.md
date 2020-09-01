# ArrayList 

Table of Contents
-----------------




## 1. 特点

优点：

- 查询快，根据地址和索引直接获取元素

缺点：

- 数组增删慢，需要创建新的数组，且移动元素位置



## 2. 全览

```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
  
}
```

<div align="center"> <img src="image-20200901120242133.png" width="70%"/> </div><br>



- RandomAccess：支持 `O(1)` 级别的随机访问 / 顺序访问
- Cloneanle：支持克隆（需重写 `clone` 方法）
- Serializable：可支持序列化


## 3. 源码分析

### 3.1 properties

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

### 3.2 Constructor

**默认空参**

```java
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
```

**有参构造 1**

```java
/**
 * Constructs an empty list with the specified initial capacity.
 *
 * @param  initialCapacity  the initial capacity of the list
 * @throws IllegalArgumentException if the specified initial capacity
 *         is negative
 */
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
/**
 * Constructs a list containing the elements of the specified
 * collection, in the order they are returned by the collection's
 * iterator.
 *
 * @param c the collection whose elements are to be placed into this list
 * @throws NullPointerException if the specified collection is null
 */
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



### 3.3 add

**App.java**

```java
public class App {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        
    }
}
```

进入到 `add()` 方法

**Arraylist.java**

```java
public boolean add(E e) {
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}
```

首先确保内部容量是否足够（用 `size + 1` 作判断，看看是否能再加一个元素进来）：

- 若是调用空参构造方法：`minCapacity` 取入参容量和默认容量 10 中的最大值
- 调用 `ensureExplicitCapacity` 方法，明确实际容量大小

```java
private void ensureCapacityInternal(int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
    }

    ensureExplicitCapacity(minCapacity);
}
```

明确实际容量的大小，判断是否需要扩容

其中 `modCount` 是 `ArrayList` 的父类 `AbstractList` 的成员变量，记录 `ArrayList` 扩容的次数（至于有什么用暂且不研究）

`elementData.length` 是返回 `ArrayList` 当前实际的大小，若 `minCapacity` 大于当前大小，则调用 `grow` 方法进行扩容

**ArrayList.java**

```java
private void ensureExplicitCapacity(int minCapacity) {
    modCount++;

    // overflow-conscious code
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}
```

扩容方法，新的容量是原来的 1.5 倍

若新的容量扩容后仍然比 `minCapacity` 小，则直接将 `minCapacity` 赋予给新的容量

最后调用 `Arrays.copyOf` 方法复制一份数组

**ArrayList.java**

```java
/**
 * Increases the capacity to ensure that it can hold at least the
 * number of elements specified by the minimum capacity argument.
 *
 * @param minCapacity the desired minimum capacity
 */
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```

**Arrays.java**

```java
public static <T> T[] copyOf(T[] original, int newLength) {
    return (T[]) copyOf(original, newLength, original.getClass());
}
```

**Arrays.java**

```java
public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
    @SuppressWarnings("unchecked")
    T[] copy = ((Object)newType == (Object)Object[].class)
        ? (T[]) new Object[newLength]
        : (T[]) Array.newInstance(newType.getComponentType(), newLength);
    System.arraycopy(original, 0, copy, 0,
                     Math.min(original.length, newLength));
    return copy;
}
```

**ArrayList.java**

```java
public boolean add(E e) {
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}
```

最终回到了 `add` 方法

将元素 `e` 增加到 `elementData` 的最后

注意：`size` 是 `ArrayList` 所包含的实际元素数量！与容量的概念不一样！



除此之外，还有另外一个指定元素 `index` 的添加元素方法

**App.java**

```java
public class App {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1, 88);

    }
}
```

**ArrayList.java**

```java
/**
 * Inserts the specified element at the specified position in this
 * list. Shifts the element currently at that position (if any) and
 * any subsequent elements to the right (adds one to their indices).
 *
 * @param index index at which the specified element is to be inserted
 * @param element element to be inserted
 * @throws IndexOutOfBoundsException {@inheritDoc}
 */
public void add(int index, E element) {
    rangeCheckForAdd(index);

    ensureCapacityInternal(size + 1);  // Increments modCount!!
    System.arraycopy(elementData, index, elementData, index + 1,
                     size - index);
    elementData[index] = element;
    size++;
}
```

**ArrayList.java**

```java
/**
 * A version of rangeCheck used by add and addAll.
 */
private void rangeCheckForAdd(int index) {
    if (index > size || index < 0)
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}
```







## 4. Interview Qs





## 5. 自定义 ArrayList







## 参考链接

- [java进阶教程丨全面深入解析ArrayList原理（源码分析+面试讲解）](https://www.bilibili.com/video/BV1gE411A7H8?p=2)

