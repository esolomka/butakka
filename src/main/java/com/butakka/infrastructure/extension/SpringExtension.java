package com.butakka.infrastructure.extension;

/**
 * Created by Jesús Barquín on 28/02/15.
 */

import akka.actor.AbstractExtensionId;
import akka.actor.ExtendedActorSystem;
import akka.actor.Extension;
import akka.actor.Props;
import org.springframework.context.ApplicationContext;

public class SpringExtension extends AbstractExtensionId<SpringExtension.SpringExt> {


    public static SpringExtension SpringExtProvider = new SpringExtension();


    @Override
    public SpringExt createExtension(ExtendedActorSystem system) {
        return new SpringExt();
    }

    public static class SpringExt implements Extension {

        private volatile ApplicationContext applicationContext;

        public void initialize(ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }

        public Props props(Class actorType) {
            return Props.create(DefaultActorProducer.class,applicationContext, actorType);
        }
    }
}
