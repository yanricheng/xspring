package net.yanrc.xpring.activity.component;

import com.netflix.config.*;
import com.netflix.config.sources.JDBCConfigurationSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

/**
 * Created by yanricheng on 16-12-1.
 */

public class JdbcConfigComponent {
    private static final Logger logger = LoggerFactory.getLogger(JdbcConfigComponent.class);

    private DataSource datasource;
    private String query = " SELECT config_key AS property_key ,config_value AS property_value FROM config_propertity ";
    private String keyColumnName = "property_key";
    /**
     * The column containing the values.
     */
    private String valueColumnName = "property_value";

    public JdbcConfigComponent() {

    }

    public JdbcConfigComponent(DataSource datasource) {
        this.datasource = datasource;
        JDBCConfigurationSource jdbcConfigurationSource = new JDBCConfigurationSource(datasource, query, keyColumnName, valueColumnName);
        FixedDelayPollingScheduler scheduler = new FixedDelayPollingScheduler(5000, 10000, true);
        DynamicConfiguration dynamicConfiguration = new DynamicConfiguration(jdbcConfigurationSource, scheduler);
        DynamicPropertyFactory.initWithConfigurationSource(dynamicConfiguration);

        logger.info("dynamicPropertyFactory 启动成功...");
    }

}
