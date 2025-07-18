package com.yy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.pojo.SysRole;
import com.yy.pojo.SysRolePerm;
import com.yy.service.SysRolePermService;
import com.yy.service.SysRoleService;
import com.yy.mapper.SysRoleMapper;
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
}




