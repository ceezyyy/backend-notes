package com.ceezyyy.runnable;

public class RunnableImpl implements Runnable {

    // print threads name
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
