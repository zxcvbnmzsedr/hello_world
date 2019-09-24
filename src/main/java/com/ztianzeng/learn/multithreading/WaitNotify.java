package com.ztianzeng.learn.multithreading;

/**
 * object 锁
 *
 * 使用 wait 和 notify 的时候必须要求 其对象在synchronized内
 * 在object wait之后会释放对象的锁，其他线程则会得到锁
 * T1 等待 T2 释放完锁之后才会继续执行
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-08 16:51
 */
public class WaitNotify {
    private final static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start! ");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T2 start! notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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