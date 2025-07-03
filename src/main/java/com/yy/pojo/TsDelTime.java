package com.yy.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.yy.common.entity.BaseEntity;
import lombok.Data;

/**
 * 
 * @TableName ts_del_time
 */
@TableName(value ="ts_del_time")
@Data
public class TsDelTime extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 删除标识，未删除时未null，删除后记录删除时间
     */
    @TableLogic(value = "-1", delval = "UNIX_TIMESTAMP()")
    private Long deletedAt;
}