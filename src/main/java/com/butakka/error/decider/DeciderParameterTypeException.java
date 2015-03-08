package com.butakka.error.decider;

/**
 * Created by Jesus Barquín on 1/03/15.
 */
public class DeciderParameterTypeException extends RuntimeException {

    public DeciderParameterTypeException() {
        super("The strategy handler method parameter must inherit from Throwable");
    }
}
