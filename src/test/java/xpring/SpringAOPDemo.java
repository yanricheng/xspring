package xpring;

import net.yanrc.xpring.web.biz.service.demo.IHello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by yanricheng on 16-10-24.
 */
public class SpringAOPDemo {
    public static void main(String[] args) {
        ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "classpath:/beans-config.xml");
        IHello helloProxy =
                (IHello) context.getBean("helloSpeakerBean");
        helloProxy.hello("Justin");
    }

}
