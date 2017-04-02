package net.yanrc.xpring.activity.common.utils.sys;

import net.yanrc.xpring.activity.common.utils.anots.Logable;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.util.StopWatch;

/**
 * Created by yanricheng on 16-10-25.
 */
public class SystemIntroduction implements SystemService, IntroductionInterceptor {
    private final Logger logger = LoggerFactory.getLogger(SystemIntroduction.class);
    private ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<>();

    @Override
    public void log() {
        StopWatch stopWatch = stopWatchThreadLocal.get();
        if (stopWatch != null) {
            logger.info(stopWatch.prettyPrint());
        }
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Logable logable = invocation.getMethod().getAnnotation(Logable.class);
        boolean bool = (null != logable);
        StopWatch stopWatch = null;
        if (logger.isInfoEnabled() && bool && implementsInterface(invocation.getClass())) {
            if (bool && logable.start()) {
                stopWatchThreadLocal.remove();
            }
            stopWatch = stopWatchThreadLocal.get();
            if (stopWatch == null) {
                stopWatch = new StopWatch(invocation.getMethod().getDeclaringClass().getName() + "." + invocation.getMethod().getName());
                stopWatchThreadLocal.set(stopWatch);
            }
            if (!stopWatch.isRunning()) {
                stopWatch.start(invocation.getMethod().getDeclaringClass().getName() + "." + invocation.getMethod().getName());
            }

            Object obj = invocation.proceed();

            if (stopWatch.isRunning()) {
                stopWatch.stop();
            }
            if (bool && logable.end() && stopWatch != null) {
                if (stopWatch.isRunning()) {
                    stopWatch.stop();
                }
                log();
                stopWatchThreadLocal.remove();
            }
            return obj;
        } else {
            return invocation.proceed();
        }
    }

    @Override
    public boolean implementsInterface(Class<?> intf) {
        return true;
    }
}
