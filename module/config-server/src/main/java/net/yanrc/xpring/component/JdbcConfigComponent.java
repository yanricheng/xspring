package net.yanrc.xpring.component;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.sources.JDBCConfigurationSource;

import javax.sql.DataSource;

/**
 * Created by yanricheng on 16-12-1.
 */
public class JdbcConfigComponent {
    private DataSource datasource;
    private String query = "select ";
    private String keyColumnName = "property_key";
    /** The column containing the values. */
    private String valueColumnName = "property_value";

    public void JdbcConfigComponent(){
        JDBCConfigurationSource jdbcConfigurationSource = new JDBCConfigurationSource(datasource);
        ConfigurationManager.install(zkDynamicConfig);
        dynamicPropertyFactory = DynamicPropertyFactory.getInstance();
        logger.info("dynamicPropertyFactory 启动成功...");
    }

}
