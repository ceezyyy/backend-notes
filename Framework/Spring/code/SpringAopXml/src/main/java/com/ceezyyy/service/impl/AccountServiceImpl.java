package com.ceezyyy.service.impl;

import com.ceezyyy.dao.AccountDao;
import com.ceezyyy.entity.Account;
import com.ceezyyy.service.AccountService;
import org.springframework.transaction.TransactionManager;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    // spring DI
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void createAccount(Account account) {
        accountDao.createAccount(account);
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    @Override
    public Account findAccountById(int id) {
        Account account = accountDao.findAccountById(id);
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccountById(int id) {
        accountDao.deleteAccountById(id);
    }

    @Override
    public boolean transferById(int from, int to, double money) {
        Account a = accountDao.findAccountById(from);
        Account b = accountDao.findAccountById(to);
        if (a != null && b != null && a.getMoney() >= money) {
            // transfer
            a.setMoney(a.getMoney() - money);
            b.setMoney(b.getMoney() + money);
            // update
            accountDao.updateAccount(a);
            // set error
            double temp = 1 / 0;
            accountDao.updateAccount(b);
            return true;
        }
        return false;
    }
}
