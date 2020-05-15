package com.company.domain;

import com.company.behavior.fly.impl.FlyWithWings;
import com.company.behavior.quack.impl.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real mallarduck!");
    }
}
