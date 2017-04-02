package net.yanrc.xpring.activity.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.yanrc.app.common.result.DefaultResult;
import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.activity.domain.Activity;
import net.yanrc.xpring.activity.biz.manger.ActivityManager;
import net.yanrc.xpring.activity.biz.model.ActivityModel;
import net.yanrc.xpring.activity.biz.service.ActivityService;

/**
 * Created by Administrator on 2016/10/13.
 */
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityManager activityManager;

    @Override
    public Result<ActivityModel> addSelective(ActivityModel model){
        Activity activityInDb = activityManager.addSelective(Activity.buildFromModel(model));
        if (activityInDb != null) {
            return new DefaultResult<ActivityModel>(activityInDb.buildToModel());
        }
        return new DefaultResult<>();
    }


    @Override
    public Result<Boolean> remove(Integer id) {
        return new DefaultResult<Boolean>(activityManager.remove(id));
    }


    @Override
    public Result<ActivityModel> editByIdSelective(ActivityModel model) {
        Activity activityInDb = activityManager.editByIdSelective(Activity.buildFromModel(model));
        if (activityInDb != null) {
            return new DefaultResult<ActivityModel>(activityInDb.buildToModel());
        }
        return new DefaultResult<>();
    }

    @Transactional(readOnly = true)
    @Override
    public Result<ActivityModel> getById(Integer id) {
        // try {
        // Thread.sleep(1500);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        // throw new HystrixBadRequestException("exxx");

        // List<Activity> activityList = activityManager.getAll();
        return new DefaultResult<ActivityModel>(activityManager.getActById(id).buildToModel());
    }
}
