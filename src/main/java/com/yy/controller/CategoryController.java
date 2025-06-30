package com.yy.controller;

import com.yy.service.CategoryService;
import com.yy.vo.in.AddCategoryInVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************************************
 ** 文章分类controller
 ** <br><br>
 ** @ClassName: CategoryController
 ** @author: yangfeng
 ** @date: 2025/6/30 11:09
 ** @version: 1.0.0
 *********************************************************/
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@Validated
public class CategoryController {
    private final CategoryService categoryService;
    /**
     * 新增文章分类
     * @param vo
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/6/30 11:22
     **/
    @PostMapping
    public Boolean addCategory(@Valid @RequestBody AddCategoryInVO vo){
        return categoryService.addCategory(vo);
    }
}
