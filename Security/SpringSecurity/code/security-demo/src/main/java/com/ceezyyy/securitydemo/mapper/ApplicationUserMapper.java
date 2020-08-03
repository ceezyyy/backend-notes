package com.ceezyyy.securitydemo.mapper;

import com.ceezyyy.securitydemo.entity.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserMapper {

    /**
     * select applicationUser by username
     *
     * @param username
     * @return
     */
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
