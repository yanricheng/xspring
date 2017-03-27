package net.yanrc.xpring.web.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by yanricheng on 16-11-30.
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/","/aaa"}, method = RequestMethod.GET)
    @ResponseBody
    public String index(@RequestParam(value = "name") String name) {
        Map map = Maps.newHashMap();
        map.put("name", name);
        map.put("age", "30");
        return map.toString();
    }
}
