package xpring;

import net.yanrc.xpring.activity.web.biz.service.demo.IHello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by Administrator on 2016/10/29.
 */
public class HelloSpeakerTest {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/beans-config.xml");
        IHello helloProxy = (IHello) context.getBean("helloSpeakerBean");
        helloProxy.hello("Justin");
    }
}
