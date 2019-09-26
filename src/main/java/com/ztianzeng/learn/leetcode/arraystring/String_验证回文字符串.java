package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * @author zhaotianzeng
 * @date 2019/9/26 10:19 上午
 * @version V1.0
 */
public class String_验证回文字符串 {
    @Test
    public void test1() {
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        Assert.assertTrue(palindrome);
    }

    @Test
    public void test2() {
        boolean palindrome = isPalindrome("race a car");
        Assert.assertFalse(palindrome);
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (handleChar(chars[start]) == ' ') {
                start++;
                continue;
            }
            if (handleChar(chars[end]) == ' ') {
                end--;
                continue;
            }
            if (handleChar(chars[start]) != handleChar(chars[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public char handleChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return c;
        }
        if (c >= '0' && c <= '9') {
            return c;
        }
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return ' ';
    }
}