package com.ceezyyy.dao;

import com.ceezyyy.domain.Account;
import com.ceezyyy.domain.User;

import java.util.List;

public interface UserDao {

    // find all users
    List<User> findAll();

    // find all accounts of a user
    List<User> findAllAccountsOfUser();

    // find all users and their roles
    List<User> findAllUsers();
}
