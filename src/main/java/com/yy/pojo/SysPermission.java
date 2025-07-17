package com.yy.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import com.yy.common.entity.BaseEntity;
import lombok.Data;

/**
 * 
 * @TableName sys_permission
 */
@TableName(value ="sys_permission")
@Data
public class SysPermission extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 权限code
     */
    private String permCode;

    /**
     * 权限名称
     */
    private String permName;

    /**
     * 删除标识，默认1未删除，删除后设置为主键的值
     */
    @TableLogic(value = "-1",delval = "id")
    private Long delFlag;

    /**
     * 请求路径如 '/api/users
     */
    private String urlPattern;

    /**
     * 请求方式GET,POST...
     */
    private String httpMethod;
}