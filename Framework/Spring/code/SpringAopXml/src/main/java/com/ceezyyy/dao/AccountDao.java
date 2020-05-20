package com.ceezyyy.dao;

import com.ceezyyy.entity.Account;

import java.util.List;

public interface AccountDao {

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

}
