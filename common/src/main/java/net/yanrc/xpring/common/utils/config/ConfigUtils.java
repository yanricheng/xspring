package net.yanrc.xpring.common.utils.config;

import com.netflix.config.DynamicPropertyFactory;

/**
 * Created by yanricheng on 16-11-17.
 */
public class ConfigUtils {

    static DynamicPropertyFactory dynamicPropertyFactory = null;

    static {
        dynamicPropertyFactory = DynamicPropertyFactory.getInstance();
    }

    public static DynamicPropertyFactory getDynamicPropertyFactory() {
        return dynamicPropertyFactory;
    }
}
