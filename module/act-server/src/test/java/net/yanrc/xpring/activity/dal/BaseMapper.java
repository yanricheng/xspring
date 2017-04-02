package net.yanrc.xpring.activity.dal;

import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

/**
 * Created by yanricheng on 2017/3/25.
 */
public class BaseMapper {
    protected static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        final Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        // populate in-memory database
        // final SqlSession session = sqlSessionFactory.openSession();
        // final Connection conn = session.getConnection();
        // final Reader dbReader =
        // Resources.getResourceAsReader("org/apache/ibatis/autoconstructor/CreateDB.sql");
        // final ScriptRunner runner = new ScriptRunner(conn);
        // runner.setLogWriter(null);
        // runner.runScript(dbReader);
        // dbReader.close();
        // session.close();
    }

    protected void runScript(String filePath) throws Exception {
        final SqlSession session = sqlSessionFactory.openSession();
        final Connection conn = session.getConnection();
        final Reader dbReader = Resources.getResourceAsReader(filePath);
        final ScriptRunner runner = new ScriptRunner(conn);
        runner.setLogWriter(null);
        runner.runScript(dbReader);
        dbReader.close();
        session.close();
    }

}
