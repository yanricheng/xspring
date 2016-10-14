package net.yanrc.xpring.rpc.service.impl;

import net.yanrc.app.common.result.DefaultResult;
import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.dal.entity.Activity;
import net.yanrc.xpring.rpc.exception.MessageEnum;
import net.yanrc.xpring.rpc.manger.ActivityManager;
import net.yanrc.xpring.rpc.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/13.
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityManager activityManager;

    @Override
    public Result<Activity> addSelective(Activity activity) {
        Activity activityInDb = activityManager.addSelective(activity);
        if (activityInDb != null) {
            return new DefaultResult<Activity>(activityInDb);
        }
        return new DefaultResult<>(MessageEnum.db_error.message());
    }

    @Override
    public Result<Boolean> remove(Integer id) {
        return new DefaultResult<Boolean>(activityManager.remove(id));
    }


    @Override
    public Result<Activity> editByIdSelective(Activity activity) {
        Activity activityInDb = activityManager.editByIdSelective(activity);
        if (activityInDb != null) {
            return new DefaultResult<Activity>(activityInDb);
        }
        return new DefaultResult<>(MessageEnum.db_error.message());
    }

    @Override
    public Result<Activity> getById(Integer id) {
        activityManager.getById(id);
        return new DefaultResult<Activity>(activityManager.getActById(id));
    }
}
