package com.ztianzeng.learn.juc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PriceDemo {

    public static void main(String[] args) throws InterruptedException {
        PriceDemo priceDemo = new PriceDemo();
        System.out.println(priceDemo.getPrices());
    }

    private Set<String> getPrices() throws InterruptedException {
        Set<String> prices = Collections.synchronizedSet(new HashSet<>());
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task("国行", prices));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task("海航", prices));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task("东航", prices));
        CompletableFuture<Void> allTask = CompletableFuture.allOf(task1, task2, task3);
        try {
            allTask.get(3,TimeUnit.SECONDS);
        } catch (ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return prices;
    }

    /**
     * 获取价格
     */
    private class Task implements Runnable {
        private String name;
        private Set<String> prices;

        public Task(String name, Set<String> prices) {
            this.name = name;
            this.prices = prices;
        }

        @Override
        public void run() {
            try {
                int price = (int) (Math.random() * 4000);
                Thread.sleep(price);
                prices.add(name + ": " + price);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
