package com.ceezyyy.springboot.mapper;


import com.ceezyyy.springboot.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Insert("insert into user(id, username) values (#{id}, #{username}) ")
    void saveUser(User user);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findUserById(int id);

    @Update("update user set username = #{username} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUserById(int id);

}
