package com.htx.wemedia.controller.v1;

import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.wemedia.dtos.WmNewsPageReqDto;
import com.htx.wemedia.manager.WmNewsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:16
 */

@RestController
@RequestMapping("/api/v1/news")
public class WmNewsController {
    @Autowired
    private WmNewsManager wmNewsManager;

    @PostMapping("/list")
    public ResponseResult findList(@RequestBody WmNewsPageReqDto dto){
        return wmNewsManager.findList(dto);
    }

    @PostMapping("/submit")
    public ResponseResult submitNews(@RequestBody WmNewsPageReqDto dto){
        return wmNewsManager.submitNews(dto);
    }
}
