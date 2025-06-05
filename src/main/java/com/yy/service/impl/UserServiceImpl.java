package com.yy.service.impl;

import com.yy.mapper.UserMapper;
import com.yy.pojo.Result;
import com.yy.pojo.User;
import com.yy.service.UserService;
import com.yy.utils.Md5Util;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public Boolean register(String userName, String password) {
        User u = getByUserName(userName);
        Assert.isNull(u,"用户名已被占用");
        //对密码加密
        String md5String = Md5Util.getMD5String(password);
        //添加用户
        userMapper.add(userName,md5String);
        return true;
    }

    @Override
    public User getByUserName(String userName) {
        return userMapper.getByUserName(userName);
    }
}
