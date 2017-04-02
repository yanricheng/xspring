package net.yanrc.xpring.activity.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.yanrc.app.common.api.ApiResponse;
import net.yanrc.app.common.api.HeadEnum;
import net.yanrc.app.common.result.Result;
import net.yanrc.app.common.util.JsonUtils;
import net.yanrc.xpring.activity.biz.model.ActivityModel;
import net.yanrc.xpring.activity.biz.service.ActivityService;
import net.yanrc.xpring.activity.common.utils.anots.Logable;
import net.yanrc.xpring.activity.dal.mapper.ActivityMapper;
import net.yanrc.xpring.activity.domain.Activity;

/**
 * ActivityControllor
 *
 * @auther hzyanricheng
 * @create 2016-04-16 10:26
 */
@Controller
public class ActivityControllor {
    private static final Logger logger = LoggerFactory.getLogger(ActivityControllor.class);
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityMapper activityMapper;

    @RequestMapping(value = "/act/add", method = RequestMethod.GET)
    @ResponseBody
    public String add(@RequestParam(required = true, name = "id") int id) {
        Result<ActivityModel> activityResult = activityService.getById(id);
        if (activityResult.isSuccess()) {
            ActivityModel activity = activityResult.getModel();
            activity.setName(activity.getName() + new Date().toLocaleString());
            Result<ActivityModel> newActivityResult = activityService.editByIdSelective(activity);
            if (newActivityResult.isSuccess()) {
                return JsonUtils.fromObject(new ApiResponse<ActivityModel>(newActivityResult));
            }
            logger.warn("ActivityControllor.add fail,op result:{}", JsonUtils.fromObject(newActivityResult));
        }
        return JsonUtils.fromObject(new ApiResponse<Activity>(HeadEnum.SERVER_ERROR.newHead()));
    }

    @RequestMapping(value = "/act/del", method = RequestMethod.GET /*
                                                                    * headers =
                                                                    * "Accept=text/plain"
                                                                    */)
    @ResponseBody
    public ApiResponse removeNotSafe(@RequestParam(required = true, name = "id") String id, HttpServletRequest request,
            HttpServletResponse response) {
        Integer nEffectedRow = activityMapper.deleteByPrimaryKeyNotSafe(id);
        return new ApiResponse<Integer>(HeadEnum.SUCCEED.newHead(), nEffectedRow);
    }

    @RequestMapping(value = "/act/remove", method = RequestMethod.GET, headers = "Accept=text/plain")
    @ResponseBody
    public ApiResponse remove(@RequestParam(required = true, name = "id") String id, HttpServletRequest request,
            HttpServletResponse response) {
        if (StringUtils.isBlank(id)) {
            return new ApiResponse<Boolean>(HeadEnum.PARAMETER_BLANK.newHead());
        }

        if (!StringUtils.isNumeric(id)) {
            return new ApiResponse<Boolean>(HeadEnum.PARAMETER_ILLEAGAL.newHead());
        }

        Result<Boolean> activityResult = activityService.remove(Long.valueOf(id).intValue());
        if (activityResult.isSuccess()) {
            return new ApiResponse<Boolean>(activityResult);
        }

        logger.warn("ActivityControllor.remove fail,op result:{}", JsonUtils.fromObject(activityResult));
        return new ApiResponse<Activity>(HeadEnum.SERVER_ERROR.newHead());
    }

    @RequestMapping(value = "/simple/revisited", method = RequestMethod.GET)
    public @ResponseBody String simple() {
        return "Hello world revisited!";
    }

    @RequestMapping(value = "/act/delete", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse delete(@RequestParam(required = true, name = "id") String id, HttpServletRequest request,
            HttpServletResponse response) {
        if (StringUtils.isBlank(id)) {
            return new ApiResponse<Boolean>(HeadEnum.PARAMETER_BLANK.newHead());
        }

        if (!StringUtils.isNumeric(id)) {
            return new ApiResponse<Boolean>(HeadEnum.PARAMETER_ILLEAGAL.newHead());
        }

        Result<Boolean> activityResult = activityService.remove(Long.valueOf(id).intValue());
        if (activityResult.isSuccess()) {
            return new ApiResponse<Boolean>(activityResult);
        }

        logger.warn("ActivityControllor.remove fail,op result:{}", JsonUtils.fromObject(activityResult));
        return new ApiResponse<Activity>(HeadEnum.SERVER_ERROR.newHead());
    }

    @RequestMapping(value = "/act/edit", method = RequestMethod.GET)
    @ResponseBody
    public String edit(@RequestParam(required = true, name = "id") int id) {
        ActivityModel activity = new ActivityModel();
        activity.setId(id);
        activity.setName(new Date().toLocaleString());
        Result<ActivityModel> newActivityResult = activityService.editByIdSelective(activity);
        if (newActivityResult.isSuccess()) {
            return JsonUtils.fromObject(new ApiResponse<ActivityModel>(newActivityResult));
        }

        logger.warn("ActivityControllor.edit fail,op result:{}", JsonUtils.fromObject(newActivityResult));
        return JsonUtils.fromObject(new ApiResponse<Activity>(HeadEnum.SERVER_ERROR.newHead()));
    }

    @Logable(start = true, end = false)
    @RequestMapping(value = "/act/get", method = RequestMethod.GET)
    @ResponseBody
    public String get(@RequestParam(required = true, name = "id") int id,
            @RequestParam(required = false, name = "name") String name, HttpServletRequest request)
            throws UnsupportedEncodingException {
        // String str= new
        // String(request.getParameter("name").toString().getBytes("iso8859_1"),
        // "UTF-8");
        Result<ActivityModel> activityResult = activityService.getById(id);
        if (activityResult.isSuccess()) {
            return JsonUtils.fromObject(new ApiResponse<ActivityModel>(activityResult));
        }
        logger.warn("ActivityControllor.get fail,op result:{}", JsonUtils.fromObject(activityResult));
        return JsonUtils.fromObject(new ApiResponse<Activity>(HeadEnum.SERVER_ERROR.newHead()));
    }
}
