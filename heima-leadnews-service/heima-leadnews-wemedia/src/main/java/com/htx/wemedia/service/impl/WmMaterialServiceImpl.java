package com.htx.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.model.wemedia.pojos.WmMaterial;
import com.htx.wemedia.mapper.WmMaterialMapper;
import com.htx.wemedia.service.IWmMaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:25
 */

@Slf4j
@Service
@Transactional
public class WmMaterialServiceImpl extends ServiceImpl<WmMaterialMapper, WmMaterial> implements IWmMaterialService {
    @Autowired
    private WmMaterialMapper wmMaterialMapper;

    @Override
    public IPage page(IPage page, LambdaQueryWrapper<WmMaterial> lambdaQueryWrapper) {
        return wmMaterialMapper.selectPage(page, lambdaQueryWrapper);
    }

    @Override
    public Boolean insert(WmMaterial entity) {
        if(entity == null){
            return false;
        }
        return wmMaterialMapper.insert(entity) > 0;
    }
}
