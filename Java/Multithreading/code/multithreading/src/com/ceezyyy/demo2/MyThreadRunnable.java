package com.ceezyyy.demo2;

public class MyThreadRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread (implements runnable) here!" + i);
        }
    }
}
