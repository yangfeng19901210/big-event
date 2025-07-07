package com.yy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.common.BaseStorage;
import com.yy.common.entity.PageDTO;
import com.yy.pojo.Article;
import com.yy.service.ArticleService;
import com.yy.mapper.ArticleMapper;
import com.yy.vo.in.AddArticleInVO;
import com.yy.vo.in.UpdateArticleInVO;
import com.yy.vo.out.ArticleDetailOutVO;
import com.yy.vo.query.ArticlePageOutVO;
import com.yy.vo.query.ArticlePageQueryVO;
import io.gitee.loulan_yxq.owner.core.bean.BeanTool;
import io.gitee.loulan_yxq.owner.core.tool.AssertTool;
import io.gitee.loulan_yxq.owner.core.tool.ObjectTool;
import org.springframework.stereotype.Service;

/**
* @author yangFeng
* @description 针对表【article】的数据库操作Service实现
* @createDate 2025-06-07 19:45:47
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

    @Override
    public Boolean add(AddArticleInVO vo) {
        Article article = BeanTool.copy(vo, Article.class);
        //设置创建人为当前登录用户
        article.setCreateUser(BaseStorage.getUserId());
        return save(article);
    }

    @Override
    public Boolean updateArticle(UpdateArticleInVO vo) {
        Article article = BeanTool.copy(vo, Article.class);
        return updateById(article);
    }

    @Override
    public ArticleDetailOutVO getDetailById(Integer id) {
        Article article = getById(id);
        AssertTool.notNull(article,"文章不存在");
        return BeanTool.copy(article, ArticleDetailOutVO.class);
    }

    @Override
    public PageDTO<ArticlePageOutVO> getPageData(ArticlePageQueryVO vo) {
        Page<Article> page = vo.toMpPageDefaultSortByCreateTimeDesc();
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ObjectTool.isNotNull(vo.getCategoryId()),Article::getCategoryId,vo.getCategoryId())
                .eq(ObjectTool.isNotNull(vo.getState()),Article::getState,vo.getState());
        page(page, queryWrapper);
        return PageDTO.of(page, ArticlePageOutVO.class);
    }
}




