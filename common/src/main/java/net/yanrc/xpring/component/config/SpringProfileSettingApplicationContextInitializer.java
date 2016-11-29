package net.yanrc.xpring.component.config;

import com.netflix.config.ConfigurationBasedDeploymentContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

public class SpringProfileSettingApplicationContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext ctx) {

        ctx.getEnvironment()
                .getPropertySources()
                .addFirst(new SpringArchaiusPropertySource("config"));
    }
}