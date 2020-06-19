package com.ceezyyy.controller;


import com.ceezyyy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("rest")
public class RestTemplateController {

    private RestTemplate restTemplate;
    // the url of service provider
    private String url = "http://localhost:8010";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // read one
    @GetMapping("findUserById/{id}")
    public User findUserById(@PathVariable(value = "id") long id) {
        User user = restTemplate.getForEntity(url + "/user/findUserById/{id}", User.class, id).getBody();
        return user;
    }
    // read all

    // update
    // delete


}
