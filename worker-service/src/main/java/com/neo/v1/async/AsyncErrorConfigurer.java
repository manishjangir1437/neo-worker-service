package com.neo.v1.async;

import com.neo.v1.reader.PropertyReader;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;

@RequiredArgsConstructor
@Configuration
public class AsyncErrorConfigurer implements AsyncConfigurer {

    public final PropertyReader propertyReader;

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }

    @Override
    @Nullable
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(propertyReader.getRewardsWorkerCorePoolSize());
        executor.setMaxPoolSize(propertyReader.getRewardsWorkerMaxPoolSize());
        executor.setQueueCapacity(propertyReader.getRewardsWorkerTaskQueueCapacity());
        executor.setThreadNamePrefix(propertyReader.getRewardsWorkerThreadNamePrefix());
        executor.setRejectedExecutionHandler((RejectedExecutionHandler) new AsyncExceptionHandler());
        executor.initialize();
        return executor;
    }
}