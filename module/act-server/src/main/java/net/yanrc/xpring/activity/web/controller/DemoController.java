package net.yanrc.xpring.activity.web.controller;

import net.yanrc.xpring.activity.biz.service.IDemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yanricheng on 2017/3/26.
 */
@Controller
// @RunWith(MockitoJUnitRunner.class)
public class DemoController {

    // @Mock
    private IDemoService demoService;

    public DemoController() {
    }

    @RequestMapping(path = "act/demos/{id}", method = RequestMethod.GET)
    public String getNameById(@PathVariable(value = "id") String id) {
        return demoService.getNameById(id);
    }
}
