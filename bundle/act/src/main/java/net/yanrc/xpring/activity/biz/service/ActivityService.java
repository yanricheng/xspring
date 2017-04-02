package net.yanrc.xpring.activity.biz.service;

import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.activity.biz.model.ActivityModel;

/**
 * Created by Administrator on 2016/10/13.
 */
public interface ActivityService {
    Result<ActivityModel> addSelective(ActivityModel activity);

    Result<Boolean> remove(Integer id);

    Result<ActivityModel> editByIdSelective(ActivityModel activity);

    Result<ActivityModel> getById(Integer id);
}
