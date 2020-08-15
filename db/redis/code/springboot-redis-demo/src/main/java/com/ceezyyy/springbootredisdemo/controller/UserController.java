package com.ceezyyy.springbootredisdemo.controller;

import com.ceezyyy.springbootredisdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserController {

    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // create
    @PostMapping("set")
    public void set(@RequestBody User user) {
        redisTemplate.opsForValue().set("user", user);
    }

    // read one
    @GetMapping("get/{key}")
    public User get(@PathVariable String key) {
        return (User) redisTemplate.opsForValue().get(key);
    }

    // delete
    @DeleteMapping("delete/{key}")
    public boolean delete(@PathVariable String key) {
        redisTemplate.delete(key);
        return !redisTemplate.hasKey(key);
    }
}
