# 函数式接口

## 1. 什么是函数式接口？

有且仅有一个抽象方法的接口

## 2. Demo

定义一个函数式接口，即有且仅有一个抽象方法的接口

**MyInterface.java**

```java
@FunctionalInterface
public interface MyInterface {
    void show();
}
```

**TestDemo.java**

```java
@Slf4j
public class TestDemo {

    @Test
    public void test() {
        MyInterface myInterface = () -> {
            log.info("myInterface here!");
        };

        myInterface.show();

    }
  
}
```

## 3. Supplier 

> a person or organization that provides something needed such as a product or service

```java
package java.util.function;

/**
 * Represents a supplier of results.
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #get()}.
 *
 * @param <T> the type of results supplied by this supplier
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();
}
```

