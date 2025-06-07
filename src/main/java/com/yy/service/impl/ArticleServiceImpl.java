package com.yy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.pojo.Article;
import com.yy.service.ArticleService;
import com.yy.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author yangFeng
* @description 针对表【article】的数据库操作Service实现
* @createDate 2025-06-07 19:45:47
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

}




