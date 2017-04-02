package net.yanrc.xpring.activity.web.biz.service.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by yanricheng on 16-10-24.
 */
public class SomeThrowAdvice implements ThrowsAdvice {
    private Logger logger =
            LoggerFactory.getLogger(this.getClass().getName());

    public void afterThrowing(Method method, Object[] args,
                              Object target, Throwable subclass) {
        // 記錄例外
        logger.info("Logging that a " + subclass +
                "Exception was thrown in " + method);
    }
}