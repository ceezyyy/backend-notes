package com.ceezyyy.mybatisplusdemo.mapper;

import com.ceezyyy.mybatisplusdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

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
    public void testSaveUser() {
        // user
        User user = new User();
        user.setUsername("陆金所");
        user.setAge(22);
        // insert
        userMapper.insert(user);
    }


    // find all
    @Test
    public void testFindAll() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
            System.out.println();
        }
    }

    // update
    @Test
    public void testUpdateUser() {
        // modify
        User user1 = userMapper.selectById(5);
        user1.setUsername("测试乐观锁1");
        User user2 = userMapper.selectById(5);
        user2.setUsername("测试乐观锁2");
        // update
        userMapper.updateById(user1);
        userMapper.updateById(user2);
    }

    // delete
    @Test
    public void testDeleteUserById() {
        userMapper.deleteById(1280413088352428033L);
    }


}