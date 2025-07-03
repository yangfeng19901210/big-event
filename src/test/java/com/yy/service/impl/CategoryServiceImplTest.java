package com.yy.service.impl;

import com.yy.pojo.Category;
import com.yy.service.CategoryService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryServiceImplTest {
    @Resource
    private CategoryService categoryService;
    @Test
    void add(){
        Category category = new Category();
        category.setCategoryName("test");
        category.setCategoryAlias("test");
        category.setCreateUser(3);
        categoryService.save(category);
    }
    @Test
    void remove(){
        categoryService.removeById(4);
    }

}