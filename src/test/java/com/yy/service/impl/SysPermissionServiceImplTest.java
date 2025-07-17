package com.yy.service.impl;

import com.yy.pojo.SysPermission;
import com.yy.service.SysPermissionService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysPermissionServiceImplTest {
    @Resource
    private SysPermissionService sysPermissionService;
    @Test
    void add(){
        SysPermission sysPermission = new SysPermission();
        sysPermission.setPermCode("user:userInfo");
        sysPermission.setPermName("获取用户详细信息");
        sysPermission.setUrlPattern("/user/userInfo");
        sysPermission.setHttpMethod("GET");
        sysPermissionService.save(sysPermission);
    }

}