package com.htx.search.service;

import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.search.dtos.UserSearchDto;

public interface ApAssociateWordsService {

    /**
     * 搜索联想词
     * @param dto
     * @return
     */
    public ResponseResult search(UserSearchDto dto);
}
