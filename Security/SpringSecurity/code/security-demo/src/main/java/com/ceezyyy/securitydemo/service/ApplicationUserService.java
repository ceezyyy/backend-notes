package com.ceezyyy.securitydemo.service;

import com.ceezyyy.securitydemo.entity.ApplicationUser;
import com.ceezyyy.securitydemo.mapper.ApplicationUserMapper;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ApplicationUserService implements UserDetailsService {

    private ApplicationUserMapper mapper;

    @Autowired
    public ApplicationUserService(ApplicationUserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<ApplicationUser> user = mapper.selectApplicationUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return (UserDetails) user.get();

    }
}
