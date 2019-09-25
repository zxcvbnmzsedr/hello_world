package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author zhaotianzeng
 * @date 2019/9/25 8:16 下午
 * @version V1.0
 */
public class String_整数反转 {
    @Test
    public void test1() {
        int reverse = reverse(123);
        Assert.assertEquals(reverse, 321);
    }

    @Test
    public void test2() {
        int reverse = reverse(-123);
        Assert.assertEquals(reverse, -321);
    }

    @Test
    public void test3() {
        int reverse = reverse(120);
        Assert.assertEquals(reverse, 21);
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