package com.ceezyyy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = "com.ceezyyy")
@EnableAspectJAutoProxy
public class AopConfig {
}
