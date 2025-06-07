package com.yy.controller;

import com.yy.common.response.Result;
import com.yy.pojo.User;
import com.yy.service.UserService;
import com.yy.utils.JwtUtil;
import com.yy.utils.Md5Util;
import io.gitee.loulan_yxq.owner.core.tool.AssertTool;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    private final StringRedisTemplate stringRedisTemplate;
    /**
     * 用户注册
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$",message = "用户名不合法")String userName, @Pattern(regexp = "^\\S{5,16}$",message = "密码不合法")String password) {
        return Result.success(userService.register(userName,password));
    }
    /**
    * @description 用户登录
    * @author yangfeng
    * @date 2025/6/7 12:15
    * @param username
    * @param password
    * @return java.lang.String
    */
    @PostMapping("/login")
    public String login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        //根据用户名查询用户
        User loginUser = userService.getByUserName(username);
        //判断该用户是否存在
        AssertTool.notNull(loginUser,"用户名错误");
        //判断密码是否正确  loginUser对象中的password是密文
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            //登录成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            //把token存储到redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token,token,1, TimeUnit.HOURS);
            return token;
        }
        return "密码错误";
    }
}
