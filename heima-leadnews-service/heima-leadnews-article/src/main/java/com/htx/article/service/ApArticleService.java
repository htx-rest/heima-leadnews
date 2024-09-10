package com.htx.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.model.article.dtos.ArticleDto;
import com.htx.model.article.dtos.ArticleHomeDto;
import com.htx.model.article.dtos.ArticleInfoDto;
import com.htx.model.article.pojos.ApArticle;
import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.mess.ArticleVisitStreamMess;

public interface ApArticleService extends IService<ApArticle> {

    /**
     * 根据参数加载文章列表
     * @param loadtype 1为加载更多  2为加载最新
     * @param dto
     * @return
     */
    ResponseResult load(Short loadtype, ArticleHomeDto dto);

    /**
     * 加载文章列表
     * @param dto
     * @param type  1 加载更多   2 加载最新
     * @param firstPage  true  是首页  flase 非首页
     * @return
     */
    public ResponseResult load2(ArticleHomeDto dto,Short type,boolean firstPage);

    /**
     * 保存app端相关文章
     * @param dto
     * @return
     */
    ResponseResult saveArticle(ArticleDto dto) ;

    /**
     * 加载文章详情 数据回显
     * @param dto
     * @return
     */
    ResponseResult loadArticleBehavior(ArticleInfoDto dto);

    /**
     * 更新文章的分值  同时更新缓存中的热点文章数据
     * @param mess
     */
    void updateScore(ArticleVisitStreamMess mess);

}