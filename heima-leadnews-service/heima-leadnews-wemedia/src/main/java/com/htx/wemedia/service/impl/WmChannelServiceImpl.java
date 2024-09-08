package com.htx.wemedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.wemedia.pojos.WmChannel;
import com.htx.wemedia.mapper.WmChannelMapper;
import com.htx.wemedia.service.IWmChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:25
 */

@Service
@Transactional
@Slf4j
public class WmChannelServiceImpl extends ServiceImpl<WmChannelMapper, WmChannel> implements IWmChannelService {
    @Override
    public ResponseResult findAll() {
        return ResponseResult.okResult(this.list());
    }
}
