package com.yy.common.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 通用的实体类
 */
@Data
public class BaseEntity {
    private Integer createUser;//创建人ID
    private LocalDateTime createTime;//创建时间
        private LocalDateTime updateTime;//更新时间
}
