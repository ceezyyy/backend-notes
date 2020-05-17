package com.ceezyyy.service.impl;

import com.ceezyyy.dao.AccountDao;
import com.ceezyyy.entity.Account;
import com.ceezyyy.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public Account findAccountById(int id) {
        Account account = accountDao.findAccountById(id);
        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccountById(int id) {
        accountDao.deleteAccountById(id);
    }
}
