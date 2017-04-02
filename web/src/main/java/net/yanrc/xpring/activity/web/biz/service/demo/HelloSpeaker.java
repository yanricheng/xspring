package net.yanrc.xpring.activity.web.biz.service.demo;

/**
 * Created by yanricheng on 16-10-24.
 */
public class HelloSpeaker implements IHello {
    public void hello(String name) {
        System.out.println("Hello, " + name);
    }
}