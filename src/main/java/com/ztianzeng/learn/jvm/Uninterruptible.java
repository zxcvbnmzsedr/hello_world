package com.ztianzeng.learn.jvm;

@SuppressWarnings("all")
public class Uninterruptible {
    private static final Object o1 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("t1 enter");
            synchronized (o1) {
                try {
                    System.out.println("start lock t1");
                    Thread.sleep(20000);
                    System.out.println("end lock t1");
                } catch (InterruptedException e) {
                    System.out.println("t1 interruptedException");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("t2 enter");
            synchronized (o1) {
                try {
                    System.out.println("start lock t2");
                    Thread.sleep(1000);
                    System.out.println("end lock t2");
                } catch (InterruptedException e) {
                    System.out.println("t2 interruptedException");
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        // 主线程休眠一下，让t1,t2线程百分百已经启动，避免线程交替导致测试结果混淆
        Thread.sleep(1000);
        // 中断t2线程的执行
        thread2.interrupt();
        System.out.println("t2 interrupt...");

    }
}