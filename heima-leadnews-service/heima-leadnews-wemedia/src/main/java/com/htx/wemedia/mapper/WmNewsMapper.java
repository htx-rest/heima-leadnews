package com.htx.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htx.model.wemedia.pojos.WmNews;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface WmNewsMapper  extends BaseMapper<WmNews> {

    void modifyById(WmNews wmNews);
}
