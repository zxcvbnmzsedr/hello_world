package com.ztianzeng.learn.jvm;

public class Test17 {
    public static void main(String[] args) throws InterruptedException {
        //创建MyThread13线程类实例
        MyThread13 thread = new MyThread13();
        thread.start();    //启动线程
        //延时100毫秒
         Thread.sleep(1000);
        //停止线程
        thread.interrupt();
        Thread.sleep(100000);
    }
}