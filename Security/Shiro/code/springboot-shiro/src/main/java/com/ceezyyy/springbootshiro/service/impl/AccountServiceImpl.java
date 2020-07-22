package com.ceezyyy.springbootshiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ceezyyy.springbootshiro.entity.Account;
import com.ceezyyy.springbootshiro.mapper.AccountMapper;
import com.ceezyyy.springbootshiro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * find account by username
     *
     * @param username
     * @return
     */
    @Override
    public Account findByUsername(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        return accountMapper.selectOne(queryWrapper);
    }


}
