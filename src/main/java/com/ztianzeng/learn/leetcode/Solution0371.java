package com.ztianzeng.learn.leetcode;

import org.junit.Assert;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = -2, b = 3
 * Output: 1
 *
 * 计算a和b的和，但不能用加减。
 *
 * @author zhaotianzeng
 * @date 2019-08-09 17:39
 * @version V1.0
 */
public class Solution0371 {
    public void test() {
        Assert.assertEquals(getSum(1, 2), 3);
        Assert.assertEquals(getSum(-2, 3), 1);

    }

    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}