package com.ztianzeng.learn.multithreading;

/**
 * 构造出线程死锁
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-08 17:11
 */
public class Deadlock {
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (o1) {
                System.out.println("线程1锁o1");
                try {
                    //让当前线程睡眠，保证让另一线程得到o2，防止这个线程启动一下连续获得o1和o2两个对象的锁。
                    Thread.sleep(1000);
                    synchronized (o2) {
                        System.out.println("线程1锁o2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (o2) {
                System.out.println("线程2锁o2");
                synchronized (o1) {
                    System.out.println("线程2锁o1");
                }
            }

        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();

    }
}