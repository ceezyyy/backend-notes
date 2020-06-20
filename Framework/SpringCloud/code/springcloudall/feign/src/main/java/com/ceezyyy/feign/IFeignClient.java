package com.ceezyyy.feign;


import com.ceezyyy.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@FeignClient(name = "provider", path = "/user")
@RequestMapping("feign")
public interface IFeignClient {
    // read all
    @GetMapping("/user/findAll")
    Collection<User> findAll();

    // read one
    @GetMapping("/user/findUserById'{id}")
    User findUserById(@PathVariable long id);

}
