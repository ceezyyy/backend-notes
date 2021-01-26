package com.ceezyyy.volatileDemo;

/**
 * Java 下的运算符操作并非原子操作 -> volatile 变量的运算
 * 在并发下不安全
 */
public class App {

    public static volatile int race = 0;
    private static final int THREAD_COUNTS = 20;

    public static void increase() {
        race++;
    }

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREAD_COUNTS];

        for (int i = 0; i < THREAD_COUNTS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }

        // The number of active threads in the current thread's thread group and its subgroups
        // 一条是 main 线程, 另一条是 IDEA 自动创建的线程
        while (Thread.activeCount() > 2) {
            // The current thread is willing to yield its current use of a processor
            Thread.yield();
        }

        // 结果小于 20000
        System.out.println(race);

    }

}
