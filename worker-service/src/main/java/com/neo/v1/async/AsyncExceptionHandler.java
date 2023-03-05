package com.neo.v1.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        log.error("Exception Cause - {}", throwable.getMessage(), throwable);
        log.error("Method name - {}", method.getName());
        for (Object param : obj) {
            log.error("Parameter value - {}", param);
        }
    }
}