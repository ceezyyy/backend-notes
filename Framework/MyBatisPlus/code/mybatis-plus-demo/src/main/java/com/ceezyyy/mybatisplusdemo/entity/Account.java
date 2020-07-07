package com.ceezyyy.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class Account {
    private Integer id;  // pk
    @TableField(value = "username")
    private String name;
    private Integer age;
}
