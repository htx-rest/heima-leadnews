package com.htx.wemedia.manager;

import com.htx.model.common.dtos.ResponseResult;
import com.htx.wemedia.service.IWmChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:11
 */
@Slf4j
@Service
public class WmchannelManager {
    @Autowired
    private IWmChannelService wmChannelService;

    public ResponseResult findAll() {
        return wmChannelService.findAll();
    }
}
