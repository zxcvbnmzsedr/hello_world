package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *注意:
 *                                                       31  31
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2,  2 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author zhaotianzeng
 * @date 2019/9/12 5:28 下午
 * @version V1.0
 */
public class Solution0007 {
    @Test
    public void test() {
        Assert.assertEquals(reverse(123), 321);
    }

    @Test
    public void test2() {
        Assert.assertEquals(reverse(-12), -21);
    }

    @Test
    public void test3() {
        Assert.assertEquals(reverse(120), 21);
    }

    @Test
    public void test4() {
        Assert.assertEquals(reverse(1534236469), 0);
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            result = result * 10 + pop;
        }


        return result;
    }
}