package com.ceezyyy;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        /*
         * To create an empty Optional object, we simply need to use its empty() static method
         *
         * */
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent());  // false


        /*
         * However, the argument passed to the of() method can't be null.
         * Otherwise, we'll get a NullPointerException:
         *
         * */
        Optional<String> hello = Optional.of("hello");
        System.out.println(hello.isPresent());  // true


        /*
         * But, in case we expect some null values, we can use the ofNullable() method
         *
         * */
        Optional<Object> opt = Optional.ofNullable(null);
        System.out.println(opt.isPresent());  // false
        opt = Optional.ofNullable("world");
        System.out.println(opt.isPresent());  // true



        



    }
}
