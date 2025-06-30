package com.yy.vo.in;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

/*********************************************************
 ** 更新用户密码
 ** <br><br>
 ** @ClassName: UpdatePwdInVO
 ** @author: yangfeng
 ** @date: 2025/6/30 9:32
 ** @version: 1.0.0
 *********************************************************/
@Data
public class UpdatePwdInVO implements Serializable {
    /**
     * 原密码
     */
    @NotBlank(message = "原密码不可为空")
    @Size(min = 5, max = 16, message = "原始密码长度需在5~16字符之间")
    private String oldPwd;
    /**
     * 新密码
     */
    @NotBlank(message = "新密码不可为空")
    @Size(min = 5, max = 16, message = "新密码长度需在5~16字符之间")
    private String newPwd;
    /**
     * 确认新密码
     */
    @NotBlank(message = "确认新密码不可为空")
    @Size(min = 5, max = 16, message = "确认新密码长度需在5~16字符之间")
    private String rePwd;
}
