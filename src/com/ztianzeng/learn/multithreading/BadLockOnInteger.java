package com.ztianzeng.learn.multithreading;

/**
 * 错误的加锁
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-09 15:33
 */
public class BadLockOnInteger implements Runnable {
    private static Integer I = 0;

    private static BadLockOnInteger INSTANCE = new BadLockOnInteger();
    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            synchronized (I) {
                I++;
            }
        }
    }

    /**
     * I++的本质是创建一个新的Integer对象
     * I = Integer.valueOf(I.intValue()+1);，每次valueOf如果大于integer的缓存会创建一个新的Integer对象
     * 如果锁I的话由于每次I的对象都是在变化的，多个线程之间不一定能够看到同一个Integer对象，每次锁都加在不同实例上导致同步失败
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(INSTANCE);
        Thread t2 = new Thread(INSTANCE);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(I);
    }
}