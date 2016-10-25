package xpring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by yanricheng on 16-10-25.
 */
public class FactoryPostProcessorBean implements BeanFactoryPostProcessor
{
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurablelistablebeanfactory)
            throws BeansException
    {
        System.out.println("Enter beab factory 处理器\n");
    }
}