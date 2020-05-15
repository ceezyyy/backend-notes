package com.company.pizzaStore;

import com.company.pizza.Pizza;

public abstract class PizzaStore {

    // factory method
    protected abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza;

        // create a pizza
        pizza = createPizza(type);

        // process of making a pizza
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
