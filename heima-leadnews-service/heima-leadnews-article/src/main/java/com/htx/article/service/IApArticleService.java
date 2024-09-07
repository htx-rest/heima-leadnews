package com.htx.article.service;

import com.htx.model.article.dtos.ArticleHomeDto;
import com.htx.model.article.pojos.ApArticle;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/7 21:38
 */
public interface IApArticleService {
    List<ApArticle> loadArticleList(ArticleHomeDto dto, Short loadType);
}
