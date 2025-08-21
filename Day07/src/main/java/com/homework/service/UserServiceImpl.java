package com.homework.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.homework.entity.User;
import com.homework.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
