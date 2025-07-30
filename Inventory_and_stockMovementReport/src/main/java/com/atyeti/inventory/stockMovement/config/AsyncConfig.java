package com.atyeti.inventory.stockMovement.config;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Value("${app.threadpool.core-size:4}")
    private int corePoolSize;

    @Value("${app.threadpool.max-size:8}")
    private int maxPoolSize;

    @Value("${app.threadpool.queue-capacity:100}")
    private int queueCapacity;

    @Value("${app.threadpool.keep-alive-seconds:60}")
    private int keepAlive;

    @Value("${app.threadpool.allow-core-timeout:false}")
    private boolean allowCoreThreadTimeout;

    @Value("${app.threadpool.thread-name-prefix:CsvWorker-}")
    private String threadNamePrefix;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAlive);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setAllowCoreThreadTimeOut(allowCoreThreadTimeout);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, params) ->
                System.err.printf("Async error in method %s: %s%n", method.getName(), throwable.getMessage());
    }
}
