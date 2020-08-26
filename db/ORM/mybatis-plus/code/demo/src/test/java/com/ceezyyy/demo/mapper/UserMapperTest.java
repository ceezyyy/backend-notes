package com.ceezyyy.demo.mapper;

import com.ceezyyy.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1087982257332887553l);
        System.out.println(user);
    }


}