package net.yanrc.xpring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.yanrc.xpring.rpc.service.IDemoService;

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
