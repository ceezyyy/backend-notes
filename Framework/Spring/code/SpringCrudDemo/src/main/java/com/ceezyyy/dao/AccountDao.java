package com.ceezyyy.dao;

import com.ceezyyy.entity.Account;

import java.util.List;

public interface AccountDao {
    // create
    void saveAccount(Account account);

    // read one
    Account findAccountById(int id);

    // read all
    List<Account> findAll();

    // update
    void updateAccount(Account account);

    // delete
    void deleteAccountById(int id);
}
