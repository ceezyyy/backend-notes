package com.ceezyyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/test")
    public String test() {
        return "succeeded";
    }
}
