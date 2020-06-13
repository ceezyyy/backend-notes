package com.ceezyyy.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ceezyyy.mybatisplus.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarMapperTest {

    @Autowired
    private CarMapper carMapper;

    @Test
    void readAll() {
        // read all
        List<Car> cars = carMapper.selectList(null);
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    void readOne() {
        // read one
        QueryWrapper wrapper = new QueryWrapper<Car>();
        wrapper.eq("id", 1);
        Car car = carMapper.selectOne(wrapper);
        System.out.println(car);
    }

    @Test
    void testGe() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge("cid", 3);
        List list = carMapper.selectList(queryWrapper);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    void test() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("country", "U");

        List list = carMapper.selectList(queryWrapper);
        for (Object o : list) {
            System.out.println(o);
        }

    }


}