package com.company.behavior.fly.impl;

import com.company.behavior.fly.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can fly!");
    }
}
