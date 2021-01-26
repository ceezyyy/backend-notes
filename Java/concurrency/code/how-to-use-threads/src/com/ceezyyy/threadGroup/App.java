package com.ceezyyy.threadGroup;

public class App {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("The ThreadGroup of t1: "
                    + Thread.currentThread().getThreadGroup().getName());
        }, "t1").start();  // The ThreadGroup of t1: main

        System.out.println("The ThreadGroup of main: "
                + Thread.currentThread().getThreadGroup().getName());  // The ThreadGroup of main: main

    }

}
