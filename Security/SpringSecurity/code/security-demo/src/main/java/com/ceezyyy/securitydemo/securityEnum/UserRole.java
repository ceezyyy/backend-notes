package com.ceezyyy.securitydemo.securityEnum;

import com.ceezyyy.securitydemo.securityEnum.UserPermission;
import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {

    // 使用 guava 工具类简化代码
    VISITOR(Sets.newHashSet(UserPermission.READ)),
    ADMIN(Sets.newHashSet(UserPermission.CREATE, UserPermission.READ, UserPermission.UPDATE, UserPermission.DELETE));

    private final Set<UserPermission> permissionSet;

    UserRole(Set<UserPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<UserPermission> getPermissionSet() {
        return permissionSet;
    }

    // get authorities from specific role
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {

        // convert permission to SimpleGrantedAuthority
        Set<SimpleGrantedAuthority> authorities = getPermissionSet().stream()
                .map(userPermission -> new SimpleGrantedAuthority(userPermission.getPermission()))
                .collect(Collectors.toSet());

        // add role to authorities
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;

    }

}
