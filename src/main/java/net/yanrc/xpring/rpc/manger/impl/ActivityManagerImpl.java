package net.yanrc.xpring.rpc.manger.impl;

import net.yanrc.xpring.common.utils.anots.Logable;
import net.yanrc.xpring.dal.entity.Activity;
import net.yanrc.xpring.dal.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yanricheng on 16-10-13.
 */
@Service
public class ActivityManagerImpl implements net.yanrc.xpring.rpc.manger.ActivityManager {
    @Autowired
    private ActivityMapper activityMapper;

    @CachePut(value = "default", key = "#p0.id")
    @Override
    public Activity add(Activity activity) {
        if (activityMapper.insert(activity) > 0) {
            activity = activityMapper.selectByPrimaryKey(activity.getId());
            return activity;
        }
        return null;
    }

    @CachePut(value = "default", key = "#p0.id")
    @Override
    public Activity addSelective(Activity activity) {
        if (activityMapper.insertSelective(activity) > 0) {
            activity = activityMapper.selectByPrimaryKey(activity.getId());
            return activity;
        }
        return null;
    }

    @CacheEvict(value = "default", key = "#p0")
    @Override
    public boolean remove(Integer id) {
        return activityMapper.deleteByPrimaryKey(id) > 0;
    }

    @CachePut(value = "default", key = "#p0.id")
    @Override
    public Activity editById(Activity activity) {
        if (activityMapper.updateByPrimaryKey(activity) > 0) {
            activity = activityMapper.selectByPrimaryKey(activity.getId());
            return activity;
        }
        return null;
    }

    @CachePut(value = "default", key = "#p0.id")
    @Override
    public Activity editByIdSelective(Activity activity) {
        if (activityMapper.updateByPrimaryKeySelective(activity) > 0) {
            activity = activityMapper.selectByPrimaryKey(activity.getId());
            return activity;
        }
        return null;
    }

    @Cacheable(value = "activity", key = "#id.toString()")
    @Override
    public Activity getById(Integer id) {
        return activityMapper.selectByPrimaryKey(id);
    }


    @Cacheable(value = "activity", key = "T(net.yanrc.xpring.rpc.Constants).ALL")
    @Override
    public List<Activity> getAll() {
        return activityMapper.selectAll();
    }

    @Logable()
    @Cacheable(value = "act", key = "#id.toString()")
    @Override
    public Activity getActById(Integer id) {
        return activityMapper.selectByPrimaryKey(id);
    }

}
