package net.yanrc.xpring.ui.controllor;

import com.google.common.collect.Sets;
import net.yanrc.app.common.api.ApiResponse;
import net.yanrc.app.common.result.DefaultResult;
import net.yanrc.app.common.result.Result;
import net.yanrc.app.common.util.JsonUtils;
import net.yanrc.app.common.util.UUIDGenerator;
import net.yanrc.xpring.biz.api.UserBizApi;
import net.yanrc.xpring.common.utils.XRequestParam;
import net.yanrc.xpring.data.dto.UserDto;
import net.yanrc.xpring.data.model.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.util.*;

/**
 * UserControllor
 *
 * @auther hzyanricheng
 * @create 2016-04-16 10:26
 */
@Controller
public class UserControllor {
    private static final Logger logger = LoggerFactory.getLogger(UserControllor.class);
    @Autowired
    private UserBizApi userBizApi;

    @RequestMapping(value = "/user/save", method = RequestMethod.GET)
    public String saveUserPage(ModelMap resultModel) {
        resultModel.addAttribute("welcome", "welcome");
        return "user/add";
    }


    //    Set<MediaType> set = Sets.newHashSet();
//    set.add(MediaType.APPLICATION_JSON);
//    request.setAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE,set);
//
    @RequestMapping(value = "/api/v1/user/save", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ApiResponse saveUser(
            HttpServletRequest request,
            @XRequestParam(required = true, name = "userName", defaultValue = "yanrc") String userName
//            @XRequestParam(required = true, name = "myNme" ) String name,
//            @XRequestParam(required = true, name = "age", defaultValue = "20") Integer age,
//            @XRequestParam(required = true, name = "myAge", defaultValue = "30") Integer myAge,
//            @RequestParam(required = true, name = "xAge", defaultValue = "30") Integer yAge,
//            @XRequestParam(required = true, name = "married", defaultValue = "true") boolean married,
//            @XRequestParam(required = true, name = "xmarried", defaultValue = "false") Boolean xmarried,
//            @XRequestParam(required = true, name = "mymarried", defaultValue = "false") Boolean ymarried,
//
//            @RequestParam(required = true, name = "school", defaultValue = "yanrc") ArrayList<String> school,
//            @XRequestParam(required = true, name = "myschool", defaultValue = "yanrc") ArrayList<String> xschools

    ) throws InvocationTargetException, IllegalAccessException {
        UserDto userDto = new UserDto();
        userDto.setName(userName);

        User user = new User();
        BeanUtils.copyProperties(user, userDto);
        user.setId(100);

        return new ApiResponse(new DefaultResult<User>(user));
    }

    static final String key = "c_yanrc";

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse voteMzzdyPost(@CookieValue(value = key, required = false) String voteCookie,
                                     HttpServletRequest request, HttpServletResponse response) {

        System.out.println(JsonUtils.fromObject((request.getHeader("User-Agent"))));

        if (StringUtils.isBlank(voteCookie)) {
            voteCookie = new Date().toString();
            Cookie c = new Cookie(key, voteCookie);
            c.setMaxAge(600);
            response.addCookie(c);
            System.out.println("无  set cookie:" + voteCookie + "   old:" + voteCookie);
        } else {
            System.out.println("有 get cookie:" + voteCookie);
        }

        for(int i=0;i<10000;i++){
            System.out.println(i);
        }

        return new ApiResponse(new DefaultResult<String>(voteCookie));
    }

}
