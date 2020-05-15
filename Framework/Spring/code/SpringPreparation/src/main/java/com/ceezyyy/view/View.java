package com.ceezyyy.view;

import com.ceezyyy.dao.UserDao;
import com.ceezyyy.dao.impl.UserDaoImpl;
import com.ceezyyy.service.UserService;
import com.ceezyyy.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class View {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserService userServiceImpl = applicationContext.getBean("UserServiceImpl", UserServiceImpl.class);
        UserDao userDaoImpl = applicationContext.getBean("UserDaoImpl", UserDaoImpl.class);

        // result
        System.out.println(userServiceImpl);
        System.out.println(userDaoImpl);

    }
}
