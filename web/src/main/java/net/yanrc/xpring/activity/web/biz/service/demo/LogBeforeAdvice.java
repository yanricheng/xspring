package net.yanrc.xpring.activity.web.biz.service.demo;

/**
 * Created by yanricheng on 16-10-24.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogBeforeAdvice implements MethodBeforeAdvice {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public void before(Method method, Object[] args, Object target) throws Throwable {
        logger.info("\n LogBeforeAdvice starts...,   {}", method);
    }
}