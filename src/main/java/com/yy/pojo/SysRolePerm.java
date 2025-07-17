package com.yy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName sys_role_perm
 */
@TableName(value ="sys_role_perm")
@Data
public class SysRolePerm {
    /**
     * 权限id
     */
    @TableId
    private Long permId;

    /**
     * 角色id
     */
    @TableId
    private Long roleId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除标识，默认1未删除，已删除设置为主键的值
     */
    private Integer delFlag;
}