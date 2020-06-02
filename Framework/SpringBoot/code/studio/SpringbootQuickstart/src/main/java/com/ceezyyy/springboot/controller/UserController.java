package com.ceezyyy.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/test")
    public String test() {
        return "I'm UserController";
    }

}
