package com.yy.controller;

import com.yy.service.CategoryService;
import com.yy.vo.in.AddCategoryInVO;
import com.yy.vo.in.UpdateCategoryInVO;
import com.yy.vo.out.CategoryListOutVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    /**
     * 分页获取当前用户新增的文章分类列表
     * @param
     * @Return: java.util.List<com.yy.vo.out.CategoryListOutVO>
     * @author: yangfeng
     * @date: 2025/7/1 15:46
     **/
    @GetMapping
    public List<CategoryListOutVO> queryCurrentUserCategory() {
        return categoryService.queryCurrentUserCategory();
    }
    /**
     * 更新文章分类信息
     * @param vo
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/7/4 16:43
     **/
    @PutMapping
    public Boolean update(@Valid @RequestBody UpdateCategoryInVO vo) {
        return categoryService.updateCategory(vo);

    }
}
