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

import static com.ceezyyy.securitydemo.config.ApplicationUserRole.*;

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

        // user 1: admin
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
//                .roles(ADMIN.name())  // ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        // user 2: visitor
        UserDetails visitor = User.builder()
                .username("visitor")
                .password(passwordEncoder.encode("123"))
//                .roles(VISITOR.name())  // ROLE_VISITOR
                .authorities(VISITOR.getGrantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(admin, visitor);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()

                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
