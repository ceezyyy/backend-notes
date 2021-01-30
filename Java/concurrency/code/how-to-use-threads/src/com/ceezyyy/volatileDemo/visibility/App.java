package com.ceezyyy.volatileDemo.visibility;

public class App {

    public static void main(String[] args) {

        MyObj obj = new MyObj();

        new Thread(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " started");
            obj.increase();
            System.out.println("x has been updated");

        }, "t1").start();

        // main thread
        while (obj.getX() == 0) {
            // do nothing
        }

        System.out.println(Thread.currentThread().getName() + " exited");

    }

}
