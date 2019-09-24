package com.ztianzeng.learn.multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-09 17:59
 */
public class FairLock implements Runnable {
    private static ReentrantLock lock = new ReentrantLock(true);


    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock,"t1");
        Thread t2 = new Thread(fairLock,"t2");
        t1.start();t2.start();
    }
}