package com.ztianzeng.learn.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 条件，用于控制锁
 *
 * condition.await() 线程会进入等待状态，等待condition.signal()通知之后再继续运行
 *
 * 如果condition执行不在锁之内，会抛出IllegalMonitorStateException异常
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-09 20:15
 */
public class ReenterLockCondition implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();

    public static Condition condition = lock.newCondition();


    @Override
    public void run() {
        try {
            lock.lock();

            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
           lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition reenterLockCondition = new ReenterLockCondition();
        Thread t1 = new Thread(reenterLockCondition,"t1");
        t1.start();
        Thread.sleep(2000);

        lock.lock();
        condition.signal();
        lock.unlock();
    }
}