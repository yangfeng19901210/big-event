package com.yy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.common.BaseStorage;
import com.yy.pojo.Category;
import com.yy.service.CategoryService;
import com.yy.mapper.CategoryMapper;
import com.yy.vo.in.AddCategoryInVO;
import org.springframework.stereotype.Service;

/**
* @author yangFeng
* @description 针对表【category】的数据库操作Service实现
* @createDate 2025-06-07 19:45:47
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Override
    public Boolean addCategory(AddCategoryInVO vo) {
        Category category = new Category();
        category.setCreateUser(BaseStorage.getUserId());
        category.setCategoryName(vo.getCategoryName());
        category.setCategoryAlias(vo.getCategoryAlias());
        return saveOrUpdate(category);
    }
}




