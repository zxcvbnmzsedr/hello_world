package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
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
 *
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 *
 * @author zhaotianzeng
 * @date 2019-07-24 21:39
 * @version V1.0
 */
public class ValidPalindrome {

    @Test
    public void test() {
        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(isPalindrome("race a car"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isPalindrome(".,"));
    }

    @Test
    public void test4() {
        Assert.assertTrue(isPalindrome("a."));
    }

    @Test
    public void test5() {
        Assert.assertFalse(isPalindrome("0P"));
    }

    /**
     * 执行用时 : 12 ms, 在所有 Java 提交中击败了72.17%的用户
     * 内存消耗 :39.6MB, 在所有 Java 提交中击败了47.36%的用户
     *
     * 使用 头尾双指针
     * @param s 需要验证的字符串
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        int head = 0;
        int tail = s.length() - 1;

        while (head < tail) {
            char headChar = s.charAt(head);

            if (!isValid(headChar)) {
                head++;
                continue;
            }
            char tailChar = s.charAt(tail);
            if (!isValid(tailChar)) {
                tail--;
                continue;
            }
            if (headChar != tailChar) {
                return false;
            } else {
                head++;
                tail--;
            }
        }
        return true;
    }

    private boolean isValid(char headChar) {
        if (headChar >= 48 && headChar <= 57) {
            return true;
        }
        if (headChar >= 97 && headChar <= 122) {
            return true;
        }
        if (headChar == ' ') {
            return false;
        }
        return false;
    }
}