package com.yy.vo.out;

import com.yy.common.entity.BaseEntity;
import lombok.Data;

/*********************************************************
 ** 文章详情返回类
 ** <br><br>
 ** @ClassName: ArticleDetailOutVO
 ** @author: yangfeng
 ** @date: 2025/7/7 14:10
 ** @version: 1.0.0
 *********************************************************/
@Data
public class ArticleDetailOutVO extends BaseEntity {
    /**
     * 文章ID
     */
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章封面
     */
    private String coverImg;

    /**
     * 文章状态: 只能是[已发布] 或者 [草稿]
     */
    private String state;

    /**
     * 文章分类ID
     */
    private Integer categoryId;

    /**
     * 创建人ID
     */
    private Integer createUser;
}
