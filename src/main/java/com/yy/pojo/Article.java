package com.yy.pojo;


import com.yy.common.entity.BaseEntity;
import lombok.Data;

@Data
public class Article extends BaseEntity {
    private Integer id;//主键ID
    private String title;//文章标题
    private String content;//文章内容
    private String coverImg;//封面图像
    private String state;//发布状态 已发布|草稿
    private Integer categoryId;//文章分类id

}
