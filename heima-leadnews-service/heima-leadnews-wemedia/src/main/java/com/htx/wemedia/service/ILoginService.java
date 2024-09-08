package com.htx.wemedia.service;

import com.htx.model.wemedia.pojos.WmUser;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:24
 */
public interface ILoginService {
    WmUser selectByName(String name);
}
