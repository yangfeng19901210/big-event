package com.yy.vo.query;

import com.yy.common.entity.PageQuery;
import lombok.Data;

/**
 * 角色分页里列表查询参数
 *
 * @ClassName RolePageQueryVO
 * @Author yangfeng
 * @Date 2025/8/1 9:44
 * @Version 1.0
 */
@Data
public class RolePageQueryVO extends PageQuery {
    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;
}