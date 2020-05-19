package com.ceezyyy;

public class ProducerImpl implements Producer {

    public void sell(double money) {
        System.out.println("Things sold, get " + money + " usd");
    }

    public void afterSalesService() {
        System.out.println("Provide after-sales service");
    }
}
