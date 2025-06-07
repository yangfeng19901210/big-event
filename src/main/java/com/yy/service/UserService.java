package com.yy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.pojo.User;

public interface UserService extends IService<User> {
    /**
    * @Description 用户注册
    * @Author yangfeng
    * @Date 2025/6/7 12:02
    * @Param userName 用户名
    * @Param password 密码
    * @Return java.lang.Boolean
    */
    Boolean register(String userName, String password);

    /**
    * @Description TODO
    * @Author yangfeng
    * @Date 2025/6/7 12:02
    * @Param userName
    * @Return com.yy.pojo.User
    */
    User getByUserName(String userName);
}
