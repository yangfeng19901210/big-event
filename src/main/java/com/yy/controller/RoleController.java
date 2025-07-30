package com.yy.controller;

import com.yy.pojo.CustomUser;
import com.yy.pojo.SysRole;
import com.yy.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色管理controller
 * @ClassName RoleController
 * @Author yangfeng
 * @Date 2025/7/30 15:44
 * @Version 1.0
 */
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@Validated
@Slf4j
public class RoleController {
    private final SysRoleService sysRoleService;
    /**
     * 获取所有角色信息
     * @param
     * @Return: java.util.List<com.yy.pojo.SysRole>
     * @author: yangfeng
     * @date: 2025/7/30 15:48
     **/
    @GetMapping("/getAllRoles")
    @PreAuthorize("hasRole('ADMIN')")
    public List<SysRole> getAllRoles() {
        return sysRoleService.getAllRoles();
    }
    /**
     * 获取当前用户角色信息
     * @param authentication
     * @Return: java.util.List<com.yy.pojo.SysRole>
     * @author: yangfeng
     * @date: 2025/7/30 15:52
     **/
    @GetMapping("/getCurrentUserRoles")
    public List<SysRole> getCurrentUserRoles(Authentication authentication){
        CustomUser userDetails = (CustomUser) authentication.getPrincipal();
        return sysRoleService.getRolesByUserId(userDetails.getId());
    }
}