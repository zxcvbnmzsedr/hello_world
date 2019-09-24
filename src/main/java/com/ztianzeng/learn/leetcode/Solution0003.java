package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author zhaotianzeng
 * @date 2019-08-19 11:02
 * @version V1.0
 */
public class Solution0003 {
    @Test
    public void test() {
        int abcabcbb = lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(3, abcabcbb);
    }

    @Test
    public void test2() {
        int abcabcbb = lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(1, abcabcbb);
    }

    @Test
    public void test3() {
        int abcabcbb = lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(3, abcabcbb);
    }

    @Test
    public void test6() {
        int abcabcbb = lengthOfLongestSubstring("aab");
        Assert.assertEquals(2, abcabcbb);
    }


    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0, j = 0; i < chars.length; i++) {
            Character c = chars[i];
            if (map.containsKey(c)) {
                j = Math.max(map.get(c), j);
            }
            res = Math.max(res, i - j + 1);
            map.put(c, i + 1);
        }

        return res;
    }

}