package com.ceezyyy.service;

import com.ceezyyy.entity.Account;

import java.util.List;

public interface AccountService {
    // create account
    void createAccount(Account account);

    // read
    List<Account> findAll();

    // read one
    Account findAccountById(int id);

    // update
    void updateAccount(Account account);

    // delete
    void deleteAccountById(int id);

    boolean transferById(int from, int to, double money);
}
