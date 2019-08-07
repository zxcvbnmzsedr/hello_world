package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * @author zhaotianzeng
 * @date 2019-08-07 10:53
 * @version V1.0
 */
public class PowerOfFour {

    @Test
    public void test1() {
        Assert.assertTrue(isPowerOfFour2(16));
    }

    @Test
    public void test2() {
        Assert.assertFalse(isPowerOfFour2(5));
    }

    public boolean isPowerOfFour(int num) {
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }
    public boolean isPowerOfFour2(int num) {
        if (num == 1) {
            return true;
        }
        if (num < 4) {
            return false;
        }

        if ((num & (num - 1)) != 0) {
            return false;
        }

        return (num & 0x55555555) == num;
    }
}