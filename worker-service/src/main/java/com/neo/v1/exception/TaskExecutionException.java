package com.neo.v1.exception;

public class TaskExecutionException extends RuntimeException {

    public TaskExecutionException() {
        super();
    }

    public TaskExecutionException(String message) {
        super(message);
    }

    public TaskExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskExecutionException(Throwable cause) {
        super(cause);
    }

    protected TaskExecutionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
