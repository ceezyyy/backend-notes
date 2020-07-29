package com.ceezyyy.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 配置用户信息
     *
     * @return
     */
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder()
                .username("ceezyyy")
                .password("123")
                .roles("admin")
                .build();

        return new InMemoryUserDetailsManager(userDetails);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
