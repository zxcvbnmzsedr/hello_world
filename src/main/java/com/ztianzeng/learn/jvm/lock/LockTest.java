package com.ztianzeng.learn.jvm.lock;

/**
 * @author zhaotianzeng
 */
@SuppressWarnings("all")
public class LockTest {

    public static void main(String[] args) {
        String lock1 = "lock1";
        String lock2 = "lock2";
        Thread t1 = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            synchronized (lock1) {
                System.out.println(threadName + "lock1");
                synchronized (lock2) {
                    System.out.println(threadName + "lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            synchronized (lock2) {
                System.out.println(threadName + "lock2");
                synchronized (lock1) {
                    System.out.println(threadName + "lock1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}

