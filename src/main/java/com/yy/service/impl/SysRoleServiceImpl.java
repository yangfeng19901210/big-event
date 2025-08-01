package com.yy.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.common.entity.PageDTO;
import com.yy.pojo.SysRole;
import com.yy.pojo.SysRolePerm;
import com.yy.pojo.SysUserRole;
import com.yy.service.SysRolePermService;
import com.yy.service.SysRoleService;
import com.yy.mapper.SysRoleMapper;
import com.yy.service.SysUserRoleService;
import com.yy.vo.out.RolePageOutVO;
import com.yy.vo.query.RolePageQueryVO;
import io.gitee.loulan_yxq.owner.core.collection.CollTool;
import io.gitee.loulan_yxq.owner.core.tool.StrTool;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yangfeng
* @description 针对表【sys_role(角色信息表)】的数据库操作Service实现
* @createDate 2025-07-17 16:26:59
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService{
    @Resource
    private SysRolePermService sysRolePermService;
    @Resource
    private SysUserRoleService sysUserRoleService;

    @Override
    public boolean addPerms(Long roleId, List<Long> permIds) {
        List<SysRolePerm> rolePerms = permIds.stream().map(permId -> {
            SysRolePerm sysRolePerm = new SysRolePerm();
            sysRolePerm.setRoleId(roleId);
            sysRolePerm.setPermId(permId);
            return sysRolePerm;
        }).toList();
        return sysRolePermService.saveBatch(rolePerms);
    }

    @Override
    public List<SysRole> getRolesByUserId(Long userId) {
        List<SysUserRole> userRoleList = sysUserRoleService.lambdaQuery().eq(SysUserRole::getUserId, userId).list();
        if(CollTool.isNotEmpty(userRoleList)){
            List<Long> roleIds = userRoleList.stream().map(SysUserRole::getRoleId).toList();
            return lambdaQuery().in(SysRole::getId, roleIds).list();
        }
        return List.of();
    }

    @Override
    public List<SysRole> getAllRoles() {
        return list();
    }

    @Override
    public PageDTO<RolePageOutVO> getRolePageData(RolePageQueryVO vo) {
        Page<SysRole> page = lambdaQuery()
                .like(StrTool.isNotBlank(vo.getRoleCode()), SysRole::getRoleCode, vo.getRoleCode())
                .like(StrTool.isNotBlank(vo.getRoleName()), SysRole::getRoleName, vo.getRoleName())
                .page(vo.toMpPageDefaultSortByCreateTimeDesc());
        return PageDTO.of(page,RolePageOutVO.class);
    }
}




