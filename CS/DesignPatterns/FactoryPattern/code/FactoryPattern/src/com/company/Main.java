package com.company;

import com.company.pizza.Pizza;

public class Main {

    public static void main(String[] args) {

    }

    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        // might change
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("greek".equals(type)) {
            pizza = new GreekPizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        } else {
            // do nothing
        }

        // will not change
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
