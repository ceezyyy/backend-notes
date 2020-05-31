package com.ceezyyy.service;

import com.ceezyyy.entity.User;

import java.util.List;

public interface UserService {
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
