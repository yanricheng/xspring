package net.yanrc.xpring.web.command.activity;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import net.yanrc.app.common.result.PresentResult;
import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.dal.entity.Activity;
import net.yanrc.xpring.rpc.service.ActivityService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/30.
 */
@Service
public class GetByIdActivityCommond extends HystrixCommand<Result<Activity>> {

    private String commondName;
    private ActivityService activityService;
    private Integer activityId;


    private GetByIdActivityCommond(String name) {
        //最少配置:指定命令组名(CommandGroup)
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.commondName = name;
    }

    public static GetByIdActivityCommond build(ActivityService activityService) {
        GetByIdActivityCommond cmd = new GetByIdActivityCommond("GetByIdCommond");
        cmd.activityService = activityService;
        return cmd;
    }

    public GetByIdActivityCommond activityId(Integer activityId) {
        this.activityId = activityId;
        return this;
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
}
