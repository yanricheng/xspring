package net.yanrc.xpring.web.biz.service;

import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.common.utils.anots.Logable;
import net.yanrc.xpring.dal.entity.Activity;
import net.yanrc.xpring.web.command.CommandFecade;
import net.yanrc.xpring.web.command.activity.ActivitGetByIdCommond;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by yanricheng on 16-10-13.
 */
@Service
public class ActivityBizService {
    public Result<Activity> addSelective(Activity activity) {
        return null;
    }

    public Result<Boolean> remove(Integer id) {
        return null;
    }

    public Result<Activity> editByIdSelective(Activity activity) {
        return null;
    }

    @Logable
    public Result<Activity> getById(Integer id) {

        try {
//            return activitGetByIdCommond.activityId(id).queue().get(1000, TimeUnit.SECONDS);
            return CommandFecade.getCommond(ActivitGetByIdCommond.class).activityId(id).queue().get(1000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}
