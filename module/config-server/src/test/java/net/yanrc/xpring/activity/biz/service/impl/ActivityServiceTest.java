package net.yanrc.xpring.activity.biz.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by yanricheng on 16-11-8.
 */
public class ActivityServiceTest {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:*/root-context.xml");
        context.start();

        System.in.read(); // 按任意键退出
    }
}
