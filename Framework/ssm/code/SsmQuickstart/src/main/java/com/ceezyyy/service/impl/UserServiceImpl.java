package com.ceezyyy.service.impl;

import com.ceezyyy.dao.UserDao;
import com.ceezyyy.entity.User;
import com.ceezyyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
//    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        System.out.println("Save user");
    }

    @Override
    public User findUserById(int id) {
        System.out.println("Find user by id");
        return null;
    }

    @Override
    public List<User> findAll() {
        System.out.println("Find all users");
        return null;
    }

    @Override
    public void updateUser(User user) {
        System.out.println("Update user");
    }

    @Override
    public void deleteUserById(int id) {
        System.out.println("Delete user by id");
    }
}
