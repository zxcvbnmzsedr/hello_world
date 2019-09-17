package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 *
 * @author zhaotianzeng
 * @date 2019/9/17 10:22 上午
 * @version V1.0
 */
public class Solution0014 {
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
        if (strs.length == 1) {
            return strs[0];
        }
        String leftStr = strs[0];
        String rightStr = strs[1];
        String temp = findPrefix(leftStr, rightStr);
        for (int i = 2; i < strs.length; i++) {
            temp = findPrefix(temp, strs[i]);
        }
        return temp;
    }

    public String findPrefix(String left, String right) {
        StringBuilder sb = new StringBuilder();
        char[] leftChar = left.toCharArray();
        char[] rightChar = right.toCharArray();
        int i = Math.min(leftChar.length, rightChar.length);
        for (int t = 0; t < i; t++) {
            if (leftChar[t] == rightChar[t]) {
                sb.append(leftChar[t]);
            } else {
                break;
            }
        }
        return sb.toString();


    }
}