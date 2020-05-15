package com.company.behavior.quack.impl;

import com.company.behavior.quack.QuackBehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I can squeak!");
    }
}
