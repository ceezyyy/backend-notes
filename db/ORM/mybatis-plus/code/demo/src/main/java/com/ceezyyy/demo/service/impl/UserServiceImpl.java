package com.ceezyyy.demo.service.impl;

import com.ceezyyy.demo.entity.User;
import com.ceezyyy.demo.mapper.UserMapper;
import com.ceezyyy.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ceezyyy
 * @since 2020-08-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
