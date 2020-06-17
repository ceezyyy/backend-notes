# Interview Qs

## 目录







## 616

### 1. == 与 equals()

```java
public void testIntegerEquals() {
    Integer a = new Integer(1);
    Integer b = new Integer(1);
    Integer c = 1;
    Integer d = 1;
    System.out.println(a == b);  // false
    System.out.println(a == c);  // false
    System.out.println(a == d);  // false
    System.out.println(b == c);  // false
    System.out.println(b == d);  // false
    System.out.println(c == d);  // true
}
```

