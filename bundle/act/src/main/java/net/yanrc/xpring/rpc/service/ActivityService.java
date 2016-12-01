package net.yanrc.xpring.rpc.service;

import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.dal.entity.Activity;

/**
 * Created by Administrator on 2016/10/13.
 */
public interface ActivityService {
    Result<Activity> addSelective(Activity activity);
    Result<Boolean> remove(Integer id);
    Result<Activity> editByIdSelective(Activity activity);
    Result<Activity> getById(Integer id);
}
