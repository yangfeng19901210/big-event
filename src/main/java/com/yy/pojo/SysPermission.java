package com.yy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName sys_permission
 */
@TableName(value ="sys_permission")
@Data
public class SysPermission {
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
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除标识，默认1未删除，删除后设置为主键的值
     */
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