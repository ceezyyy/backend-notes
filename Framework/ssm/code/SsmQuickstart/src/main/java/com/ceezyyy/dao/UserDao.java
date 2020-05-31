package com.ceezyyy.dao;

import com.ceezyyy.entity.User;

import java.util.List;

public interface UserDao {
    // create
    void saveUser(User user);

    // read one
    User findUserById(int id);

    // read all
    List<User> findAll();

    // update
    void updateUser(User user);

    // delete
    void deleteUserById(int id);


}
