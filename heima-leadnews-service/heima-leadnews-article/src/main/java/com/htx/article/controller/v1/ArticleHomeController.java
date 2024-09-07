package com.htx.article.controller.v1;

import com.htx.article.manager.ArticleHomeManager;
import com.htx.common.constants.ArticleConstants;
import com.htx.model.article.dtos.ArticleHomeDto;
import com.htx.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/7 21:29
 */
@RestController
@RequestMapping("/api/v1/article")
public class ArticleHomeController {
    @Autowired
    private ArticleHomeManager articleHomeManager;

    @PostMapping("/load")
    public ResponseResult load(@RequestBody ArticleHomeDto dto){
        return articleHomeManager.load(ArticleConstants.LOADTYPE_LOAD_MORE,dto);
    }

    @PostMapping("/loadmore")
    public ResponseResult loadMore(@RequestBody ArticleHomeDto dto){
        return articleHomeManager.load(ArticleConstants.LOADTYPE_LOAD_MORE, dto);
    }

    @PostMapping("/loadnew")
    public ResponseResult loadNew(@RequestBody ArticleHomeDto dto) {
        return articleHomeManager.load(ArticleConstants.LOADTYPE_LOAD_NEW, dto);
    }
}
