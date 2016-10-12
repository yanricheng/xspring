package net.yanrc.xpring.biz.api.Impl;

import net.yanrc.app.common.util.StTimeUtils;
import net.yanrc.xpring.biz.api.UserBizApi;
import net.yanrc.xpring.data.dto.UserQueryDto;
import net.yanrc.xpring.data.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * UserApiImpl
 *
 * @auther hzyanricheng
 * @create 2016-04-16 10:18
 */
@Service
public class UserBizApiImpl implements UserBizApi {
    @Override
    public boolean save(UserQueryDto userQueryDto){
        System.out.println("保存成功"+ userQueryDto.getName());
        return true;
    }

    @Cacheable(value = "default",key = "#id")
    public User getById(Integer id){
        System.out.println("get from db...");
        return null;
    }

    User createUser(){
        User user = new User();
        user.setId(Integer.parseInt(StTimeUtils.formatYYYYMMDD(new Date())));
        user.setName(new Date().toLocaleString());
        return user;
    }

    @Override
    @CachePut(value = "default",key = "#result.id")
    public User add() {
        return createUser();
    }

    @Override
    @CacheEvict(value = "default",key = "#result.id")
    public boolean removeById(Integer id) {
        return false;
    }

    @Override
    @CachePut(value = "default",key = "#result.id")
    public boolean edit(User user) {
        return false;
    }
}
