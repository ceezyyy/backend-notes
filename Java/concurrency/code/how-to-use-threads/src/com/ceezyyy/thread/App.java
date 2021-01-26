package com.ceezyyy.thread;

public class App {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Mythread here!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Main here!");
        new MyThread().start();
    }
}
