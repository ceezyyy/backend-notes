package com.ceezyyy.securitydemo.config;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {

    // 使用 guava 工具类简化代码
    VISITOR(Sets.newHashSet(ApplicationUserPermission.READ)),
    ADMIN(Sets.newHashSet(ApplicationUserPermission.CREATE, ApplicationUserPermission.READ, ApplicationUserPermission.UPDATE, ApplicationUserPermission.DELETE));

    private final Set<ApplicationUserPermission> permissionSet;

    ApplicationUserRole(Set<ApplicationUserPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<ApplicationUserPermission> getPermissionSet() {
        return permissionSet;
    }

    // get authorities from specific role
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {

        // convert permission to SimpleGrantedAuthority
        Set<SimpleGrantedAuthority> authorities = getPermissionSet().stream()
                .map(applicationUserPermission -> new SimpleGrantedAuthority(applicationUserPermission.getPermission()))
                .collect(Collectors.toSet());

        // add role to authorities
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;

    }

}
