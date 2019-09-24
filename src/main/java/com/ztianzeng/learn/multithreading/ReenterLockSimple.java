package com.ztianzeng.learn.multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 * 锁可以反复进入，允许一个线程两次获取同一把锁，
 * 但是在释放锁的时候也必须释放相同的次数，释放多了会抛异常，释放少了，线程还会持有锁
 * 其他线程也无法进入临界区
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-09 16:24
 */
public class ReenterLockSimple implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
//            lock.lock();
            lock.lock();
            try {
                i++;
            } finally {
//                lock.unlock();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockSimple tl = new ReenterLockSimple();
        Thread t1 = new Thread(tl,"t1");
        Thread t2 = new Thread(tl,"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);

    }
}