package com.htx.behavior.service;

import com.htx.model.behavior.dtos.ReadBehaviorDto;
import com.htx.model.common.dtos.ResponseResult;

public interface ApReadBehaviorService {

    /**
     * 保存阅读行为
     * @param dto
     * @return
     */
    public ResponseResult readBehavior(ReadBehaviorDto dto);
}
