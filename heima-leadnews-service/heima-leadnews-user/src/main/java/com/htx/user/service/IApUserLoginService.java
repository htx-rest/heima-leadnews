package com.htx.user.service;

import com.htx.model.user.pojos.ApUser;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/7 14:36
 */
public interface IApUserLoginService {
    ApUser selectByPhone(String phone);
}
