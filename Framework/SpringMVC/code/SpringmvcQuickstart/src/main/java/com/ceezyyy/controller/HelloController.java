package com.ceezyyy.controller;

import com.ceezyyy.entity.Account;
import com.ceezyyy.entity.Company;
import com.ceezyyy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("HelloController")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public void hello(Company company) {
        System.out.println(company);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test(@RequestParam(name = "username") String name, String password) {
        System.out.println(name);
        System.out.println(password);
    }

}
