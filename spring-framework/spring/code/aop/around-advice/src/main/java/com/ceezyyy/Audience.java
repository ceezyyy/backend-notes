package com.ceezyyy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut(value = "execution(* com.ceezyyy.Performance.perform(..))")
    public void perform() {
    }

    @Around("perform()")
    public void enjoyPerformance(ProceedingJoinPoint joinPoint) {
        System.out.println("Silencing cellphones");
        System.out.println("Take your seat");
        try {
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP");
        } catch (Throwable throwable) {
            System.out.println("Demanding refund");
        }
    }

}
