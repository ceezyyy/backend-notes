package com.ceezyyy.runnableImpl;

public class Tickets implements Runnable {

    // movie tickets
    private int ticket = 100;
    private Object key = new Object();

    // sell tickets
    @Override
    public void run() {
        while (true) {
            // key object
            synchronized (key) {
                if (ticket > 0) {
                    // sleep
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // print info
                    System.out.println(Thread.currentThread().getName() + " is selling " + ticket);
                    // sold
                    ticket--;
                }
            }
        }
    }
}
