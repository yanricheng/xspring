package hystrix;

import net.yanrc.xpring.web.command.CommandWithStubbedFallback;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by yanricheng on 16-10-31.
 */
public class CommandWithStubbedFallbackTest {
    @Test
    public void test() {
        CommandWithStubbedFallback command = new CommandWithStubbedFallback(1234, "ca");
        CommandWithStubbedFallback.UserAccount account = command.execute();
        assertTrue(command.isFailedExecution());
        assertTrue(command.isResponseFromFallback());
        assertEquals(1234, account.getCustomerId());
        assertEquals("ca", account.getCountryCode());
        assertEquals(true, account.isFeatureXPermitted());
        assertEquals(true, account.isFeatureYPermitted());
        assertEquals(false, account.isFeatureZPermitted());
    }
}
