package net.yanrc.xpring.activity.intergration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by yanricheng on 2017/3/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ActivityIntergrationTest extends AbstractContextControllerTests {

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
    }

    @Test
    public void htmlView() throws Exception {
        this.mockMvc.perform(get("/act/delete?id=2")).andExpect(status().isOk());
    }

    // @Test
    // public void simple() throws Exception {
    // standaloneSetup(new
    // ActivityControllor()).build().perform(get("/simple/revisited").accept(MediaType.TEXT_PLAIN))
    // .andExpect(status().isOk())//
    // .andExpect(content().contentType("text/plain"))
    // .andExpect(content().string("Hello world revisited!"));
    // }

    // @Test
    // public void delete() throws Exception {
    // standaloneSetup(new ActivityControllor()).build()
    // .perform(get("/act/delete?id=1").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
    // // .andExpect(content().contentType("text/plain"))
    // .andExpect(content().string("Hello world revisited!"));
    // }
}
