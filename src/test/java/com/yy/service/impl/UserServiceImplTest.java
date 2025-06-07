package com.yy.service.impl;

import com.yy.pojo.User;
import com.yy.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Test
    void add(){
        User user = new User();
        user.setUsername("test");
        userService.save(user);
    }
    @Test
    void update(){
        User user = new User();
        user.setId(7);
        user.setUsername("test111");
        user.setNickname("test222");
        userService.updateById(user);
    }
    @Test
    void delete(){
        userService.removeById(7);
    }

}