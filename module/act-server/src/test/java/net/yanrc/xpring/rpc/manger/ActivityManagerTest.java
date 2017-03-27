package net.yanrc.xpring.rpc.manger;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import net.yanrc.xpring.dal.mapper.ActivityMapper;
import net.yanrc.xpring.rpc.manger.impl.ActivityManagerImpl;

/**
 * Created by yanricheng on 2017/3/27.
 */
@RunWith(MockitoJUnitRunner.class)
public class ActivityManagerTest {
    @Mock
    private ActivityMapper activityMapper;
    @InjectMocks
    private ActivityManagerImpl activityManager;

    @Test
    public void removeTest() {
        when(activityMapper.deleteByPrimaryKey(anyInt())).thenReturn(1);
        Assertions.assertThat(activityManager.remove(-1)).isFalse();
        Assertions.assertThat(activityManager.remove(0)).isFalse();
        Assertions.assertThat(activityManager.remove(1)).isTrue();
        Assertions.assertThat(activityManager.remove(10)).isTrue();
        Assertions.assertThat(activityManager.remove(1000)).isTrue();
        Assertions.assertThat(activityManager.remove(19999)).isTrue();
        Assertions.assertThat(activityManager.remove(Integer.MAX_VALUE)).isTrue();
    }
}
