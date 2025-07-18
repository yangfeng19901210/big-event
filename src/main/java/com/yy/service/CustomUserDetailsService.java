package com.yy.service;

import com.yy.mapper.UserMapper;
import com.yy.pojo.CustomUserDetails;
import com.yy.pojo.SysPermission;
import com.yy.pojo.SysRole;
import com.yy.pojo.User;
import io.gitee.loulan_yxq.owner.core.tool.AssertTool;
import jakarta.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: CustomUserDetailsService
 ** @author: yangfeng
 ** @date: 2025/7/17 16:05
 ** @version: 1.0.0
 *********************************************************/
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private SysRoleService sysRoleService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUserDetails(
                "",
                "", // 数据库密码需已加密
                "",
                true,    // 账户启用状态
                null
        );
    }

    private List<GrantedAuthority> getByUserName(String username){
        User user = userService.getByUserName(username);
        AssertTool.notNull(user, "User not found");
        List<GrantedAuthority> authorities = new ArrayList<>();
        //获取权限列表
        List<SysPermission> permissions = userMapper.getPermByUserName(username);
        //获取角色列表
        List<SysRole> roles = sysRoleService.getRolesByUserId(user.getId());
        permissions.forEach(permission -> {
            authorities.add(new SimpleGrantedAuthority(permission.getPermCode()));
        });
        roles.forEach(role -> {

        });
        return authorities;
    }
}
