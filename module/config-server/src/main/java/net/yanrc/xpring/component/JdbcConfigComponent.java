package net.yanrc.xpring.component;

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



}
