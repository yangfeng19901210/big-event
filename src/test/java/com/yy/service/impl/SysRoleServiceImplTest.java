package com.yy.service.impl;

import com.yy.pojo.SysRole;
import com.yy.service.SysRoleService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysRoleServiceImplTest {
    @Resource
    private SysRoleService sysRoleService;
    @Test
    void addRole(){
        SysRole sysRole = new SysRole();
        sysRoleService.save();
    }

}