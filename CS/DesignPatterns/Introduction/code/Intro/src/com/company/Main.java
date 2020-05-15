package com.company;

import com.company.domain.Duck;
import com.company.domain.MallardDuck;

public class Main {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }
}
