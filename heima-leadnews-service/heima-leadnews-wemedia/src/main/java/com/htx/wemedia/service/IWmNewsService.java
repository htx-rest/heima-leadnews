package com.htx.wemedia.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.htx.model.wemedia.pojos.WmMaterial;
import com.htx.model.wemedia.pojos.WmNews;
import com.htx.model.wemedia.pojos.WmNewsMaterial;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:24
 */
public interface IWmNewsService {
    IPage page(IPage page, LambdaQueryWrapper<WmNews> lambdaQueryWrapper);


    List<WmMaterial> selectList(LambdaQueryWrapper<WmMaterial> in);

    void saveRelations(List<Integer> idList, Integer newsId, Short type);

    void insert(WmNews wmNews);

    void delete(LambdaQueryWrapper<WmNewsMaterial> eq);

    void modifyById(WmNews wmNews);
}
