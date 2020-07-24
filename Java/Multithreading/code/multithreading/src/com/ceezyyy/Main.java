package com.ceezyyy;


import com.ceezyyy.demo2.MyThreadRunnable;

public class Main {

    public static void main(String[] args) {

        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();

        // start new thread
        new Thread(myThreadRunnable).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread here! " + i);
        }

    }
}
