package net.yanrc.xpring.component;


import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicWatchedConfiguration;
import com.netflix.config.source.ZooKeeperConfigurationSource;
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
    private String zkConnectionString;
    private String zkConfigRootPath;

    private DynamicPropertyFactory dynamicPropertyFactory;

    public ConfigComponent() {
        this.zkConnectionString = "127.0.0.1:2181";
        this.zkConfigRootPath = "/xspring/config";
        init();
    }

    public ConfigComponent(String zkConnectionString, String zkConfigRootPath) {
        this.zkConnectionString = zkConnectionString;
        this.zkConfigRootPath = zkConfigRootPath;
        init();
    }

    void init() {
        try {
            CuratorFramework client = CuratorFrameworkFactory.newClient(zkConnectionString,
                    new ExponentialBackoffRetry(1000, 3));
            ZooKeeperConfigurationSource zkConfigSource = new ZooKeeperConfigurationSource(client, zkConfigRootPath);
            zkConfigSource.start();
            DynamicWatchedConfiguration zkDynamicConfig = new DynamicWatchedConfiguration(zkConfigSource);
            ConfigurationManager.install(zkDynamicConfig);
            dynamicPropertyFactory = DynamicPropertyFactory.getInstance();
        } catch (Exception e) {
            logger.error("config init error!", e);
        }
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
