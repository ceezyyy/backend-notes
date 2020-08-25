package com.ceezyyy.mybatisplusdemo.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEnum {
    WORK(1, "work"),
    REST(0, "rest");

    @EnumValue
    private Integer code;
    private String msg;

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
