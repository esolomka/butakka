package test.basic;

import akka.actor.ActorRef;
import akka.testkit.JavaTestKit;
import com.butakka.config.AkkaIntegrationConfiguration;
import com.butakka.infrastructure.context.DefaultAkkaContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jefe on 21/02/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AkkaIntegrationConfiguration.class, ApplicationTest.configuration.class})
public class ApplicationTest {


    @ComponentScan(basePackages = "test.basic")
    @Configuration
    static class configuration{

    }

    @Autowired
    private DefaultAkkaContext context;

    @Test
    public void TestThatTheActorSystemWorks() throws Exception {

        new JavaTestKit(context.getSystem()) {{
            final ActorRef subject = context.getActorRef("hello-actor", "test-basic");
            subject.tell("MSG1", getRef());
            expectMsgEquals(duration("1 second"), "OK:MSG1");

        }};
    }
}
