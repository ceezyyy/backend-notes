package com.ceezyyy.runnable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tickets implements Runnable {
    private int tickets = 100;
    Lock lock = new ReentrantLock();

    // sell tickets
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tickets > 0) {
                    Thread.sleep(10);
                    // print info
                    System.out.println(Thread.currentThread().getName() + " is selling " + tickets);
                    // sold
                    tickets--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
