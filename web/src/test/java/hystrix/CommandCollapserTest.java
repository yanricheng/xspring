package hystrix;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by yanricheng on 16-10-31.
 */
public class CommandCollapserTest {

    @Test
    public void testCollapser() throws Exception {
//        HystrixRequestContext context = HystrixRequestContext.initializeContext();
//        try {
//            Future<String> f1 = new CommandCollapserGetValueForKey(1).queue();
//            Future<String> f2 = new CommandCollapserGetValueForKey(2).queue();
//            Future<String> f3 = new CommandCollapserGetValueForKey(3).queue();
//            Future<String> f4 = new CommandCollapserGetValueForKey(4).queue();
//
//            assertEquals("ValueForKey: 1", f1.get());
//            assertEquals("ValueForKey: 2", f2.get());
//            assertEquals("ValueForKey: 3", f3.get());
//            assertEquals("ValueForKey: 4", f4.get());
//
//            // assert that the batch command 'GetValueForKey' was in fact
//            // executed and that it executed only once
//            assertEquals(1, HystrixRequestLog.getCurrentRequest().getExecutedCommands().size());
//            HystrixCommand<?> command = HystrixRequestLog.getCurrentRequest().getExecutedCommands().toArray(new HystrixCommand<?>[1])[0];
//            // assert the command is the one we're expecting
//            assertEquals("GetValueForKey", command.getCommandKey().name());
//            // confirm that it was a COLLAPSED command execution
//            assertTrue(command.getExecutionEvents().contains(HystrixEventType.COLLAPSED));
//            // and that it was successful
//            assertTrue(command.getExecutionEvents().contains(HystrixEventType.SUCCESS));
//        } finally {
//            context.shutdown();
//        }
    }
}
