package com.yy.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import com.yy.common.entity.BaseEntity;
import lombok.Data;

/**
 * 
 * @TableName sys_role_perm
 */
@TableName(value ="sys_role_perm")
@Data
public class SysRolePerm extends BaseEntity {
    /**
     * 权限id
     */
    @TableId(type = IdType.NONE)
    private Long permId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 删除标识，默认1未删除，已删除设置为主键的值
     */
    @TableLogic(value = "-1",delval = "null")
    private Integer delFlag;
}