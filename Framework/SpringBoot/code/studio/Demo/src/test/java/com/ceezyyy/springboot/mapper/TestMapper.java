package com.ceezyyy.springboot.mapper;


import com.ceezyyy.springboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapper {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("KnowKnow");
        userMapper.saveUser(user);
    }

    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(3);
        user.setUsername("Yellow Dude");
        userMapper.updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        userMapper.deleteUserById(6);
    }
}
