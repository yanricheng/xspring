package net.yanrc.xpring.web.controllor;

import net.yanrc.app.common.api.ApiResponse;
import net.yanrc.app.common.result.DefaultResult;
import net.yanrc.app.common.util.JsonUtils;
import net.yanrc.xpring.common.utils.XRequestParam;
import net.yanrc.xpring.component.ConfigComponent;
import net.yanrc.xpring.rpc.dto.query.UserQueryDto;
import net.yanrc.xpring.rpc.model.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @Autowired
    ConfigComponent configComponent;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
//        logger.info("Welcome home! The client locale is {}.", locale);
        String name = configComponent.getDynamicPropertyFactory().getStringProperty("user.name", "yanrc").get();
        logger.info("config:{}", name);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @RequestMapping(value = "/act/save", method = RequestMethod.GET)
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
        UserQueryDto userQueryDto = new UserQueryDto();
        userQueryDto.setName(userName);

        UserModel user = new UserModel();
        BeanUtils.copyProperties(user, userQueryDto);
        user.setId(100);

        return new ApiResponse(new DefaultResult<UserModel>(user));
    }

    static final String key = "c_yanrc";

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse voteMzzdyPost(@CookieValue(value = key, required = false) String voteCookie,
                                     HttpServletRequest request, HttpServletResponse response) {

        System.out.println(JsonUtils.fromObject((request.getHeader("UserModel-Agent"))));

        if (StringUtils.isBlank(voteCookie)) {
            voteCookie = new Date().toString();
            Cookie c = new Cookie(key, voteCookie);
            c.setMaxAge(600);
            response.addCookie(c);
            System.out.println("无  set cookie:" + voteCookie + "   old:" + voteCookie);
        } else {
            System.out.println("有 get cookie:" + voteCookie);
        }

        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }

        return new ApiResponse(new DefaultResult<String>(voteCookie));
    }

}
