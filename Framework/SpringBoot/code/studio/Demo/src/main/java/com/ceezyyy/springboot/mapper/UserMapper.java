package com.ceezyyy.springboot.mapper;


import com.ceezyyy.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

}
