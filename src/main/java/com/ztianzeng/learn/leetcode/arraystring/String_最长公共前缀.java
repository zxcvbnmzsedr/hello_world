package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * @author zhaotianzeng
 * @date 2019/9/24 2:12 下午
 * @version V1.0
 */
public class String_最长公共前缀 {
    @Test
    public void test1() {
        String[] strs = {"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);
        Assert.assertEquals(s, "fl");
    }

    @Test
    public void test2() {
        String[] strs = {"dog", "racecar", "car"};
        String s = longestCommonPrefix(strs);
        Assert.assertEquals(s, "");
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String longStr = strs[0];

        for (int i = 1; i < strs.length; i++) {
            longStr = longest(longStr, strs[i]);
        }
        return longStr;

    }

    public String longest(String left, String right) {
        char[] leftChar = left.toCharArray();
        char[] rightChar = right.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = Math.min(leftChar.length, rightChar.length);
        for (int j = 0; j < i; j++) {
            if (leftChar[j] == rightChar[j]) {
                sb.append(leftChar[j]);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}