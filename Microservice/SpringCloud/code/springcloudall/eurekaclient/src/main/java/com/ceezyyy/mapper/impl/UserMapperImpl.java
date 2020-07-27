package com.ceezyyy.mapper.impl;

import com.ceezyyy.entity.User;
import com.ceezyyy.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository(value = "userMapper")
public class UserMapperImpl implements UserMapper {

    // data
    private static Map<Long, User> userMap;

    static {
        userMap = new HashMap<>();
        userMap.put(1L, new User(1L, "LBJ"));
        userMap.put(2L, new User(2L, "Nike"));
        userMap.put(3L, new User(3L, "Adidas"));
    }

    @Override
    public void saveOrUpdateUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User findUserById(long id) {
        return userMap.get(id);
    }

    @Override
    public Collection<User> findAll() {
        return userMap.values();
    }

    @Override
    public void deleteUserById(long id) {
        userMap.remove(id);
    }
}
