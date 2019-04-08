package com.ztianzeng.learn.multithreading;

/**
 * 线程中断
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-08 14:31
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interruted!");
                    break;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interruted When Sleep");
                    //设置中断状态
                    Thread.currentThread().interrupt();
                }
                Thread.yield();
            }
        });
        t1.start();
        Thread.sleep(2000);
        // interrupt 中断是仅仅设置中断位，具体还是需要去增加中断的处理代码
        t1.interrupt();
    }
}