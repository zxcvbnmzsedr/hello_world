package com.ztianzeng.learn.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FibonacciTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = 1;
        long end = 1000000000;
//        sum(start, end);

        long startTime = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = new SumTask(start, end);
        pool.submit(task);
        long result = task.get();
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    public static void sum(long start, long end) {
        int result = 0;
        long startTime = System.currentTimeMillis();

        for (long i = start; i <= end; i++) {
            result += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    static final class SumTask extends RecursiveTask<Integer> {
        private static final long serialVersionUID = 1L;

        final long start; //开始计算的数
        final long end; //最后计算的数

        SumTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            //如果计算量小于1000，那么分配一个线程执行if中的代码块，并返回执行结果
            if (end - start < 10000) {
                int sum = 0;
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            }
            //如果计算量大于1000，那么拆分为两个任务
            SumTask task1 = new SumTask(start, (start + end) / 2);
            SumTask task2 = new SumTask((start + end) / 2 + 1, end);
            //执行任务
            task1.fork();
            task2.fork();
            //获取任务执行的结果
            return task1.join() + task2.join();
        }
    }


}
