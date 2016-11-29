package config;

import com.netflix.config.DynamicPropertyFactory;

/**
 * Created by yanricheng on 16-11-29.
 */

public class ConfigTest {

    public static void main(String[] args) {
        System.out.println(DynamicPropertyFactory.getInstance().getStringProperty("demo.user.name","阿虎").getDynamicProperty());
    }

}
