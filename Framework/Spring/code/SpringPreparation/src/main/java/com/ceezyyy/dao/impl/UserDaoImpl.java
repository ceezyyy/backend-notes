package com.ceezyyy.dao.impl;

import com.ceezyyy.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("UserDaoImpl")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("Saved!");
    }
}
