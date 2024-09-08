package com.htx.wemedia.manager;

import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.common.enums.AppHttpCodeEnum;
import com.htx.model.wemedia.dtos.WmLoginDto;
import com.htx.model.wemedia.pojos.WmUser;
import com.htx.utils.common.AppJwtUtil;
import com.htx.wemedia.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:07
 */
@Slf4j
@Service
public class LoginManager {
    @Autowired
    private ILoginService loginService;

    public ResponseResult login(WmLoginDto dto) {
        //1.检查参数
        if(StringUtils.isBlank(dto.getName()) || StringUtils.isBlank(dto.getPassword())){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"用户名或密码为空");
        }

        //2.查询用户
        WmUser wmUser = loginService.selectByName(dto.getName());
        if(wmUser == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }

        //3.比对密码
        String salt = wmUser.getSalt();
        String pswd = dto.getPassword();
        pswd = DigestUtils.md5DigestAsHex((pswd + salt).getBytes());
        if(pswd.equals(wmUser.getPassword())){
            //4.返回数据  jwt
            Map<String,Object> map  = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(wmUser.getId().longValue()));
            wmUser.setSalt("");
            wmUser.setPassword("");
            map.put("user",wmUser);
            return ResponseResult.okResult(map);

        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
    }
}
