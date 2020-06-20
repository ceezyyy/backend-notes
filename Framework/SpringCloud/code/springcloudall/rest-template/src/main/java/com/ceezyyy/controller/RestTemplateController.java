package com.ceezyyy.controller;


import com.ceezyyy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

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

    // create
    @PostMapping("save")
    public void saveUser(@RequestBody User user) {
        restTemplate.postForLocation(url + "/user/save", user);
    }

    // read one
    @GetMapping("findUserById/{id}")
    public User findUserById(@PathVariable(value = "id") long id) {
        User user = restTemplate.getForEntity(url + "/user/findUserById/{id}", User.class, id).getBody();
        return user;
    }

    // read all
    @GetMapping("findAll")
    public Collection<User> findAll() {
        Collection users = restTemplate.getForEntity(url + "/user/findAll", Collection.class).getBody();
        return users;
    }

    // update
    @PutMapping("update")
    public void update(@RequestBody User user) {
        restTemplate.put(url + "/user/update", user);
    }

    // delete
    @DeleteMapping("deleteUserById/{id}")
    public void deleteUserById(@PathVariable long id) {
        restTemplate.delete(url + "user/deleteUserById/{id}", id);
    }

}
