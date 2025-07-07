package com.yy.controller;

import com.yy.service.ArticleService;
import com.yy.vo.in.AddArticleInVO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Boolean add(@RequestBody AddArticleInVO vo){
        return articleService.add(vo);
    }
}
