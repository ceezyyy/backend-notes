package com.ceezyyy.service;

import com.ceezyyy.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class testService {
    @Test
    public void testService() {
        ApplicationContext context = new FileSystemXmlApplicationContext("ApplicationContext.xml");
        UserService userService = context.getBean("userService", UserServiceImpl.class);
        userService.deleteUserById(1);
    }
}
