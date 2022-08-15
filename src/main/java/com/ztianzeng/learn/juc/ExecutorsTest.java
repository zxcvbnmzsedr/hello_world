package com.ztianzeng.learn.juc;

import java.util.concurrent.*;

public class ExecutorsTest {

    public static void main(String[] args) {


        ThreadPoolExecutor executorService = buildThreadPoolTaskExecutor();

        executorService.execute(() -> sayHi("execute"));
        executorService.submit(() -> sayHi("submit"));
        executorService.shutdown();
    }

    private static void sayHi(String name) {
        String printStr = "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name+"】";
        System.out.println(printStr);
        throw new RuntimeException(printStr + ",异常");
    }

    private static ThreadPoolExecutor buildThreadPoolTaskExecutor() {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 10,
                30, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(10));
        executorService.setThreadFactory(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("uncaughtException");
                    }
                });
                return t;
            }
        });
        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executorService;
    }
}