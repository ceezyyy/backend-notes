package com.ceezyyy.springboot.service.impl;

import com.ceezyyy.springboot.entity.User;
import com.ceezyyy.springboot.mapper.UserMapper;
import com.ceezyyy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findUserById(int id) {
        return this.userMapper.findUserById(id);
    }

}
