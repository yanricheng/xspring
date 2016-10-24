package xpring;

import net.yanrc.xpring.web.biz.service.demo.IHello;
import net.yanrc.xpring.web.biz.service.demo.IOther;
import net.yanrc.xpring.web.biz.service.demo.ISome;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by yanricheng on 16-10-24.
 */
public class SpringAOPDemo {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext( "classpath:/beans-config.xml");
        IHello helloProxy = (IHello) context.getBean("helloSpeakerBean");
        helloProxy.hello("Justin");

        ISome some = (ISome) context.getBean("proxyFactoryBean");
        some.doSome();
        // 看來好像some物件動態增加了職責
        ((IOther) some).doOther();

    }

}
