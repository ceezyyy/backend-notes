package com.ceezyyy.springbootshiro.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * account
 *
 * @author ceezyyy
 */
@Data
public class Account implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String perms;

    private String role;

    private static final long serialVersionUID = 1L;
}