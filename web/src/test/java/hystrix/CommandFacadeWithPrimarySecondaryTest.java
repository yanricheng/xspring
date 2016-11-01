package hystrix;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import net.yanrc.xpring.web.command.CommandFacadeWithPrimarySecondary;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yanricheng on 16-10-31.
 */
public class CommandFacadeWithPrimarySecondaryTest {

    @Test
    public void testPrimary() {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            ConfigurationManager.getConfigInstance().setProperty("primarySecondary.usePrimary", true);
            Assert.assertEquals("responseFromPrimary-20", new CommandFacadeWithPrimarySecondary(20).execute());
        } finally {
            context.shutdown();
            ConfigurationManager.getConfigInstance().clear();
        }
    }

    @Test
    public void testSecondary() {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            ConfigurationManager.getConfigInstance().setProperty("primarySecondary.usePrimary", false);
            Assert.assertEquals("responseFromSecondary-20", new CommandFacadeWithPrimarySecondary(20).execute());
        } finally {
            context.shutdown();
            ConfigurationManager.getConfigInstance().clear();
        }
    }
}
