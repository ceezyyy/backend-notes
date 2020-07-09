package com.ceezyyy.swaggerdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
