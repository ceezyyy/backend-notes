package com.ceezyyy.implementsRunnable;

public class App {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("My thread here!");
        }).start();
        System.out.println("Main here!");
    }
}
