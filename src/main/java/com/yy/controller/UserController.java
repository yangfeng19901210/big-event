package com.yy.controller;

import com.yy.pojo.Result;
import com.yy.service.UserService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;
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
}
