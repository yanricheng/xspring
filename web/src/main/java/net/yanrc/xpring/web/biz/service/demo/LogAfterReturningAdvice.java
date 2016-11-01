package net.yanrc.xpring.web.biz.service.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by yanricheng on 16-10-24.
 */
public class LogAfterReturningAdvice implements AfterReturningAdvice {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        logger.info("afterReturning starts..." + method);
    }
}
