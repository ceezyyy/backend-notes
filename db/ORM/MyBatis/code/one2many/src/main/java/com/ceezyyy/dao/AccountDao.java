package com.ceezyyy.dao;

import com.ceezyyy.domain.Account;

import java.util.List;

public interface AccountDao {

    // find all accounts
    List<Account> findAll();

    // find all the account with the info of user
    List<Account> findAccountUserAll();
}
