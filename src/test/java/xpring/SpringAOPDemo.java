package xpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by yanricheng on 16-10-24.
 */
public class SpringAOPDemo {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/beans-config.xml");
//        IHello helloProxy = (IHello) context.getBean("helloSpeakerBean");
//        helloProxy.hello("Justin");

//        ISome some = (ISome) context.getBean("someService");
//        some.doSome();
//        ((IOther) some).doOther();

    }

}
