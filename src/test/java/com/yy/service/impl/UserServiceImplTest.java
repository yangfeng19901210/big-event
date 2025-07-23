package com.yy.service.impl;

import com.yy.mapper.UserMapper;
import com.yy.pojo.SysPermission;
import com.yy.pojo.User;
import com.yy.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    @Test
    void add(){
        User user = new User();
        user.setUsername("test");
        userService.save(user);
    }
    @Test
    void update(){
        User user = new User();
        user.setId(7L);
        user.setUsername("test111");
        user.setNickname("test222");
        userService.updateById(user);
    }
    @Test
    void delete(){
        userService.removeById(7);
    }
    @Test
    void addRolesToUser(){
        userService.addRolesToUser(10L, List.of(1L, 2L, 3L));
    }
    @Test
    void getPermsByUserId(){
        List<SysPermission> permissions = userMapper.getByUserId(6L);
        log.info("用户id 6的权限: {}", permissions);

    }
    @Test
    void getPermsByUsername(){
        List<SysPermission> permissions = userMapper.getPermByUserName("xiaomayi");
        log.info("用户名= xiaomayi 的权限: {}", permissions);

    }

}