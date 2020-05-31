package com.ceezyyy.dao;

import com.ceezyyy.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    // create
    @Insert("insert into user(id, username) values (null, #{username})")
    void saveUser(User user);

    // read one
    @Select("select * from user where id = #{id}")
    User findUserById(int id);

    // read all
    @Select("select * from user")
    List<User> findAll();

    // update
    @Update("update user set id = #{id}, username = #{username}")
    void updateUser(User user);

    // delete
    @Delete("delete from user where id = #{id}")
    void deleteUserById(int id);


}
