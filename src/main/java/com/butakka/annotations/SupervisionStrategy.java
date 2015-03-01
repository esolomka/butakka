package com.butakka.annotations;

import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Jesus Barquín on 1/03/15.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SupervisionStrategy {

    Class<? extends SupervisorStrategy> value() default OneForOneStrategy.class;
}
