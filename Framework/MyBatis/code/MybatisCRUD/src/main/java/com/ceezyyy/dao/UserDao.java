package com.ceezyyy.dao;

import com.ceezyyy.domain.User;

import java.util.List;

public interface UserDao {
    // find all user
    List<User> findAll();

    // save user
    void save(User user);

    // update user info
    void updateUser(User user);

    // delete user by id
    void deleteUserById(Integer userId);

    // find user by id
    User findUserById(Integer userId);

    // find user by username
    List<User> findUserByName(String name);

    // find the total number of users
    int findTotal();
}
