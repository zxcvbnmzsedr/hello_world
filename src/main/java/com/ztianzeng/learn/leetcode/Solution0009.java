package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author zhaotianzeng
 * @date 2019/9/16 3:08 下午
 * @version V1.0
 */
public class Solution0009 {
    @Test
    public void test1() {
        boolean palindrome = isPalindrome(-121);
        Assert.assertFalse(palindrome);
    }

    @Test
    public void test2() {
        boolean palindrome = isPalindrome(121);
        Assert.assertTrue(palindrome);
    }

    @Test
    public void test3() {
        boolean palindrome = isPalindrome(10);
        Assert.assertFalse(palindrome);
    }

    @Test
    public void test4() {
        boolean palindrome = isPalindrome(1001);
        Assert.assertTrue(palindrome);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div > 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;

        }
        return true;


    }
}