package com.ztianzeng.learn.leetcode.code;

import org.junit.Test;

/**
 * The type 斐波那契数列.
 */
public class 斐波那契数列 {

    @Test
    public void test() {
        System.out.println(print(10));
        System.out.println(print2(10));
    }

    /**
     * 给定整数N，返回斐波那契数列的第n项
     */
    private int print(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return print(n - 1) + print(n - 2);
    }

    private int print2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res = res + pre;
            pre = temp;
        }
        return res;
    }
}
