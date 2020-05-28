package com.ceezyyy.controller;

import com.ceezyyy.entity.Account;
import com.ceezyyy.entity.Company;
import com.ceezyyy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("HelloController")
@RequestMapping("/user")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public void hello(Company company) {
        System.out.println(company);
    }

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public void test(@RequestBody User user) {
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getCity());
    }

    @RequestMapping(value = "/test/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public void testVariable(@PathVariable(name = "id") String id) {
        System.out.println(id);
    }

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("test string");
        // simulate a model
        User user = new User("LBJ", 35, "Cleveland");
        model.addAttribute("user", user);
        return "Succeeded";
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        Map<String, String> map = new HashMap<>();
        model.addAttribute("hello", "world");
        map.put("spring", "mvc");
        model.mergeAttributes(map);
        return "Succeeded";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("watermelon");
        modelMap.addAttribute("fruits", fruits);
        return "Succeeded";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView("Succeeded");
        modelAndView.addObject("hello", "Model And View");
        return modelAndView;
    }

}
