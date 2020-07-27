package com.ceezyyy.controller;


import com.ceezyyy.entity.User;
import com.ceezyyy.feign.FeignClientProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("feign")
public class FeignController {

    private FeignClientProvider feignClientProvider;

    @Autowired
    public void setFeignClientProvider(FeignClientProvider feignClientProvider) {
        this.feignClientProvider = feignClientProvider;
    }

    // read all
    @GetMapping("findAll")
    public Collection<User> findAll() {
        return feignClientProvider.findAll();
    }

    // read one
    @GetMapping("findUserById/{id}")
    public User findUserById(@PathVariable long id) {
        return feignClientProvider.findUserById(id);
    }

    // get server port
    @GetMapping("port")
    public String getServerPort() {
        return feignClientProvider.getServerPort();
    }
}
