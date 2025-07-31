package com.yy.vo.in;

import lombok.Data;

import java.util.List;

/**
 * 用户设置角色请求参数
 *
 * @ClassName AddRolesToUserInVO
 * @Author yangfeng
 * @Date 2025/7/31 10:20
 * @Version 1.0
 */
@Data
public class AddRolesToUserInVO {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 角色id集合
     */
    private List<Long> roleIds;
}