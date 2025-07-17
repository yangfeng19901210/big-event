package com.yy.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import com.yy.common.entity.BaseEntity;
import lombok.Data;

/**
 * 角色信息表
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
public class SysRole extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 删除标识，默认-1未删除，删除后将该字段的值设置为主键值
     */
    @TableLogic(value = "-1",delval = "id")
    private Integer delFlag;
}