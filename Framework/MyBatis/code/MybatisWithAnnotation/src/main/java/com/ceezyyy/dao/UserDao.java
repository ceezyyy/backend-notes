package com.ceezyyy.dao;

import com.ceezyyy.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Results(id = "userMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address")
    })
    @Select("select * from user where id = #{id}")
    User findUserById(int id);

    // find all users
    @Select("select id, username, birthday, sex, address from user")
    List<User> findAll();

    // Create user
    @Insert("insert into user(id, username, birthday, sex, address) values (#{id}, #{username}, #{birthday}, #{sex}, #{address})")
    void createUser(User user);

    // update user
    @Update("update user set username = #{username}, sex = #{sex}, address = #{address} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUserById(int id);

    @Select("select count(*) from user")
    int getTotalCount();

}
