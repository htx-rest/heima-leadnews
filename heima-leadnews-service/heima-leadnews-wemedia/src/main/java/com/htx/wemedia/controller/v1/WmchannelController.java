package com.htx.wemedia.controller.v1;

import com.htx.model.common.dtos.ResponseResult;
import com.htx.wemedia.manager.WmchannelManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:10
 */

@RestController
@RequestMapping("/api/v1/channel")
public class WmchannelController {
    @Autowired
    private WmchannelManager wmchannelManager;

    @GetMapping("/channels")
    public ResponseResult findAll(){
        return wmchannelManager.findAll();
    }
}
