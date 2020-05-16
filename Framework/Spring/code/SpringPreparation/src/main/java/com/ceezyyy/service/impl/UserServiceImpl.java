package com.ceezyyy.service.impl;


import com.ceezyyy.dao.UserDao;
import com.ceezyyy.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource(name = "UserDaoImpl")
    private UserDao userDao;
    @Value("1")
    private int a;
    @Value("2")
    private double b;

    public void save() {
        userDao.save();
        System.out.println(a);
        System.out.println(b);
    }
}
