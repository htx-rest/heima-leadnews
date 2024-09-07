package com.htx.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htx.model.article.dtos.ArticleHomeDto;
import com.htx.model.article.pojos.ApArticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/7 21:39
 */
@Mapper
public interface ApArticleMapper extends BaseMapper<ApArticle> {
    List<ApArticle> loadArticleList(ArticleHomeDto dto, Short loadType);
}
