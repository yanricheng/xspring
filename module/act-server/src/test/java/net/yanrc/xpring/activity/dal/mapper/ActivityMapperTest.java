package net.yanrc.xpring.activity.dal.mapper;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.yanrc.xpring.activity.dal.BaseMapper;
import net.yanrc.xpring.activity.domain.Activity;

//import org.junit.Assert;

/**
 * Created by yanricheng on 2017/3/25.
 */

public class ActivityMapperTest extends BaseMapper {

    @Before
    public void setup() throws Exception {
        runScript("script/activity-setup.sql");
    }

    @After
    public void teardown() throws Exception {
        runScript("script/activity-teardown.sql");
    }

    @Test(timeout = 1000)
    public void testInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
        try {
            Date now = new Date();
            Activity activity1 = new Activity().name("慧子1").isDelete(0).status(1).type(1).creator("huizi1")
                    .createTime(now).lastEditor("huizi").lastEditTime(now);
            Assertions.assertThat(activityMapper.insert(activity1) > 0).isTrue();
            Assertions.assertThat(activity1.getId() > 0).isTrue();

            Activity activity2 = new Activity().isDelete(0).status(1).type(1).name("慧子2").creator("huizi2")
                    .createTime(now).lastEditor("huizi").lastEditTime(now);
            Assertions.assertThat(activityMapper.insert(activity2) > 0).isTrue();
            Assertions.assertThat(activity2.getId() > 0).isTrue();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void testSelect() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
        try {
            Date now = new Date();
            Activity activity = new Activity().name("日成").isDelete(0).status(1).type(1).creator("richeng")
                    .createTime(now).lastEditor("richeng").lastEditTime(now);
            Assertions.assertThat(activityMapper.insert(activity) > 0).isTrue();
            Activity act1 = activityMapper.selectByPrimaryKey(activity.getId());
            Assertions.assertThat(act1.getName().equalsIgnoreCase("日成")).isTrue();
            Assertions.assertThat(act1.getCreator().equalsIgnoreCase("richeng")).isTrue();
            Assertions.assertThat(act1.getLastEditor().equalsIgnoreCase("richeng")).isTrue();
            Assertions.assertThat(act1.getCreateTime().getTime() == now.getTime()).isTrue();
            Assertions.assertThat(act1.getLastEditTime().getTime() == now.getTime()).isTrue();
            Assertions.assertThat(act1.getIsDelete() == 0).isTrue();
            Assertions.assertThat(act1.getStatus() == 1).isTrue();
            Assertions.assertThat(act1.getType() == 1).isTrue();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
