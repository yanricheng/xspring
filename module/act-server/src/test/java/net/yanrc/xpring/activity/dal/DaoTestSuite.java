package net.yanrc.xpring.activity.dal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import net.yanrc.xpring.activity.dal.mapper.ActivityMapperTest;
import net.yanrc.xpring.activity.dal.mapper.ParticipantorMapperTest;

/**
 * Created by yanricheng on 2017/4/1.
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = { ActivityMapperTest.class, ParticipantorMapperTest.class })
public class DaoTestSuite {
}
