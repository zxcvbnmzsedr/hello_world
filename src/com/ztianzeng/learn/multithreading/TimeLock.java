package com.ztianzeng.learn.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁申请等待限时
 * 等待 5 秒，如果获取不到锁则放弃等待
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-09 17:21
 */
public class TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " get lock success");
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getName() + " get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TimeLock timeLock = new TimeLock();
        Thread t1 = new Thread(timeLock, "t1");
        Thread t2 = new Thread(timeLock, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}