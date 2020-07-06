package com.ceezyyy.mybatisplusdemo.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;  // pk
    private String username;
    private Integer age;
}
