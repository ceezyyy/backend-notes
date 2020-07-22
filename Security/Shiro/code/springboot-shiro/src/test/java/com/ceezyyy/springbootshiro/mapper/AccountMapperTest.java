package com.ceezyyy.springbootshiro.mapper;

import com.ceezyyy.springbootshiro.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    void testFindAll() {
        List<Account> accounts = accountMapper.selectList(null);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}