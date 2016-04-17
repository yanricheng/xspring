package net.yanrc.xpring.ui.controllor;

import com.google.common.collect.Sets;
import net.yanrc.app.common.api.ApiResponse;
import net.yanrc.app.common.result.DefaultResult;
import net.yanrc.app.common.result.Result;
import net.yanrc.app.common.util.UUIDGenerator;
import net.yanrc.xpring.biz.api.UserBizApi;
import net.yanrc.xpring.data.dto.UserDto;
import net.yanrc.xpring.data.model.User;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

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
        resultModel.addAttribute("welcome", "welcome" );
        return "user/add";
    }


//    Set<MediaType> set = Sets.newHashSet();
//    set.add(MediaType.APPLICATION_JSON);
//    request.setAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE,set);
//
    @RequestMapping(value = "/api/v1/user/save", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ApiResponse saveUser(
            HttpServletRequest request,
            @RequestParam(required = true,name = "userName",defaultValue = "yanrc") String name) throws InvocationTargetException, IllegalAccessException {
        UserDto userDto = new UserDto();
        userDto.setName(name);

        User user = new User();
        BeanUtils.copyProperties(user,userDto);
        user.setId(100);

        return new ApiResponse(new DefaultResult<User>(user));
    }

}
