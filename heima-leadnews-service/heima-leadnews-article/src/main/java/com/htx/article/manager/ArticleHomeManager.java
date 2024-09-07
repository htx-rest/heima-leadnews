package com.htx.article.manager;

import com.htx.article.service.IApArticleService;
import com.htx.common.constants.ArticleConstants;
import com.htx.model.article.dtos.ArticleHomeDto;
import com.htx.model.common.dtos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/7 21:35
 */
@Slf4j
@Service
public class ArticleHomeManager {

    // 单页最大加载的数字
    private final static short MAX_PAGE_SIZE = 50;

    @Autowired
    private IApArticleService articleService;

    public ResponseResult load(Short loadType, ArticleHomeDto dto) {
        //1.校验参数
        Integer size = dto.getSize();
        if(size == null || size == 0){
            size = 10;
        }

        size = Math.min(size,MAX_PAGE_SIZE);
        dto.setSize(size);

        //类型参数检验
        if(!loadType.equals(ArticleConstants.LOADTYPE_LOAD_MORE) && !loadType.equals(ArticleConstants.LOADTYPE_LOAD_NEW)){
            loadType = ArticleConstants.LOADTYPE_LOAD_MORE;
        }

        //文章频道校验
        if(StringUtils.isEmpty(dto.getTag())){
            dto.setTag(ArticleConstants.DEFAULT_TAG);
        }

        //时间校验
        if(dto.getMaxBehotTime() == null) dto.setMaxBehotTime(new Date());
        if(dto.getMinBehotTime() == null) dto.setMinBehotTime(new Date());

        return ResponseResult.okResult(articleService.loadArticleList(dto, loadType));
    }
}
