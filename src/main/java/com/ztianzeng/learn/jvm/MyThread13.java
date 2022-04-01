package com.ztianzeng.learn.jvm;

public class MyThread13 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("i=" + (i + 1));
        }
        while (true) {
            if (Thread.interrupted()) {
                try {
                    throw new InterruptedException(" 文件扫描任务被中断 ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}