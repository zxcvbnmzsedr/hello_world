package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example 1:
 *
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 *
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * Example 3:
 *
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 *
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * @author zhaotianzeng
 * @date 2019-07-30 18:22
 * @version V1.0
 */
public class Solution0263 {

    @Test
    public void test() {
        Assert.assertTrue(isUgly(6));
        Assert.assertTrue(isUgly(8));
        Assert.assertFalse(isUgly(14));
        Assert.assertFalse(isUgly(0));
    }

    public boolean isUgly(int num) {
        if (num == 0){
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}