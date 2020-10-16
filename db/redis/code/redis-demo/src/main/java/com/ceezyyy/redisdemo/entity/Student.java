package com.ceezyyy.redisdemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private Long id;
    private String name;
}
