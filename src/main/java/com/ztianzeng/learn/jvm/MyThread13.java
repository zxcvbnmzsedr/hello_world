package com.ztianzeng.learn.jvm;

public class MyThread13 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("i=" + (i + 1));
        }
        while (true) {
            if (Thread.interrupted()) {
                throw new RuntimeException(" 文件扫描任务被中断 ");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //创建MyThread13线程类实例
        MyThread13 thread = new MyThread13();
        thread.start();    //启动线程
        //延时100毫秒
        Thread.sleep(1000);
        //停止线程
        thread.interrupt();
        System.out.println("2222");
    }
}