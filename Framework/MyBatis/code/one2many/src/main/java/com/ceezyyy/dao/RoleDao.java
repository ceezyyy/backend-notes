package com.ceezyyy.dao;

import com.ceezyyy.domain.Role;

import java.util.List;

public interface RoleDao {

    // find all roles
    List<Role> findAll();

    List<Role> findAllRoles();
}
