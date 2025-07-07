package com.yy.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.common.entity.PageDTO;
import com.yy.pojo.Article;
import com.yy.service.ArticleService;
import com.yy.vo.query.ArticlePageQueryVO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleServiceImplTest {
    @Resource
    private ArticleService articleService;
    @Test
    void queryPageData(){
        ArticlePageQueryVO vo = new ArticlePageQueryVO();
        vo.setPageNo(1L);
        vo.setPageSize(2L);
        Page<Article> page = vo.toMpPageDefaultSortByCreateTimeDesc();
        articleService.page(page);
        System.out.println(PageDTO.of(page, Article.class));

    }

}