package net.yanrc.xpring.activity.component.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringProfileSettingApplicationContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext ctx) {

        ctx.getEnvironment()
                .getPropertySources()
                .addFirst(new SpringArchaiusPropertySource("config"));
    }
}