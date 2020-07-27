package com.ceezyyy.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ceezyyy.mybatisplusdemo.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    // pk
    private Long id;
    private String username;
    private Integer age;
    // autofill when insert
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
    // autofill when insert and update
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    @Version
    private Integer version;
    private StatusEnum status;
    @TableLogic
    // 0: not delete
    // 1: delete
    private Integer deleted;
}
