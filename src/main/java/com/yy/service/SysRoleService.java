package com.yy.service;

import com.yy.pojo.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yangfeng
* @description 针对表【sys_role(角色信息表)】的数据库操作Service
* @createDate 2025-07-17 16:26:59
*/
public interface SysRoleService extends IService<SysRole> {
    /**
     * 角色新增权限
     * @param roleId 角色id
     * @param permIds 权限id集合
     * @Return: boolean
     * @author: yangfeng
     * @date: 2025/7/18 9:10
     **/
    boolean addPerms(Long roleId, List<Long> permIds);
    /**
     * 根据用户id获取角色
     * @param userId
     * @Return: java.util.List<com.yy.pojo.SysRole>
     * @author: yangfeng
     * @date: 2025/7/18 11:18
     **/
    List<SysRole> getRolesByUserId(Long userId);

}
