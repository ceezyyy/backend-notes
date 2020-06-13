package com.ceezyyy.mybatisplus.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceezyyy.mybatisplus.entity.Car;
import lombok.Value;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
public interface CarMapper extends BaseMapper<Car> {
}
