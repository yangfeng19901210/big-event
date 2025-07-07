package com.yy.controller;

import com.yy.common.entity.PageDTO;
import com.yy.pojo.Article;
import com.yy.service.ArticleService;
import com.yy.vo.in.AddArticleInVO;
import com.yy.vo.in.UpdateArticleInVO;
import com.yy.vo.out.ArticleDetailOutVO;
import com.yy.vo.query.ArticlePageOutVO;
import com.yy.vo.query.ArticlePageQueryVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/*********************************************************
 ** 文章管理controller
 ** <br><br>
 ** @ClassName: ArticleController
 ** @author: yangfeng
 ** @date: 2025/7/7 9:38
 ** @version: 1.0.0
 *********************************************************/
@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
@Validated
public class ArticleController {

    private final ArticleService articleService;
    /**
     * 发布文章
     * @param
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/7/7 9:41
     **/
    @PostMapping
    public Boolean add(@RequestBody @Valid AddArticleInVO vo){
        return articleService.add(vo);
    }
    /**
     * 更新文章信息
     * @param vo
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/7/7 13:52
     **/
    @PutMapping
    public Boolean update(@RequestBody @Valid UpdateArticleInVO vo){
        return articleService.updateArticle(vo);
    }
    /**
     * 根据文章ID获取文章信息
     * @param id 文章ID
     * @Return: com.yy.pojo.Article
     * @author: yangfeng
     * @date: 2025/7/7 14:06
     **/
    @GetMapping
    public ArticleDetailOutVO getArticleById(Integer id) {
        return articleService.getDetailById(id);
    }
    /**
     * 根据文章id删除文章
     * @param id
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/7/7 14:07
     **/
    @DeleteMapping
    public Boolean delete(Integer id) {
        return articleService.removeById(id);
    }
    /**
     * 分页获取文章列表数据
     * @param vo
     * @Return: com.yy.common.entity.PageDTO<com.yy.vo.query.ArticlePageOutVO>
     * @author: yangfeng
     * @date: 2025/7/7 14:28
     **/
    @PostMapping("/getPageData")
    public PageDTO<ArticlePageOutVO> getPageData(@RequestBody @Valid ArticlePageQueryVO vo){
        return articleService.getPageData(vo);
    }
}
