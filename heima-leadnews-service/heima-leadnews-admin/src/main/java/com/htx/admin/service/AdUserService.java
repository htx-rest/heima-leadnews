package com.htx.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.model.admin.dtos.AdUserDto;
import com.htx.model.admin.pojos.AdUser;
import com.htx.model.common.dtos.ResponseResult;

public interface AdUserService extends IService<AdUser> {

    /**
     * 登录
     * @param dto
     * @return
     */
    public ResponseResult login(AdUserDto dto);
}
