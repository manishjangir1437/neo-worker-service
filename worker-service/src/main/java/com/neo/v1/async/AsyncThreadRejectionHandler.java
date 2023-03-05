package com.neo.v1.async;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class AsyncThreadRejectionHandler implements RejectedExecutionHandler {
    private ExecutorService alternateExecutor;
    private static final int rejectionPoolThreads = 3;

    public AsyncThreadRejectionHandler() {
        this.alternateExecutor = Executors.newFixedThreadPool(rejectionPoolThreads);
    }

    @Override
    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
        if (Objects.nonNull(alternateExecutor)) {
            log.warn("{} is Rejected. Retrying to Execute it", task.toString());
            try {
                alternateExecutor.execute(task);
                log.debug("{} Execution Re-Started", task.toString());
            } catch (Exception e) {
                log.error("Failure to Re-execute. Cause - {}", e.getMessage(), e);
            }
        }
    }
}
