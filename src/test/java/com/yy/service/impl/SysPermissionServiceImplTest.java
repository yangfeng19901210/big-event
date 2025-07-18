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
        sysPermission.setPermCode("article:delete");
        sysPermission.setPermName("删除文章");
        sysPermission.setUrlPattern("/article");
        sysPermission.setHttpMethod("DELETE");
        sysPermissionService.save(sysPermission);
    }

}