package com.ceezyyy;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut(value = "execution(* com.ceezyyy.Performance.perform(..))")
    public void perform() {
    }

    @Before("perform()")
    public void silenceCellPhones() {
        System.out.println("Silencing your cellphones");
    }

    @Before("perform()")
    public void takeSeat() {
        System.out.println("Take your seat");
    }

    @AfterReturning("perform()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterThrowing("perform()")
    public void demandRefund() {
        System.out.println("We need refund");
    }


}
