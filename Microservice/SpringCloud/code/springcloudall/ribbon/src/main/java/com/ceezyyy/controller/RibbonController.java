package com.ceezyyy.controller;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("ribbon")
public class RibbonController {

    private RestTemplate restTemplate;
    private String url = "http://provider/user";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("findAll")
    public Collection<User> findAll() {
        Collection collection = restTemplate.getForEntity(url + "/findAll", Collection.class).getBody();
        return collection;
    }

    // get current server port
    @GetMapping("port")
    public String getServerPort() {
        String port = restTemplate.getForEntity(url + "/port", String.class).getBody();
        return port;
    }
}
