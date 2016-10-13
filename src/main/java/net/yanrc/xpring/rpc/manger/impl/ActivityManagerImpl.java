package net.yanrc.xpring.rpc.manger.impl;

import net.yanrc.xpring.dal.entity.Activity;
import net.yanrc.xpring.dal.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yanricheng on 16-10-13.
 */
@Service
public class ActivityManagerImpl implements net.yanrc.xpring.rpc.manger.ActivityManager {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Activity add(Activity activity) {
        if (activityMapper.insert(activity) > 0) {
            activity = activityMapper.selectByPrimaryKey(activity.getId());
            return activity;
        }
        return null;
    }

    @Override
    public Activity addSelective(Activity activity) {
        if (activityMapper.insertSelective(activity) > 0) {
            activity = activityMapper.selectByPrimaryKey(activity.getId());
            return activity;
        }
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        return activityMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Activity editById(Activity activity) {
        if (activityMapper.updateByPrimaryKey(activity) > 0) {
            activity = activityMapper.selectByPrimaryKey(activity.getId());
            return activity;
        }
        return null;
    }

    @Override
    public Activity editByIdSelective(Activity activity) {
        if (activityMapper.updateByPrimaryKeySelective(activity) > 0) {
            activity = activityMapper.selectByPrimaryKey(activity.getId());
            return activity;
        }
        return null;
    }

    @Override
    public Activity getById(Integer id) {
        return activityMapper.selectByPrimaryKey(id);
    }

}
