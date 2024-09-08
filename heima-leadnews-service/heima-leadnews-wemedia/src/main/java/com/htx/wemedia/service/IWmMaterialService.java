package com.htx.wemedia.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.htx.model.wemedia.pojos.WmMaterial;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:23
 */
public interface IWmMaterialService {
    Boolean insert(WmMaterial wmMaterial);

    IPage page(IPage page, LambdaQueryWrapper<WmMaterial> lambdaQueryWrapper);
}
