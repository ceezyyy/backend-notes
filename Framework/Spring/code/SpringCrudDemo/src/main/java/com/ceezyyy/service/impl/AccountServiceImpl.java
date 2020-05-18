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

    public void saveAccount(Account account) {
        /**
         * Description: save account
         * @param: [account]
         * @return: void
         */
        accountDao.saveAccount(account);
    }

    public Account findAccountById(int id) {
        /**
         * Description: find account by id
         * @param: [id]
         * @return: com.ceezyyy.entity.Account
         */
        return accountDao.findAccountById(id);
    }

    public List<Account> findAll() {
        /**
         * Description: find all accounts
         * @param: []
         * @return: java.util.List<com.ceezyyy.entity.Account>
         */
        return accountDao.findAll();
    }

    public void updateAccount(Account account) {
        /**
         * Description: update account
         * @param: [account]
         * @return: void
         */
        accountDao.updateAccount(account);
    }

    public void deleteAccountById(int id) {
        /**
         * Description: delete account by id
         * @param: [id]
         * @return: void
         */
        accountDao.deleteAccountById(id);

    }

    public boolean transfer(int from, int to, double amount) {
        /**
         * Description: transfer amount from a to b
         * @param: [from, to, amount]
         * @return: boolean
         */
        // find account by id
        Account a = accountDao.findAccountById(from);
        Account b = accountDao.findAccountById(to);
        // check account
        if (a != null && b != null) {
            // money available
            if (a.getMoney() >= amount) {
                // transfer
                a.setMoney(a.getMoney() - amount);
                b.setMoney(b.getMoney() + amount);
                // update
                accountDao.updateAccount(a);
                // error
                double temp = 2 / 0;
                accountDao.updateAccount(b);
                return true;
            }
        }
        return false;
    }
}
