package com.ceezyyy.test;

import com.ceezyyy.runnableImpl.RunnableImpl;
import com.ceezyyy.runnableImpl.Tickets;
import org.junit.Test;

public class TestMethod {

//    @Test
//    public void test1() {
//        // start threads
//        new MyThread().start();
//        new MyThread().start();
//        new MyThread().start();
//        new MyThread().start();
//        new MyThread().start();
//        new MyThread().start();
//        new MyThread().start();
//
//        System.out.println(Thread.currentThread().getName());
//    }

    @Test
    public void test2() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() {
        Runnable runnableImpl = new RunnableImpl();
        // create thread
        new Thread(runnableImpl).start();
        new Thread(runnableImpl).start();
        new Thread(runnableImpl).start();
        new Thread(runnableImpl).start();
        new Thread(runnableImpl).start();

        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test4() {
        Tickets tickets = new Tickets();
        // create threads
        Thread t0 = new Thread(tickets);
        Thread t1 = new Thread(tickets);

        t0.start();
        t1.start();
    }

}
