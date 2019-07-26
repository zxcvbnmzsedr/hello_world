package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 *
 * @author zhaotianzeng
 * @date 2019-07-26 15:13
 * @version V1.0
 */
public class FactorialTrailingZeroes {
    @Test
    public void test() {
        int i = trailingZeroes(3);
        Assert.assertEquals(i, 0);
    }

    @Test
    public void test1() {
        int i = trailingZeroes(5);
        Assert.assertEquals(i, 1);
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}