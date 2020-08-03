package com.ceezyyy.securitydemo.mapper.impl;

import com.ceezyyy.securitydemo.entity.ApplicationUser;
import com.ceezyyy.securitydemo.mapper.ApplicationUserMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.ceezyyy.securitydemo.entity.ApplicationUserRole.ADMIN;


@Repository("fake")
public class ApplicationUserMapperImpl implements ApplicationUserMapper {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserMapperImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }


    /**
     * get application users
     *
     * @return
     */
    private List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("123"),
                        "admin",
                        true,
                        true,
                        true,
                        true
                )
        );
    }


}
