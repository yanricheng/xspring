package net.yanrc.xpring.biz.api.Impl;

import net.yanrc.xpring.biz.api.UserBizApi;
import net.yanrc.xpring.data.dto.UserDto;
import org.springframework.stereotype.Service;

/**
 * UserApiImpl
 *
 * @auther hzyanricheng
 * @create 2016-04-16 10:18
 */
@Service
public class UserBizApiImpl implements UserBizApi {
    @Override
    public boolean save(UserDto userDto){
        System.out.println("保存成功"+userDto.getName());
        return true;
    }
}
