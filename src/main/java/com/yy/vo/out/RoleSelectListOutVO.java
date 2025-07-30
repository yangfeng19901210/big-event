package com.yy.vo.out;

import lombok.Data;

/**
 * 角色选择列表返回参数
 * @ClassName RoleSelectListOutVO
 * @Author yangfeng
 * @Date 2025/7/30 15:01
 * @Version 1.0
 */
@Data
public class RoleSelectListOutVO {
    /**
     * 角色id
     */
    private Long id;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;
}