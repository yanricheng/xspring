package net.yanrc.xpring.activity.biz.service.impl;

import static org.mockito.Mockito.argThat;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.GreaterThan;
import org.mockito.internal.matchers.LessOrEqual;
import org.mockito.junit.MockitoJUnitRunner;

import net.yanrc.xpring.activity.biz.manger.ActivityManager;

/**
 * Created by yanricheng on 16-11-8.
 */
@RunWith(MockitoJUnitRunner.class)
public class ActivityServiceTest {

    @InjectMocks
    private ActivityServiceImpl activityService;
    @Mock
    private ActivityManager activityManager;

    @Test
    public void removeTest() {
        when(activityManager.remove(argThat(new LessOrEqual<>(0)))).thenReturn(false);
        when(activityManager.remove(argThat(new GreaterThan<>(0)))).thenReturn(true);

        Assertions.assertThat(activityService.remove(-1).isSuccess()).isFalse();
        Assertions.assertThat(activityService.remove(0).isSuccess()).isFalse();
        Assertions.assertThat(activityService.remove(1).isSuccess()).isTrue();
    }

}
