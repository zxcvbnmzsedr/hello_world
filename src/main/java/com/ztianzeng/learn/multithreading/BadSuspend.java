package com.ztianzeng.learn.multithreading;

/**
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-08 17:40
 */
public class BadSuspend {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                Thread.currentThread().suspend();
                System.out.println("out " + getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // u加锁
        t1.start();
        Thread.sleep(100);
        // u被t1加了锁，无法继续
        t2.start();
        // t1释放u的锁，到out，然后t2得以执行
        t1.resume();
        // t2释放u的锁，当这个时候t2还没有进入挂起状态，加了也没用
        t2.resume();
        t1.join();
        t2.join();

    }
}