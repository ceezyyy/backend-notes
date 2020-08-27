package com.ceezyyy.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ceezyyy.demo.entity.User;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Test
    public void testSelectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 32);
        userMapper.selectByMap(map).forEach(System.out::println);
    }

    @Test
    public void testSelectByWrapper() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper
                

        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }


}