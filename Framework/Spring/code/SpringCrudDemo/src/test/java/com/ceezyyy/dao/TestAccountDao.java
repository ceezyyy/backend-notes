package com.ceezyyy.dao;

import com.ceezyyy.entity.Account;
import com.ceezyyy.service.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class TestAccountDao {
    @Resource()
    private AccountService accountService;

    @Test
    // OK
    public void testFindAll() {
        // service
        List<Account> accounts = accountService.findAll();
        // result
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    // OK
    public void testFindAccountById() {
        Account account = accountService.findAccountById(2);
        System.out.println(account);
    }

    @Test
    // OK
    public void testSaveAccount() {
        Account account = new Account();
        account.setId(4);
        account.setName("ddd");
        account.setMoney(12999.0);
        accountService.saveAccount(account);
    }

    @Test
    // OK
    public void testUpdateAccount() {
        Account account = new Account();
        account.setId(3);
        account.setName("zzz");
        account.setMoney(10000.0);
        accountService.updateAccount(account);
    }

    @Test
    // OK
    public void testDeleteAccount() {
        accountService.deleteAccountById(4);
    }

    @Test
    public void testTransfer() {
        boolean transfer = accountService.transfer(1, 4, 10);
        System.out.println(transfer);
    }

}
