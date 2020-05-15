package com.company.pizza;

public abstract class Pizza {
    private String name;
    private String dough;
    private String sauce;

    public void prepare() {
        System.out.println("I'm preparing" + name);
        System.out.println("Tossing dough");
        System.out.println("Adding sauce");
    }

    public void bake() {
        System.out.println("I'm baking");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
