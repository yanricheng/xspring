package xpring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 * Created by yanricheng on 16-10-25.
 */
public class User implements InitializingBean {

    private String name;

    public User() {
        System.out.println("调用构造函数创建user");
    }

    public void setName(String name) {
        System.out.println("设置用户名称属性：" + name);
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("属性设置完成!");
    }


}
