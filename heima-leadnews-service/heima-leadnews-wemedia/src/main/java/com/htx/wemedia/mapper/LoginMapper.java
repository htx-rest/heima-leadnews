package com.htx.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htx.model.wemedia.pojos.WmUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<WmUser> {
}