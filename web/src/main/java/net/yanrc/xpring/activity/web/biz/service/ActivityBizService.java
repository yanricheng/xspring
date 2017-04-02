package net.yanrc.xpring.activity.web.biz.service;

import net.yanrc.xpring.activity.biz.model.ActivityModel;
import net.yanrc.xpring.activity.biz.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.yanrc.app.common.result.Result;

/**
 * Created by yanricheng on 16-10-13.
 */
@Service
public class ActivityBizService {

    @Autowired
    private ActivityService activityService;

    public Result<ActivityModel> addSelective(ActivityModel activity) {
        return null;
    }

    public Result<Boolean> remove(Integer id) {
        return null;
    }

    public Result<ActivityModel> editByIdSelective(ActivityModel activity) {
        return null;
    }

    // @Logable
    public Result<ActivityModel> getById(Integer id) {

        return activityService.getById(id);

        // try {
        //// return activitGetByIdCommond.activityId(id).queue().get(1000,
        // TimeUnit.SECONDS);
        //// return
        // CommandFecade.getCommond(ActivitGetByIdCommond.class).activityId(id).queue().get(1000,
        // TimeUnit.SECONDS);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // } catch (ExecutionException e) {
        // e.printStackTrace();
        // } catch (TimeoutException e) {
        // e.printStackTrace();
        // }
        // return null;
    }
}
