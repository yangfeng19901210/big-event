package com.yy.pojo;
import com.yy.common.entity.BaseEntity;
import lombok.Data;

@Data
public class Category extends BaseEntity {
    private Integer id;//主键ID
    private String categoryName;//分类名称
    private String categoryAlias;//分类别名
    private Integer createUser;//创建人ID
}
