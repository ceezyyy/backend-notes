package com.ceezyyy.volatileDemo.visibility;

public class MyObj {

    private volatile int x = 0;

    public void increase() {
        x = 100;
    }

    public int getX() {
        return x;
    }
}
