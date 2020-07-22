package com.ceezyyy.springbootshiro.service;

import com.ceezyyy.springbootshiro.entity.Account;

public interface AccountService {

    /**
     * find account by username
     *
     * @return
     */
    Account findByUsername(String username);

}
