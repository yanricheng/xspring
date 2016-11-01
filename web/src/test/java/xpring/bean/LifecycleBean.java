package xpring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by yanricheng on 16-10-25.
 */
public class LifecycleBean implements InitializingBean,DisposableBean {
    @SuppressWarnings("unused")
    private String lifeCycleBeanName;

    public void setLifeCycleBeanName(String lifeCycleBeanName) {
        System.out.println("设置属性");
        this.lifeCycleBeanName = lifeCycleBeanName;
    }

    public void destroy() throws Exception {
        System.out.println("销毁");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }

    public void beanStart() {
        System.out.println("Enter LifecycleBean.beanStart()");
    }

    public void beanEnd() {
        System.out.println("Enter LifecycleBean.beanEnd()");
    }
}
