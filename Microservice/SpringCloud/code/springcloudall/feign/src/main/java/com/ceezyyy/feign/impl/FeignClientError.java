package com.ceezyyy.feign.impl;

import com.ceezyyy.entity.User;
import com.ceezyyy.feign.FeignClientProvider;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public class FeignClientError implements FeignClientProvider {
    @Override
    public Collection<User> findAll() {
        return null;
    }

    @Override
    public User findUserById(long id) {
        return null;
    }

    @Override
    public String getServerPort() {
        return null;
    }
}
