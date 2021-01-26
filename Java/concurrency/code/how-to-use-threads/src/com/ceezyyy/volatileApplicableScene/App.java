package com.ceezyyy.volatileApplicableScene;

/**
 * volatile 适用场景
 */
public class App {

    volatile boolean shutdownRequested;

    public void shutdown() {
        shutdownRequested = true;
    }

    public void doWork() {
        while (!shutdownRequested) {
            // do your work here
        }
    }

}
