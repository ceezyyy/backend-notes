package com.ceezyyy.dao;

import com.ceezyyy.domain.User;

import java.util.List;

public interface UserDao {
    // find all user
    List<User> findAll();

    // save user
    void save(User user);
}
