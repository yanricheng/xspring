package net.yanrc.xpring.rpc.service.impl;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import net.yanrc.app.common.result.DefaultResult;
import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.dal.entity.Activity;
import net.yanrc.xpring.rpc.manger.ActivityManager;
import net.yanrc.xpring.rpc.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return new DefaultResult<>();
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
        return new DefaultResult<>();
    }

    @Transactional(readOnly = true)
    @Override
    public Result<Activity> getById(Integer id) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//          throw new HystrixBadRequestException("exxx");

//        List<Activity> activityList = activityManager.getAll();
        return new DefaultResult<Activity>(activityManager.getActById(id));
    }
}
