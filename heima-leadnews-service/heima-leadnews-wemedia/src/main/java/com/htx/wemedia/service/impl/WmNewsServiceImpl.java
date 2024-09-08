package com.htx.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.model.wemedia.pojos.WmMaterial;
import com.htx.model.wemedia.pojos.WmNews;
import com.htx.model.wemedia.pojos.WmNewsMaterial;
import com.htx.wemedia.mapper.WmMaterialMapper;
import com.htx.wemedia.mapper.WmNewsMapper;
import com.htx.wemedia.mapper.WmNewsMaterialMapper;
import com.htx.wemedia.service.IWmNewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:26
 */

@Service
@Slf4j
@Transactional
public class WmNewsServiceImpl extends ServiceImpl<WmNewsMapper, WmNews> implements IWmNewsService {
    @Autowired
    private WmNewsMapper wmNewsMapper;

    @Autowired
    private WmMaterialMapper wmMaterialMapper;

    @Autowired
    private WmNewsMaterialMapper wmNewsMaterialMapper;

    @Override
    public IPage page(IPage page, LambdaQueryWrapper<WmNews> lambdaQueryWrapper) {
        return wmNewsMapper.selectMapsPage(page, lambdaQueryWrapper);
    }

    @Override
    public List<WmMaterial> selectList(LambdaQueryWrapper<WmMaterial> in) {
        return wmMaterialMapper.selectList(in);
    }

    @Override
    public void saveRelations(List<Integer> idList, Integer newsId, Short type) {
        wmNewsMaterialMapper.saveRelations(idList, newsId, type);
    }

    @Override
    public void insert(WmNews wmNews) {
        wmNewsMapper.insert(wmNews);
    }

    @Override
    public void delete(LambdaQueryWrapper<WmNewsMaterial> eq) {
        wmNewsMaterialMapper.delete(eq);
    }

    @Override
    public void modifyById(WmNews wmNews) {
        wmNewsMapper.modifyById(wmNews);
    }
}
