package com.ztianzeng.learn.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * @author zhaotianzeng
 * @date 2019/9/23 8:15 下午
 * @version V1.0
 */
public class String_二进制求和 {
    @Test
    public void test1() {
        String s = addBinary("11", "1");
        Assert.assertEquals(s, "100");
    }

    @Test
    public void test2() {
        String s = addBinary("1010", "1011");
        Assert.assertEquals(s, "10101");
    }

    /**
     * 2ms
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int aLink = aChar.length - 1;
        int bLink = bChar.length - 1;
        int t = 0;
        int sum;
        char[] result = new char[Math.max(aChar.length, bChar.length)];
        int index = result.length - 1;
        while (aLink >= 0 || bLink >= 0) {
            if (aLink >= 0 && bLink >= 0) {
                sum = t + getCharInt(aChar[aLink--]) + getCharInt(bChar[bLink--]);
            } else if (aLink >= 0) {
                sum = t + getCharInt(aChar[aLink--]);
            } else {
                sum = t + getCharInt(bChar[bLink--]);
            }

            if (sum >= 2) {
                t = 1;
            } else {
                t = 0;
            }
            result[index--] = getIntChar(sum % 2);
        }
        if (t != 0) {
            char[] newIn = new char[result.length + 1];
            newIn[0] = getIntChar(t);
            System.arraycopy(result, 0, newIn, 1, result.length);
            return new String(newIn, 0, newIn.length);
        }
        return new String(result, 0, result.length);
    }

    private int getCharInt(char c) {
        return c == '0' ? 0 : 1;
    }

    private char getIntChar(int c) {
        return c == 0 ? '0' : '1';
    }

}