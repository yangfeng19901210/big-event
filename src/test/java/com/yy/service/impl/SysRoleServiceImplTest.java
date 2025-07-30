package com.yy.service.impl;

import com.yy.pojo.SysRole;
import com.yy.service.SysRoleService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysRoleServiceImplTest {
    @Resource
    private SysRoleService sysRoleService;
    @Test
    void addRole(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleCode("admin");
        sysRole.setRoleName("管理员");
        sysRoleService.save(sysRole);
    }
    /**
     * 添加角色权限
     */
    @Test
    void addPermsToRole(){
        sysRoleService.addPerms(3L, List.of(1L, 2L, 3L));
    }
    @Test
    void selectAllRoles() {
        List<SysRole> sysRoles = sysRoleService.getAllRoles();
        sysRoles.forEach(System.out::println);
    }
    @Test
    void getRolesByUserId(){
        List<SysRole> sysRoles = sysRoleService.getRolesByUserId(6L);
        sysRoles.forEach(System.out::println);
    }

}