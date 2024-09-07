package com.htx.user.controller.v1;

import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.user.dtos.LoginDto;
import com.htx.user.manager.ApUserLoginMangaer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/7 14:27
 */
@RestController
@RequestMapping("/api/v1/login")
@Api(value = "app端用户登录",tags = "app端用户登录")
public class ApUserLoginController {

    @Autowired
    private ApUserLoginMangaer apUserLoginMangaer;

    @PostMapping("/login_auth")
    @ApiOperation("用户登录")
    public ResponseResult login(@RequestBody LoginDto dto){
        return apUserLoginMangaer.login(dto);
    }
}
