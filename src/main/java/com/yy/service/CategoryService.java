package com.yy.service;

import com.yy.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.vo.in.AddCategoryInVO;
import com.yy.vo.out.CategoryListOutVO;
import jakarta.validation.Valid;

import java.util.List;

/**
* @author yangFeng
* @description 针对表【category】的数据库操作Service
* @createDate 2025-06-07 19:45:47
*/
public interface CategoryService extends IService<Category> {
    /**
     * 新增文章分类
     * @param vo
     * @Return: java.lang.Boolean
     * @author: yangfeng
     * @date: 2025/6/30 11:23
     **/
    Boolean addCategory(@Valid AddCategoryInVO vo);
    /**
     * 分页获取当前用户新增的文章分类列表
     * @param
     * @Return: java.util.List<com.yy.vo.out.CategoryListOutVO>
     * @author: yangfeng
     * @date: 2025/7/1 15:47
     **/
    List<CategoryListOutVO> queryCurrentUserCategory();
}
