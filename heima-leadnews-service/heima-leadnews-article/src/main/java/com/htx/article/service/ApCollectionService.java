package com.htx.article.service;

import com.htx.model.article.dtos.CollectionBehaviorDto;
import com.htx.model.common.dtos.ResponseResult;

public interface ApCollectionService {

    /**
     * 收藏
     * @param dto
     * @return
     */
    public ResponseResult collection(CollectionBehaviorDto dto);
}
