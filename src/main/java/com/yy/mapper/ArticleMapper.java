package com.yy.mapper;

import com.yy.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yangFeng
* @description 针对表【article】的数据库操作Mapper
* @createDate 2025-06-07 19:45:47
* @Entity com.yy.pojo.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}




