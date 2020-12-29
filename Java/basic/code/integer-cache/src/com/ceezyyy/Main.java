package com.ceezyyy;

public class Main {

    public static void main(String[] args) {
        // Autoboxing: Integer.valueOf(int)
        Integer x = 1;
        // Unboxing: x.intValue()
        int y = x;
        // x 会拆箱 实际上是两个 int 在比较
        System.out.println(x == y);  // true
    }
}
