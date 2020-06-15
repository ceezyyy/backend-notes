package com.ceezyyy.mapper;

import com.ceezyyy.entity.User;

import java.util.Collection;
import java.util.Map;

public interface UserMapper {

    // create
    void saveOrUpdateUser(User user);

    // read one
    User findUserById(long id);

    // read all
    Collection<User> findAll();

    // update
    // delete
    void deleteUserById(long id);
}
