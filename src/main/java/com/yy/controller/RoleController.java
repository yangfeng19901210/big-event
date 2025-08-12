package com.yy.controller;

import com.yy.common.entity.PageDTO;
import com.yy.pojo.CustomUser;
import com.yy.pojo.SysRole;
import com.yy.service.SysRoleService;
import com.yy.vo.out.RolePageOutVO;
import com.yy.vo.query.RolePageQueryVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
//    @PreAuthorize("hasRole('ADMIN')")
    public List<SysRole> getAllRoles() {
        return sysRoleService.getAllRoles();
    }
    /**
     *
     * @param userId 用户id
     * @Return: java.util.List<com.yy.pojo.SysRole>
     * @author: yangfeng
     * @date: 2025/7/31 11:55
     **/
    @GetMapping("/getUserRoles/{userId}")
    public List<SysRole> getUserRoles(@PathVariable Long userId) {
        return sysRoleService.getRolesByUserId(userId);
    }
    /**
     * 分页获取角色列表
     * @param vo
     * @Return: com.yy.common.entity.PageDTO<com.yy.vo.out.RolePageOutVO>
     * @author: yangfeng
     * @date: 2025/8/1 9:46
     **/
    @PostMapping("/getRolePageData")
    public PageDTO<RolePageOutVO> getRolePageData(@RequestBody @Valid RolePageQueryVO vo) {
        return sysRoleService.getRolePageData(vo);
    }
}