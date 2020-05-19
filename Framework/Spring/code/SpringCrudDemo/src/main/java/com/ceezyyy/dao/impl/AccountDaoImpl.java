package com.ceezyyy.dao.impl;

import com.ceezyyy.dao.AccountDao;
import com.ceezyyy.entity.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAccount(Account account) {
        /**
         * Description: save account
         * @param: [account]
         * @return: void
         */
        try {
            sql = "insert into account(id, name, money) values (?,?,?)";
            jdbcTemplate.update(sql, account.getId(), account.getName(), account.getMoney());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public Account findAccountById(int id) {
        /**
         * Description: find account by id
         * @param: [id]
         * @return: com.ceezyyy.entity.Account
         */
        Account account = null;
        try {
            sql = "select * from account where id = ?";
            account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> findAll() {
        /**
         * Description: find all accounts
         * @param: []
         * @return: java.util.List<com.ceezyyy.entity.Account>
         */
        List<Account> accounts = null;
        try {
            sql = "select * from account";
            accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void updateAccount(Account account) {
        /**
         * Description: update account
         * @param: [account]
         * @return: void
         */
        try {
            sql = "update account set name = ?, money = ? where id = ?";
            jdbcTemplate.update(sql, account.getName(), account.getMoney(), account.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccountById(int id) {
        /**
         * Description: delete account by id
         * @param: [id]
         * @return: void
         */
        try {
            sql = "delete from account where id = ?";
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }


}