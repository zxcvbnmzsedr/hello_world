package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 * @author zhaotianzeng
 * @date 2019/9/12 5:53 下午
 * @version V1.0
 */
public class Solution0008 {
    @Test
    public void test() {
        Assert.assertEquals(myAtoi("42"), 42);
    }

    @Test
    public void test2() {
        Assert.assertEquals(myAtoi("   -42"), -42);
    }

    @Test
    public void test3() {
        Assert.assertEquals(myAtoi("4193 with words"), 4193);
    }

    @Test
    public void test4() {
        Assert.assertEquals(myAtoi("words and 987"), 0);
    }

    @Test
    public void test5() {
        Assert.assertEquals(myAtoi("-91283472332"), -2147483648);
    }

    @Test
    public void test6() {
        Assert.assertEquals(myAtoi("+1"), 1);
    }

    @Test
    public void test7() {
        Assert.assertEquals(myAtoi("+-2"), 0);
    }

    @Test
    public void test8() {
        Assert.assertEquals(myAtoi("  -0012a42"), -12);
    }

    @Test
    public void test9() {
        Assert.assertEquals(myAtoi("   +0 123"), 0);
    }

    @Test
    public void test10() {
        Assert.assertEquals(myAtoi("2147483648"), 2147483647);
    }

    @Test
    public void test11() {
        Assert.assertEquals(myAtoi("0-1"), 0);
    }

    @Test
    public void test12() {
        Assert.assertEquals(myAtoi("-   234"), 0);
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        boolean overZ = true;
        boolean hasSymbol = false;
        boolean hasNumber = false;
        int i = 0;
        while (i < chars.length) {
            char currentChar = chars[i];
            if (i > 0) {
                char preChar = chars[i - 1];
                // 符号后面必须更数字
                if ((preChar == '-' || preChar == '+') && (currentChar < '0' || currentChar > '9')) {
                    return overZ ? result : -result;

                }
                // 数字后面必须更数字
                if ((preChar >= '0' && preChar <= '9') && (currentChar < '0' || currentChar > '9')) {
                    return overZ ? result : -result;

                }

            }
            // 前一个字符必须是
            if (currentChar == ' ') {
                i++;
                continue;
            }
            if (currentChar >= 'a' && currentChar <= 'z') {
                return 0;
            }
            int sp = currentChar - 48;
            if (currentChar == '-' || currentChar == '+') {
                overZ = currentChar == '+';
                i++;
                continue;
            }

            long r = (long) result * (long) 10;
            if ((int) r != r) {
                return overZ ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            int addR = sp + result * 10;
            // HD 2-12 Overflow iff both arguments have the opposite sign of the result
            if (((sp ^ addR) & (result * 10 ^ addR)) < 0) {
                return overZ ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = addR;
            i++;
        }


        return overZ ? result : -result;
    }
}