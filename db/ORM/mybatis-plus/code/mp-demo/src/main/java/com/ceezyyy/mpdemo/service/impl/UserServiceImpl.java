package com.ceezyyy.mpdemo.service.impl;

import com.ceezyyy.mpdemo.entity.User;
import com.ceezyyy.mpdemo.mapper.UserMapper;
import com.ceezyyy.mpdemo.service.IUserService;
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
