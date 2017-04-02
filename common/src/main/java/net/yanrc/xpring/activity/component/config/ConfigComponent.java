package net.yanrc.xpring.activity.component.config;


import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicWatchedConfiguration;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanricheng on 16-11-17.
 */
public class ConfigComponent {
    private static Logger logger = LoggerFactory.getLogger(ConfigComponent.class);
    private String zkConnectionString = "127.0.0.1:2181";
    private String zkConfigRootPath = "/xspring/config";

    private DynamicPropertyFactory dynamicPropertyFactory;

    public ConfigComponent() {
        init();
    }

    public ConfigComponent(String zkConnectionString, String zkConfigRootPath) {
        this.zkConnectionString = zkConnectionString;
        this.zkConfigRootPath = zkConfigRootPath;
        init();
    }

    public ConfigComponent(String zkConnectionString) {
        this.zkConnectionString = zkConnectionString;
        init();
    }

    void init() {
        try {
            CuratorFramework client = CuratorFrameworkFactory.newClient(zkConnectionString, new ExponentialBackoffRetry(1000, 3));
            client.start();
            ZooKeeperConfigurationSource zkConfigSource = new ZooKeeperConfigurationSource(client, zkConfigRootPath);
            zkConfigSource.start();
            DynamicWatchedConfiguration zkDynamicConfig = new DynamicWatchedConfiguration(zkConfigSource);
            ConfigurationManager.install(zkDynamicConfig);
            dynamicPropertyFactory = DynamicPropertyFactory.getInstance();
            logger.info("dynamicPropertyFactory 启动成功...");
        } catch (Exception e) {
            logger.error("config init error!", e);
        }
    }

    public Object getProperty(String name) {
        return dynamicPropertyFactory.getStringProperty(name, null).get();
    }

    public DynamicPropertyFactory getDynamicPropertyFactory() {
        return dynamicPropertyFactory;
    }

    public void setDynamicPropertyFactory(DynamicPropertyFactory dynamicPropertyFactory) {
        this.dynamicPropertyFactory = dynamicPropertyFactory;
    }

    public String getZkConnectionString() {
        return zkConnectionString;
    }

    public void setZkConnectionString(String zkConnectionString) {
        this.zkConnectionString = zkConnectionString;
    }
}
