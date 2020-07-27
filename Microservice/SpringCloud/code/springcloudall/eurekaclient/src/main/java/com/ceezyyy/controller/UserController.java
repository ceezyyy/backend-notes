package com.ceezyyy.controller;


import com.ceezyyy.entity.User;
import com.ceezyyy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("user")
public class UserController {

    private UserMapper userMapper;

    // get local server port
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // get server port
    @GetMapping("port")
    public String getServerPort() {
        return serverPort;
    }

    // save
    @PostMapping("save")
    public void saveUser(@RequestBody User user) {
        userMapper.saveOrUpdateUser(user);
    }

    // read one
    @GetMapping("findUserById/{id}")
    public User findUserById(@PathVariable long id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    // read all
    @GetMapping("findAll")
    public Collection<User> findAll() {
        Collection<User> users = userMapper.findAll();
        return users;
    }

    // update
    @PutMapping("update")
    public void updateUser(@RequestBody User user) {
        userMapper.saveOrUpdateUser(user);
    }

    // delete
    @DeleteMapping("deleteUserById/{id}")
    public void deleteUserById(@PathVariable long id) {
        userMapper.deleteUserById(id);
    }

}
