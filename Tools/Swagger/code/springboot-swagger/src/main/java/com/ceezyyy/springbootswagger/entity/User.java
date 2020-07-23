package com.ceezyyy.springbootswagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("User entity")
public class User {

    @ApiModelProperty("Username of user")
    private String username;

    @ApiModelProperty("Password of user")
    private String password;

}
