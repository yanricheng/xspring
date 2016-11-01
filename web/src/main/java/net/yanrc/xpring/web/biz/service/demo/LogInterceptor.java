package net.yanrc.xpring.web.biz.service.demo;

/**
 * Created by yanricheng on 16-10-24.
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogInterceptor implements MethodInterceptor {
    private Logger logger =
            LoggerFactory.getLogger(this.getClass().getName());

    public Object invoke(MethodInvocation methodInvocation)
            throws Throwable {
        logger.info("method starts..." + methodInvocation.getMethod());

        Object result = null;

        try {
            result = methodInvocation.proceed();
        } finally {
            logger.info("method ends..." +
                    methodInvocation.getMethod() + "\n");
        }

        return result;
    }
}
