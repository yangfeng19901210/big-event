package com.yy.controller;

import com.yy.common.entity.PageDTO;
import com.yy.common.response.Result;
import com.yy.config.BaseConstant;
import com.yy.pojo.CustomUser;
import com.yy.pojo.User;
import com.yy.service.UserService;
import com.yy.utils.JwtUtil;
import com.yy.vo.in.AddRolesToUserInVO;
import com.yy.vo.in.UpUserInVO;
import com.yy.vo.in.UpdatePwdInVO;
import com.yy.vo.out.UserPageOutVO;
import com.yy.vo.query.UserPageQueryVO;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * 用户controller
 * @ClassName UserController
 * @Author yangfeng
 * @Date 2025/7/30 8:45
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
@Slf4j
public class UserController {
    private final UserService userService;

    private final StringRedisTemplate stringRedisTemplate;
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private JwtUtil jwtUtil;
    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$",message = "用户名不合法")String username, @Pattern(regexp = "^\\S{5,16}$",message = "密码不合法")String password) {
        return Result.success(userService.register(username,password));
    }
    /**
    * @description 用户登录
     * username：dsk001 password：dsk1688..
    * @author yangfeng
    * @date 2025/6/7 12:15
    * @param username
    * @param password
    * @return java.lang.String
    */
    @PostMapping("/login")
    public String login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        log.info("用户登录,用户名{} 密码{}", username,password);
        // 1. 认证用户名密码
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            //将当前用户的安全认证信息（Authentication对象）存储到安全上下文中，供后续授权流程全局调用
            SecurityContextHolder.getContext().setAuthentication(auth);
            CustomUser userDetails = (CustomUser) auth.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();
            String token = jwtUtil.generateToken(userDetails.getUsername(),userDetails.getId(), roles,1000*60*60*24);
            //把token存储到redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            //token放到redis中，过期时间设置为2小时
            operations.set(BaseConstant.USER_TOKEN+username,BaseConstant.TOKEN_PREFIX+token,24, TimeUnit.HOURS);
            return BaseConstant.TOKEN_PREFIX+token;
        } catch (AuthenticationException e) {
            throw e;
        }
    }
    /**
    * @description 获取当前登录用户的详细信息
    * @author yangFeng
    * @date 2025/6/13 21:32
    * @param
    * @return com.yy.pojo.User
    */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/userInfo")
    public User getUserInfo(Authentication authentication){
        CustomUser userDetails = (CustomUser) authentication.getPrincipal();
//        Long userId = BaseStorage.getUserId();
        return userService.getById(userDetails.getId());
    }
    /**
    * @description 更新用户信息
    * @author yangFeng
    * @date 2025/6/13 21:43
    * @param vo
    * @return java.lang.Boolean
    */
    @PutMapping("/update")
    public Boolean update(@RequestBody @Validated UpUserInVO vo){
        return userService.updateUserInfo(vo);
    }
    /**
    * @description 更新用户头像
    * @author yangFeng
    * @date 2025/6/14 12:32
    * @param avatarUrl
    * @return java.lang.Boolean
    */
    @PatchMapping("updateAvatar")
    public Boolean updateAvatar(@RequestParam @URL String avatarUrl) {
        return userService.updateAvatar(avatarUrl);
    }
    /**
     * 更新用户密码
     * @param vo
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/6/30 9:33
     **/
    @PatchMapping("/updatePwd")
    public Boolean updatePwd(@RequestBody @Validated UpdatePwdInVO vo){
        return userService.updatePwd(vo);
    }
    /**
     * 用户退出登录删除redis中的token信息
     * @param authentication
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/7/24 15:53
     **/
    @PostMapping("/logout")
    public Boolean logout(Authentication authentication){
        //删除redis中的token信息
        CustomUser userDetails = (CustomUser) authentication.getPrincipal();
        return stringRedisTemplate.delete(BaseConstant.USER_TOKEN+userDetails.getUsername());
    }
    /**
     * 分页获取用户列表
     * @param vo
     * @Return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.yy.vo.out.UserPageOutVO>
     * @author: yangfeng
     * @date: 2025/7/30 9:00
     **/
    @PostMapping("/getUserPageData")
    public PageDTO<UserPageOutVO> getUserPageData(@RequestBody @Valid UserPageQueryVO vo){
        return userService.getUserPageData(vo);
    }
    /**
     * 给用户设置角色
     * @param vo
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/7/31 10:26
     **/
    @PostMapping("/setRolesToUser")
    public Boolean setRolesToUser(@RequestBody AddRolesToUserInVO vo) {
        return userService.setRolesToUser(vo.getUserId(), vo.getRoleIds());
    }
}
