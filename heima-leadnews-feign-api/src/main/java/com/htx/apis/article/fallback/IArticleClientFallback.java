package com.htx.apis.article.fallback;

import com.htx.apis.article.IArticleClient;
import com.htx.model.article.dtos.ArticleDto;
import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.common.enums.AppHttpCodeEnum;
import org.springframework.stereotype.Component;

@Component
public class IArticleClientFallback implements IArticleClient {
    @Override
    public ResponseResult saveArticle(ArticleDto dto) {
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR,"获取数据失败");
    }
}
