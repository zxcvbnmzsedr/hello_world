package com.ztianzeng.learn.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class MuThread {
    public static int m = 0;
    public static final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException {
       Thread A = new Thread(() -> {
           lock.lock();
           try {
               System.out.println("用户A开始办理业务");
               try { TimeUnit.MINUTES.sleep(20); } catch (InterruptedException e) {e.printStackTrace();}
               System.out.println("用户A办理业务完成");
           }finally {
               lock.unlock();
           }
       },"用户A");
       Thread B = new Thread(() -> {
           lock.lock();
           try {
               System.out.println("用户B开始办理业务");
           }finally {
               lock.unlock();
           }
       },"用户B");
       Thread C = new Thread(() -> {
           lock.lock();
           try {
               System.out.println("用户C开始办理业务");
           }finally {
               lock.unlock();
           }
       });
       A.start();
       Thread.sleep(100);
       B.start();
//       C.start();
    }
}
