package com.ceezyyy.dao.impl;

import com.ceezyyy.dao.UserDao;
import com.ceezyyy.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser(User user) {
        System.out.println("Save user");
    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void updateUser(User user) {
        System.out.println("Update user");
    }

    @Override
    public void deleteUserById(int id) {
        System.out.println("Delete user");
    }
}
