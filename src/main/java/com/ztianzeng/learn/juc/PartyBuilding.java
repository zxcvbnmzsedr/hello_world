package com.ztianzeng.learn.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PartyBuilding {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("有两人到齐了,干饭~~~"));
        Climbing employee1 = new Climbing("甲", cyclicBarrier);
        Climbing employee2 = new Climbing("乙", cyclicBarrier);
        Climbing employee3 = new Climbing("丙", cyclicBarrier);
        Climbing employee4 = new Climbing("丁", cyclicBarrier);
        Climbing employee5 = new Climbing("戊", cyclicBarrier);
        Climbing employee6 = new Climbing("己", cyclicBarrier);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(employee1);
        executorService.submit(employee2);
        executorService.submit(employee3);
        executorService.submit(employee4);
        executorService.submit(employee5);
        executorService.submit(employee6);
    }

    public static class Climbing implements Runnable {
        private String name;
        private CyclicBarrier cyclicBarrier;

        public Climbing(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("员工:" + name + "开始爬山~~");
            try {
                long climbingTime = (long) (Math.random() * 4000);
                Thread.sleep(climbingTime);
                System.out.println("员工:" + name + " 用时:" + climbingTime + ",等待人齐去吃饭~~");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
