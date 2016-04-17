package net.yanrc.xpring.biz.api;

import net.yanrc.xpring.data.dto.UserDto;

/**
 * User 本地接口
 *
 * @auther hzyanricheng
 * @create 2016-04-16 10:15
 */
public interface UserBizApi {
    boolean save(UserDto userDto);
}