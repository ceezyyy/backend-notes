package com.ceezyyy.utils;

public class Logger {
    public void before() {
        System.out.println("Before logging...");
    }

    public void afterReturning() {
        System.out.println("After returning logging...");
    }

    public void afterThrowing() {
        System.out.println("After throwing logging...");
    }

    public void after() {
        System.out.println("After logging...");
    }
}
