package net.yanrc.xpring.activity.biz.manger.impl;

import java.util.List;

import net.yanrc.xpring.activity.biz.manger.ActivityManager;
import net.yanrc.xpring.activity.common.utils.anots.Logable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import net.yanrc.xpring.activity.domain.Activity;
import net.yanrc.xpring.activity.dal.mapper.ActivityMapper;

/**
 * Created by yanricheng on 16-10-13.
 */
@Service
public class ActivityManagerImpl implements ActivityManager {
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

    @CacheEvict(value = "default", key = "T(java.lang.String).valueOf(#p0)")
    @Override
    public boolean remove(Integer id) {
        if (id == null || id.intValue() <= 0) {
            return false;
        }
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

    @Cacheable(value = "activity", key = "T(net.yanrc.xpring.activity.biz.Constants).ALL")
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
