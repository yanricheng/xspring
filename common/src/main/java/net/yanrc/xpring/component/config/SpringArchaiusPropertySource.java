package net.yanrc.xpring.component.config;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.PropertySource;

import java.io.IOException;

public class SpringArchaiusPropertySource extends PropertySource<Void> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringArchaiusPropertySource.class);
    private ConfigComponent configComponent;

    public SpringArchaiusPropertySource(String name/*, String zkConnectionString, String zkConfigRootPath*/) {
        super(name);
//        configComponent = new ConfigComponent(zkConnectionString, zkConfigRootPath);
        try {
            ConfigurationManager.loadCascadedPropertiesFromResources(name);
        } catch (IOException e) {
            LOGGER.warn(
                    "Cannot find the properties specified : {}", name);
        }
    }

    @Override
    public Object getProperty(String name) {
//        return configComponent.getProperty(name);
        return DynamicPropertyFactory.getInstance().getStringProperty(name, null).get();
    }
}