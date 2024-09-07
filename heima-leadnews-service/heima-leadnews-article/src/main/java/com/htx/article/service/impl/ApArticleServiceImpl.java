package com.htx.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.article.mapper.ApArticleMapper;
import com.htx.article.service.IApArticleService;
import com.htx.model.article.dtos.ArticleHomeDto;
import com.htx.model.article.pojos.ApArticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/7 21:39
 */
@Service
@Transactional
@Slf4j
public class ApArticleServiceImpl extends ServiceImpl<ApArticleMapper, ApArticle> implements IApArticleService {

    @Autowired
    private ApArticleMapper apArticleMapper;

    @Override
    public List<ApArticle> loadArticleList(ArticleHomeDto dto, Short loadType) {
        return apArticleMapper.loadArticleList(dto,loadType);
    }
}
