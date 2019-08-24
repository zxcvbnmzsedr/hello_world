package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 * @author zhaotianzeng
 * @date 2019/8/24 2:10 下午
 * @version V1.0
 */
public class Solution0029 {
    @Test
    public void test1() {
        int divide = divide(10, 3);
        Assert.assertEquals(divide, 3);
    }

    @Test
    public void test2() {
        int divide = divide(7, -3);
        Assert.assertEquals(divide, -2);
    }

    @Test
    public void test3() {
        int divide = divide(-1, -1);
        Assert.assertEquals(divide, 1);
    }

    @Test
    public void test4() {
        int divide = divide(-2147483648, -1);
        Assert.assertEquals(divide, 2147483647);
    }

    @Test
    public void test5() {
        int divide = divide(-2147483648, 1);
        Assert.assertEquals(divide, -2147483648);
    }

    @Test
    public void test6() {
        int divide = divide(-2147483648, 2);
        Assert.assertEquals(divide, -1073741824);
    }

    /**
     * 除法的本质是减肥
     * 10 /3 == 10 减去3 减三次
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = dividend > 0 != divisor > 0;
        // 用long这样取绝对值的时候才不会溢出。
        long dividendP = dividend < 0 ? -(long) dividend : (long) dividend;
        long divisorP = divisor < 0 ? -(long) divisor : (long) divisor;


        int res = 0;

        while (dividendP >= divisorP) {
            long tmpDivisor = divisorP;
            int count = 1;
            // 在小于总数的时候，进行指数级别的递增
            while (tmpDivisor <= dividendP) {
                dividendP -= tmpDivisor;
                res += count;
                count += 1;
                tmpDivisor = divisorP * count;
            }
        }

        double MAX_INTERGER = Math.pow(2, 31);

        // overflow
        if (res > MAX_INTERGER - 1 || res < -1 * MAX_INTERGER) {
            return (int) (MAX_INTERGER - 1);
        }
        return isNegative ? -1 * res : res;
    }
}