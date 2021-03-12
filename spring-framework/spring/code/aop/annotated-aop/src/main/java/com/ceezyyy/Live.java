package com.ceezyyy;


import org.springframework.stereotype.Component;

@Component
public class Live implements Performance {
    public void perform() {
        System.out.println("Playing live");
//        int a = 100 / 0;
    }
}
