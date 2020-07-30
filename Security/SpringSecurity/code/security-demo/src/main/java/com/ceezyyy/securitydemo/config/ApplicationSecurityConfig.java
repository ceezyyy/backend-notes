package com.ceezyyy.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.ceezyyy.securitydemo.securityEnum.UserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 配置用户信息
     *
     * @return
     */
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        // user 1
        UserDetails ceezyyy = User.builder()
                .username("ceezyyy")
                .password(passwordEncoder.encode("123"))
                // name() 返回常量的名称
                .roles(ADMIN.name())
                .build();

        // user 2
        UserDetails littleYellow = User.builder()
                .username("littleYellow")
                .password(passwordEncoder.encode("123"))
                .roles(VISITOR.name())
                .build();


        return new InMemoryUserDetailsManager(ceezyyy, littleYellow);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/admin").hasRole(ADMIN.name())
                .antMatchers("/visitor").hasRole(VISITOR.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
