package com.ceezyyy.controller;

import com.ceezyyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class HelloController {

    private UserService userService;

    @RequestMapping("/test")
    public String test() {
        return "succeeded";
    }
}
