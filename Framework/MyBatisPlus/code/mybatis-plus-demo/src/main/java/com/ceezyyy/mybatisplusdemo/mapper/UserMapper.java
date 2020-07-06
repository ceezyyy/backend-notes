package com.ceezyyy.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceezyyy.mybatisplusdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
