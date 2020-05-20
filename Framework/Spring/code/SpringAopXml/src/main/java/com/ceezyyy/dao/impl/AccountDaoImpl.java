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

    // spring DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // OK
    public void createAccount(Account account) {
        try {
            sql = "insert into account(name, money) values (?,?)";
            jdbcTemplate.update(sql, account.getName(), account.getMoney());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public List<Account> findAll() {
        List<Account> accounts = null;
        try {
            sql = "select id, name, money from account";
            accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return accounts;
    }


    public Account findAccountById(int id) {
        List<Account> accounts = null;
        try {
            sql = "select id, name, money from account where id = ?";
            accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return accounts == null ? null : accounts.get(0);
    }

    public void updateAccount(Account account) {
        try {
            sql = "update account set name = ?, money = ? where id = ?";
            jdbcTemplate.update(sql, account.getName(), account.getMoney(), account.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccountById(int id) {
        try {
            sql = "delete from account where id = ?";
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }


}
