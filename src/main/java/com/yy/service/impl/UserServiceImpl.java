package com.yy.service.impl;

import com.yy.mapper.UserMapper;
import com.yy.pojo.User;
import com.yy.service.UserService;
import com.yy.utils.Md5Util;
import io.gitee.loulan_yxq.owner.core.tool.AssertTool;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public Boolean register(String userName, String password) {
        User u = getByUserName(userName);
        AssertTool.isNull(u,"用户名已被占用");
        //对密码加密
        String md5String = Md5Util.getMD5String(password);
        //添加用户
        LocalDateTime now = LocalDateTime.now();
        userMapper.addV1(userName,md5String,now,now);
        return true;
    }
    /**
    * @Description TODO
    * @Author yangfeng
    * @Date 2025/6/7 12:01
    * @Param userName
    * @Return com.yy.pojo.User
    */
    @Override
    public User getByUserName(String userName) {
        return userMapper.getByUserName(userName);
    }
}
