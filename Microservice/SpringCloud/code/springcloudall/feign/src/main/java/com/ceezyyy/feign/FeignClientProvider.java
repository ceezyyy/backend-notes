package com.ceezyyy.feign;


import com.ceezyyy.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(value = "provider")
public interface FeignClientProvider {

    // read all
    @GetMapping("/user/findAll")
    Collection<User> findAll();

    // read one
    @GetMapping("/user/findUserById/{id}")
    User findUserById(@PathVariable long id);

    // get server port
    @GetMapping("/user/port")
    String getServerPort();
}
