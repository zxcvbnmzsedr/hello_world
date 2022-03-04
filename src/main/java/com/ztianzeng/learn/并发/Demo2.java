package com.ztianzeng.learn.并发;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {
    public static class MyBlockingQueueForCondition {
        private LinkedList queue;
        private int max = 16;
        private ReentrantLock lock = new ReentrantLock();
        private Condition notFull = lock.newCondition();
        private Condition notEmpty = lock.newCondition();

        public MyBlockingQueueForCondition(int max) {
            this.max = max;
            queue = new LinkedList();
        }

        public void put(Object v) throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() == max) {
                    notFull.await();
                }
                queue.add(v);
                notEmpty.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    notEmpty.await();
                }
                Object o = queue.poll();
                notFull.signalAll();
                return o;
            } finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        MyBlockingQueueForCondition queue = new MyBlockingQueueForCondition(10);
        Runnable producer = () -> {
            while (true) {
                try {
                    queue.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();
        Runnable consumer = () -> {
            while (true) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
