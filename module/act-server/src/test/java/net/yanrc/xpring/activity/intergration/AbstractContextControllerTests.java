package net.yanrc.xpring.activity.intergration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by yanricheng on 2017/3/28.
 */
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring/servlet-context.xml", "classpath:spring/root-context.xml" })
public class AbstractContextControllerTests {
    @Autowired
    protected WebApplicationContext wac;
}
