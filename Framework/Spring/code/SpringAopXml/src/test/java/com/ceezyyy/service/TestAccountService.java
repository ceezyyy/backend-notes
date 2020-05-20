package com.ceezyyy.service;

import com.ceezyyy.entity.Account;
import com.ceezyyy.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestAccountService {
    private ApplicationContext context;
    private AccountService accountService;

    @Before
    public void init() {
        // get context
        context = new ClassPathXmlApplicationContext("bean.xml");
        // get bean
        accountService = (AccountService) context.getBean("accountService");
    }

    @Test
    public void findAll() {
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer() {
        boolean transfer = accountService.transferById(2, 3, 9888);
        System.out.println(transfer);
    }


}
