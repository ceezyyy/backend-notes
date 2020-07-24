package com.ceezyyy.extention;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("mythread " + i);
        }
    }
}
