package com.yy.service;

import com.yy.pojo.User;

public interface UserService {
    /**
     * 用户注册
     * @param userName
     * @param password
     * @return
     */
    Boolean register(String userName, String password);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User getByUserName(String userName);
}
