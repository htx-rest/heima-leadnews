package com.htx.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.model.wemedia.pojos.WmUser;
import com.htx.wemedia.mapper.LoginMapper;
import com.htx.wemedia.service.ILoginService;
import org.springframework.stereotype.Service;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:27
 */

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, WmUser> implements ILoginService {
    @Override
    public WmUser selectByName(String name) {
        if(name == null){
            return null;
        }
        QueryWrapper<WmUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return this.getOne(queryWrapper);
    }
}
