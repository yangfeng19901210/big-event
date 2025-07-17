package com.yy.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import com.yy.common.entity.BaseEntity;
import lombok.Data;

/**
 * 
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Data
public class SysUserRole extends BaseEntity {
    /**
     * 用户id
     */
    @TableId(type = IdType.NONE)
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 删除标识，默认-1未删除，已删除设置为null
     */
    private Integer delFlag;
}