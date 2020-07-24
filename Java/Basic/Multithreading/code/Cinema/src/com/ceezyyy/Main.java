package com.ceezyyy;

import com.ceezyyy.extention.MyThread;
import com.ceezyyy.runnable.RunnableImpl;
import com.ceezyyy.runnable.Tickets;


public class Main {

    public static void main(String[] args) {
        Runnable tickets = new Tickets();
        // create threads
        for (int i = 0; i < 5; i++) {
            new Thread(tickets).start();
        }
    }
}
