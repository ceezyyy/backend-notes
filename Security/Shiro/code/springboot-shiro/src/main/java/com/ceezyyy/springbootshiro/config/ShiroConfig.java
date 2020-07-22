package com.ceezyyy.springbootshiro.config;

import com.ceezyyy.springbootshiro.realm.AccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    /**
     * 注入自定义 accountRealm
     *
     * @return
     */
    @Bean
    public AccountRealm accountRealm() {
        return new AccountRealm();
    }

    /**
     * 将自定义的 accountRealm 注入到 shiro 提供的安全管理器中
     *
     * @param accountRealm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("accountRealm") AccountRealm accountRealm) {
        return new DefaultWebSecurityManager(accountRealm);
    }

    /**
     * 由 shiro 提供的 ShiroFilterFactoryBean 帮开发者创建 filters
     *
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        return shiroFilterFactoryBean;
    }

}
