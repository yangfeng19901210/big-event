package com.yy.vo.in;

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
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;
}
