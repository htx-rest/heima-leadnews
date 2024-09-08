package com.htx.wemedia.controller.v1;

import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.wemedia.dtos.WmMaterialDto;
import com.htx.wemedia.manager.WmMaterialManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:13
 */

@RestController
@RequestMapping("/api/v1/material")
public class WmMaterialController {
    @Autowired
    private WmMaterialManager wmMaterialManager;

    @PostMapping("/upload_picture")
    public ResponseResult uploadPicture(MultipartFile file){
        return wmMaterialManager.uploadPicture(file);
    }

    @PostMapping("/list")
    public ResponseResult findList(@RequestBody WmMaterialDto dto){
        return wmMaterialManager.findList(dto);
    }
}
