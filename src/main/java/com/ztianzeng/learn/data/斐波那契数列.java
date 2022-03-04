package com.ztianzeng.learn.data;

import org.junit.Test;

import java.util.Stack;

/**
 * @author zhaotianzeng
 */
@SuppressWarnings("all")
public class 斐波那契数列 {

    @Test
    public void test() {
        System.out.println(fib(40));
        System.out.println(fib2(41));
    }

    public int fib(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    public int fib2(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(1);

        int k = 3;
        while (k <= n) {
            Integer f1 = stack.pop();
            Integer f2 = stack.pop();
            stack.push(f1 + f2);
            stack.push(f2);
            k++;
        }
        stack.pop();
        return stack.pop();

    }

}
