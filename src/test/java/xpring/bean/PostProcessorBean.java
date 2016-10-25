package xpring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by yanricheng on 16-10-25.
 */
public class PostProcessorBean implements BeanPostProcessor
{
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("Enter ProcessorBean.postProcessAfterInitialization()\n");
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("Enter ProcessorBean.postProcessBeforeInitialization()");
        return bean;
    }
}