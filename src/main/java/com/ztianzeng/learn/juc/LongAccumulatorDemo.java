package com.ztianzeng.learn.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

public class LongAccumulatorDemo {

    public static void main(String[] args) throws InterruptedException {

        LongAccumulator accumulator = new LongAccumulator((x, y) -> x * y, 1);

        ExecutorService executor = Executors.newFixedThreadPool(8);

        IntStream.range(1, 10).forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

//        Thread.sleep(2000);

        System.out.println(accumulator.getThenReset());

    }

}