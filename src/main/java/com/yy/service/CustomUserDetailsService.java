package com.yy.service;

import com.yy.pojo.CustomUserDetails;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
}
