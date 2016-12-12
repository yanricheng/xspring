package net.yanrc.xpring.web.controller;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.sources.URLConfigurationSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/11/30.
 */
@Controller
public class IndexController implements InitializingBean {

    @RequestMapping(value = "/api/index", method = RequestMethod.GET)
    public String index1() {
        System.out.println(DynamicPropertyFactory.getInstance().getStringProperty("demo.url.user.name", "yanrc11").getValue());
        return "home";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        System.out.println(DynamicPropertyFactory.getInstance().getStringProperty("demo.url.user.name", "yanrc11").getValue());
        return "home";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        FixedDelayPollingScheduler scheduler = new FixedDelayPollingScheduler(60000, 30000, true);
        URLConfigurationSource urlConfigurationSource = new URLConfigurationSource("http://localhost:9090/config.properties");
        DynamicConfiguration configuration = new DynamicConfiguration(urlConfigurationSource, scheduler);
        ConfigurationManager.install(configuration);
        System.out.println(DynamicPropertyFactory.getInstance().getStringProperty("demo.url.user.name", "yanrc11").getValue());

    }
}
