package com.ceezyyy.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "cars_info")
public class Car {
    @TableId
    private Integer id;
    private String carname;
    private Integer cid;
    private String country;
    private String founder;
    private Date founded;
    private String description;
    private String website;
}
