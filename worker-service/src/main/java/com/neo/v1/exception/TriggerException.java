package com.neo.v1.exception;

public class TriggerException extends RuntimeException {

    public TriggerException(String message) {
        super(message);
    }

    public TriggerException(String message, Throwable cause) {
        super(message, cause);
    }
}
