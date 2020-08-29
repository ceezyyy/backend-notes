package com.ceezyyy.springbootswagger.controller;


import com.ceezyyy.springbootswagger.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/user")
    public User getUser() {
        return new User("ceezyyy", "123456");
    }
}
