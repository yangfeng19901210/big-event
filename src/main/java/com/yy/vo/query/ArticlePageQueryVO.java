package com.yy.vo.query;

import com.yy.common.entity.PageQuery;
import lombok.Data;

/*********************************************************
 ** 文章列表分页查询参数
 ** <br><br>
 ** @ClassName: ArticlePageQueryVO
 ** @author: yangfeng
 ** @date: 2025/7/7 11:34
 ** @version: 1.0.0
 *********************************************************/
@Data
public class ArticlePageQueryVO extends PageQuery {
    /**
     * 文章分类id
     */
    private Integer categoryId;
    /**
     * 发布状态
     */
    private String state;
}
