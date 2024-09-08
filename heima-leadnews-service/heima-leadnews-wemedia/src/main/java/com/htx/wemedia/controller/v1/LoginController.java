package com.htx.wemedia.controller.v1;

import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.wemedia.dtos.WmLoginDto;
import com.htx.wemedia.manager.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:06
 */

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginManager loginManager;

    @PostMapping("/in")
    public ResponseResult login(@RequestBody WmLoginDto dto){
        return loginManager.login(dto);
    }
}
