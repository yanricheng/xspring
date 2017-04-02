package net.yanrc.xpring.activity.web.component;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/27.
 */
public class ConfigUtils {
    public static void main(String[] args) {
//        try {
//            ConfigurationManager.loadCascadedPropertiesFromResources("sample");
//            String myProp = DynamicPropertyFactory.getInstance().getStringProperty("myprop", "NOT FOUND").get();
//            System.out.println(myProp);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            ConfigurationManager.getDeploymentContext().setDeploymentEnvironment("perf");
            ConfigurationManager
                    .loadCascadedPropertiesFromResources("sample");
            String myProp = DynamicPropertyFactory.getInstance().getStringProperty("xspring.user.name", "NOT FOUND").get();
            System.out.println(myProp);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
