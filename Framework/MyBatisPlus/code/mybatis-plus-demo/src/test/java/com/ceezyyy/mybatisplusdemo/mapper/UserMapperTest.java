package com.ceezyyy.mybatisplusdemo.mapper;

import com.ceezyyy.mybatisplusdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // create
    @Test
    public void saveUser() {
        // user
        User user = new User();
        user.setUsername("小明");
        user.setAge(20);
        // insert
        userMapper.insert(user);
    }


    // find all
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users);
        }
    }


}