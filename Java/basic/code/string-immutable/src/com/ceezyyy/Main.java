package com.ceezyyy;

public class Main {

    public static void main(String[] args) {

        String a = "abc";
        String b = new String("abc");
        String c = new String("efg");

        // intern() creates an exact copy of a String object in the heap memory
        // and stores it in the String constant pool
        String d = a.intern();
        String e = b.intern();

        System.out.println(a == d);  // true
        System.out.println(a == e);  // true
        System.out.println(d == e);  // true

    }
}
