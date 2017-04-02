package net.yanrc.xpring.activity.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import net.yanrc.app.common.api.HeadEnum;
import net.yanrc.app.common.result.DefaultResult;
import net.yanrc.xpring.activity.biz.service.impl.ActivityServiceImpl;

/**
 * Created by yanricheng on 2017/3/27.
 */
@RunWith(MockitoJUnitRunner.class)
public class ActivityControllorTest {
    private static String succeed = HeadEnum.SUCCEED.getCode();
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private ActivityServiceImpl activityService;
    @InjectMocks
    private ActivityControllor activityController;

    @Test
    public void removeTest() {
        when(activityService.remove(anyInt())).thenReturn(new DefaultResult<>(true));
        assertThat(activityController.remove(null, request, response).getHead().getCode()).isNotEqualTo(succeed);
        assertThat(activityController.remove(" ", request, response).getHead().getCode()).isNotEqualTo(succeed);
        assertThat(activityController.remove("a b", request, response).getHead().getCode()).isNotEqualTo(succeed);
        assertThat(activityController.remove("a b", request, response).getHead().getCode()).isNotEqualTo(succeed);
        assertThat(activityController.remove("123 ", request, response).getHead().getCode()).isNotEqualTo(succeed);
        assertThat(activityController.remove("-1", request, response).getHead().getCode()).isNotEqualTo(succeed);
        assertThat(activityController.remove("1.0", request, response).getHead().getCode()).isNotEqualTo(succeed);
        assertThat(activityController.remove("0", request, response).getHead().getCode()).isEqualTo(succeed);
        assertThat(activityController.remove("1", request, response).getHead().getCode()).isEqualTo(succeed);
        assertThat(activityController.remove("1", request, response).getHead().getCode()).isEqualTo(succeed);
    }

}
