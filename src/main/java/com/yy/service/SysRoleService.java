package com.yy.service;

import com.yy.common.entity.PageDTO;
import com.yy.pojo.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.vo.out.RolePageOutVO;
import com.yy.vo.query.RolePageQueryVO;
import jakarta.validation.Valid;

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
    /**
     * 获取所有角色信息
     * @param
     * @Return: java.util.List<com.yy.pojo.SysRole>
     * @author: yangfeng
     * @date: 2025/7/30 15:11
     **/
    List<SysRole> getAllRoles();
    /**
     * 分页获取角色列表
     * @param vo
     * @Return: com.yy.common.entity.PageDTO<com.yy.vo.out.RolePageOutVO>
     * @author: yangfeng
     * @date: 2025/8/1 9:57
     **/
    PageDTO<RolePageOutVO> getRolePageData(@Valid RolePageQueryVO vo);
}
