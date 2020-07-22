package com.ceezyyy.springbootshiro.realm;

import com.ceezyyy.springbootshiro.entity.Account;
import com.ceezyyy.springbootshiro.service.AccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private AccountService accountService;

    /**
     * 授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 验证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // get UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        // get account by username (from database)
        Account account = accountService.findByUsername(token.getUsername());

        if (account != null) {
            return new SimpleAuthenticationInfo(account, account.getPassword(), getName());
        }

        // if account is null
        return null;

    }
}
