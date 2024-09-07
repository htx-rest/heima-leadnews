package com.htx.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.model.user.pojos.ApUser;
import com.htx.user.mapper.ApUserMapper;
import com.htx.user.service.IApUserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/7 15:05
 */
@Service
@Transactional
@Slf4j
public class ApUserServiceLoginImpl extends ServiceImpl <ApUserMapper, ApUser> implements IApUserLoginService {
    @Override
    public ApUser selectByPhone(String phone) {
        QueryWrapper<ApUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        return this.getOne(queryWrapper);
    }
}
