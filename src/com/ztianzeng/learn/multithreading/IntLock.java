package com.ztianzeng.learn.multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * t1 锁 lock1 再 lock2
 * t2 锁 lock2 再 lock1
 * 这样很容易导致死锁，在死锁之后，锁可以响应线程中断 t2中断之后，t2抛异常退出释放锁，t1顺利执行
 * lockInterruptibly表示是可以打断的锁而lock则不会响应中断
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-09 16:42
 */
public class IntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    /**
     * 构造加锁顺序，方便构造死锁
     */
    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
            System.out.println(Thread.currentThread().getName() + ":执行成功");

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ":线程被打断");
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + ":线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }
}