package com.ceezyyy.demo.mapper;

import com.ceezyyy.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


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
        User user = userMapper.selectById(1087982257332887553L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        List<Long> idList = Arrays.asList(1088248166370832385L, 1094592041087729666L, 1094590409767661570L);
        userMapper.selectBatchIds(idList).forEach(System.out::println);
    }


}