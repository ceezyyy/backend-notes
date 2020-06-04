package com.ceezyyy.springboot.service;

import com.ceezyyy.springboot.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {

    User findUserById(int id);

}
