package com.ceezyyy.service;

import com.ceezyyy.dao.impl.UserDaoImpl;
import com.ceezyyy.entity.User;
import com.ceezyyy.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class testService {
    @Test
    public void testService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserServiceImpl.class);
        userService.findAll();
        userService.findUserById(1);
        userService.saveUser(new User());
        userService.updateUser(new User());
        userService.deleteUserById(1);
    }
}
