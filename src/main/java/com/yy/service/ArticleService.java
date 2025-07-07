package com.yy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.common.entity.PageDTO;
import com.yy.pojo.Article;
import com.yy.vo.in.AddArticleInVO;
import com.yy.vo.in.UpdateArticleInVO;
import com.yy.vo.out.ArticleDetailOutVO;
import com.yy.vo.query.ArticlePageOutVO;
import com.yy.vo.query.ArticlePageQueryVO;

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
    /**
     * 更新文章信息
     * @param vo
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/7/7 13:53
     **/
    Boolean updateArticle(UpdateArticleInVO vo);
    /**
     * 根据id获取文章详情
     * @param id
     * @Return: com.yy.vo.out.ArticleDetailOutVO
     * @author: yangfeng
     * @date: 2025/7/7 14:12
     **/
    ArticleDetailOutVO getDetailById(Integer id);
    /**
     * 分页获取文章列表
     * @param vo
     * @Return: com.yy.common.entity.PageDTO<com.yy.vo.query.ArticlePageOutVO>
     * @author: yangfeng
     * @date: 2025/7/7 14:29
     **/
    PageDTO<ArticlePageOutVO> getPageData(ArticlePageQueryVO vo);
}
