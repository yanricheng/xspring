package xpring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by yanricheng on 16-10-25.
 */
public class AwareBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    private String beanName;

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    public void setBeanName(String beanName) {
        System.out.println("设置bean名字.....");
        this.beanName = beanName;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("设置applicationContext");
        this.applicationContext = applicationContext;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("设置 beanFactory");
        this.beanFactory = beanFactory;
    }
}