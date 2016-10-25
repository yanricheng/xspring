package net.yanrc.xpring.web.biz.service;

import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.common.utils.anots.Logable;
import net.yanrc.xpring.dal.entity.Activity;
import net.yanrc.xpring.rpc.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yanricheng on 16-10-13.
 */
@Service
public class ActivityBizService {

    @Autowired
    private ActivityService activityService;

    public Result<Activity> addSelective(Activity activity) {
        return activityService.addSelective(activity);
    }

    public Result<Boolean> remove(Integer id) {
        return activityService.remove(id);
    }

    public Result<Activity> editByIdSelective(Activity activity) {
        return activityService.editByIdSelective(activity);
    }

    @Logable
    public Result<Activity> getById(Integer id) {
        return activityService.getById(id);
    }
}
