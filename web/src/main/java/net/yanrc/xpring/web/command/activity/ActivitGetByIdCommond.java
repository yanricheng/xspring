package net.yanrc.xpring.web.command.activity;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import net.yanrc.app.common.result.PresentResult;
import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.dal.domain.Activity;
import net.yanrc.xpring.rpc.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/10/30.
 */
public class ActivitGetByIdCommond extends HystrixCommand<Result<Activity>> {
    @Autowired
    private ActivityService activityService;
    private Integer activityId;


    public ActivitGetByIdCommond() {
        //最少配置:指定命令组名(CommandGroup)
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        System.out.println("新建 ............GetByIdActivityCommond");
    }

    @Override
    protected Result<Activity> run() throws Exception {
        return activityService.getById(activityId);
    }

    @Override
    protected Result<Activity> getFallback() {
        Activity activity = new Activity();
        activity.setName("yanricheng");
        return PresentResult.fromNullable(activity);
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    public ActivitGetByIdCommond activityId(Integer activityId) {
        this.activityId = activityId;
        return this;
    }
}
