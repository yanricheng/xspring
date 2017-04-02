package net.yanrc.xpring.activity.web.biz.service.demo;

/**
 * Created by Administrator on 2016/10/25.
 */

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

public class OtherIntroduction
        implements IntroductionInterceptor, IOther {
    // 是否實作自IOther介面
    public boolean implementsInterface(Class clazz) {
        return clazz.isAssignableFrom(IOther.class);
    }

    public Object invoke(MethodInvocation methodInvocation)
            throws Throwable {
        // 如果呼叫的方法來自IOther介面的定義
        if (implementsInterface(
                methodInvocation.getMethod().getDeclaringClass())) {
            // 呼叫執行額外加入（mixin）的行為
            return methodInvocation.getMethod().
                    invoke(this, methodInvocation.getArguments());
        } else {
            return methodInvocation.proceed();
        }
    }

    public void doOther() {
        System.out.println("增加的職責。。。");
    }
}