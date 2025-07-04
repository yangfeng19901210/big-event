package com.yy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.common.BaseStorage;
import com.yy.pojo.Category;
import com.yy.service.CategoryService;
import com.yy.mapper.CategoryMapper;
import com.yy.vo.in.AddCategoryInVO;
import com.yy.vo.in.UpdateCategoryInVO;
import com.yy.vo.out.CategoryListOutVO;
import io.gitee.loulan_yxq.owner.core.bean.BeanTool;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<CategoryListOutVO> queryCurrentUserCategory() {
        return BeanTool.copy(lambdaQuery().eq(Category::getCreateUser, BaseStorage.getUserId()).orderByDesc(Category::getCreateTime).list(),CategoryListOutVO.class);
    }

    @Override
    public Boolean updateCategory(UpdateCategoryInVO vo) {
        return updateById(BeanTool.copy(vo, Category.class));
    }
}




