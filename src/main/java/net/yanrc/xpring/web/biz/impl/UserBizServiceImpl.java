package net.yanrc.xpring.web.biz.impl;

import net.yanrc.app.common.util.StTimeUtils;
import net.yanrc.xpring.web.biz.UserBizService;
import net.yanrc.xpring.rpc.dto.query.UserQueryDto;
import net.yanrc.xpring.rpc.model.UserModel;
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
public class UserBizServiceImpl implements UserBizService {
    @Override
    public boolean save(UserQueryDto userQueryDto){
        System.out.println("保存成功"+ userQueryDto.getName());
        return true;
    }

    @Cacheable(value = "default",key = "#id")
    public UserModel getById(Integer id){
        System.out.println("get from db...");
        return null;
    }

    UserModel createUser(){
        UserModel user = new UserModel();
        user.setId(Integer.parseInt(StTimeUtils.formatYYYYMMDD(new Date())));
        user.setName(new Date().toLocaleString());
        return user;
    }

    @Override
    @CachePut(value = "default",key = "#result.id")
    public UserModel add() {
        return createUser();
    }

    @Override
    @CacheEvict(value = "default",key = "#result.id")
    public boolean removeById(Integer id) {
        return false;
    }

    @Override
    @CachePut(value = "default",key = "#result.id")
    public boolean edit(UserModel user) {
        return false;
    }
}
