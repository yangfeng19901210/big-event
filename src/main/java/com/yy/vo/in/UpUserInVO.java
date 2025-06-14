package com.yy.vo.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UpUserInVO
 * @Description 更新用户基本信息输入参数
 * @Author yangFeng
 * @Date 2025/6/13 21:39
 * @Version 1.0
 */
@Data
public class UpUserInVO implements Serializable {
    @NotNull(message = "id不可为空")
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    @NotEmpty(message = "昵称不可为空")
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;

    /**
     * 邮箱
     */
    @NotEmpty(message = "邮箱不可为空")
    @Email
    private String email;
}
