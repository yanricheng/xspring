package net.yanrc.xpring.dal.mapper;

import net.yanrc.xpring.builder.ActivityBuilder;
import net.yanrc.xpring.dal.entity.Activity;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by yanricheng on 2017/3/25.
 */
public class ActivityMapperTest extends BaseMapper {

    private int id1;
    private int id2;

    private Activity act1;
    private Activity act2;

    @Test
    public void testInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityBuilder activityBuilder = ActivityBuilder.newInstance();
        Date now = new Date();
        activityBuilder.name("慧子").isDelete(0).status(1).type(1)
                .creator("huizi").createTime(now).lastEditor("huizi")
                .lastEditTime(now);

        ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
        try {
            Activity activity = activityBuilder.build();
            int count1 = activityMapper.insert(activity);
            Assert.assertTrue(count1 > 0);
            id1 = activity.getId();

            activity.setId(null);
            int count2 = activityMapper.insert(activity);
            Assert.assertTrue(count2 > 0);
            id2 = activity.getId();

            act1 = activityMapper.selectByPrimaryKey(id1);
            Assert.assertNotNull(act1);

            act2 = activityMapper.selectByPrimaryKey(id2);
            Assert.assertNotNull(act2);
            Assert.assertTrue(StringUtils.isNotBlank(act1.getName()));
            Assert.assertTrue(StringUtils.endsWith(act1.getName(), act2.getName()));

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
