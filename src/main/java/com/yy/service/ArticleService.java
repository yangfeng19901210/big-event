package com.yy.service;

import com.yy.pojo.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.vo.in.AddArticleInVO;

/**
* @author yangFeng
* @description 针对表【article】的数据库操作Service
* @createDate 2025-06-07 19:45:47
*/
public interface ArticleService extends IService<Article> {
    /**
     * 发布文章
     * @param vo
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/7/7 9:44
     **/
    Boolean add(AddArticleInVO vo);
}
