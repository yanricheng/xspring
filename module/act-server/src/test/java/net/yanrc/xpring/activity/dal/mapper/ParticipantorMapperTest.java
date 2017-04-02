package net.yanrc.xpring.activity.dal.mapper;

import java.util.Date;

import net.yanrc.xpring.activity.domain.Participantor;
import org.apache.ibatis.session.SqlSession;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import net.yanrc.xpring.activity.dal.BaseMapper;

/**
 * Created by yanricheng on 2017/4/1.
 */
public class ParticipantorMapperTest extends BaseMapper {

    @Test(timeout = 1000)
    public void testInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ParticipantorMapper activityMapper = sqlSession.getMapper(ParticipantorMapper.class);
        try {
            Date now = new Date();
            Participantor activity1 = new Participantor().name("慧子1").isDelete(0).status(1).creator("huizi1")
                    .createTime(now).lastEditor("huizi").lastEditTime(now);
            Assertions.assertThat(activityMapper.insert(activity1) > 0).isTrue();
            Assertions.assertThat(activity1.getId() > 0).isTrue();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
