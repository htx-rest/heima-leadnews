package com.htx.behavior.service;

import com.htx.model.behavior.dtos.LikesBehaviorDto;
import com.htx.model.common.dtos.ResponseResult;

public interface ApLikesBehaviorService {

    /**
     * 存储喜欢数据
     * @param dto
     * @return
     */
    public ResponseResult like(LikesBehaviorDto dto);
}
