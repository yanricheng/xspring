package config;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;

/**
 * Created by yanricheng on 16-11-29.
 */

public class ConfigTest {

    public static void main(String[] args) {
        DynamicPropertyFactory factory = DynamicPropertyFactory.getInstance();
        System.out.println(factory.getStringProperty("demo.user.name","阿虎").getDynamicProperty());
        System.out.println(ConfigurationManager.getConfigInstance().getString("@environment"));
    }

}
