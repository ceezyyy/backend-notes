package com.ceezyyy.springbootshiro.service.impl;

import com.ceezyyy.springbootshiro.entity.Account;
import com.ceezyyy.springbootshiro.mapper.AccountMapper;
import com.ceezyyy.springbootshiro.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    void findByUsername() {
        Account account = accountService.findByUsername("ls");
        System.out.println(account);
    }
}