package net.yanrc.xpring.activity.web.command.activity;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import net.yanrc.app.common.result.PresentResult;
import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.activity.biz.model.ActivityModel;
import net.yanrc.xpring.activity.biz.service.ActivityService;

/**
 * Created by Administrator on 2016/10/30.
 */
public class ActivitGetByIdCommond extends HystrixCommand<Result<ActivityModel>> {
    @Autowired
    private ActivityService activityService;

    private Integer activityId;

    public ActivitGetByIdCommond() {
        // 最少配置:指定命令组名(CommandGroup)
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        System.out.println("新建 ............GetByIdActivityCommond");
    }

    @Override
    protected Result<ActivityModel> run() throws Exception {
        return activityService.getById(activityId);
    }

    @Override
    protected Result<ActivityModel> getFallback() {
        ActivityModel activity = new ActivityModel();
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
