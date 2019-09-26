package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author zhaotianzeng
 * @date 2019/9/26 9:41 上午
 * @version V1.0
 */
public class String_有效的字母异位词 {
    @Test
    public void test1() {
        Assert.assertTrue(isAnagram("anagram", "nagaram"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(isAnagram("rat", "cat"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(isAnagram("aacc", "ccac"));
    }

    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        if (sChar.length != tChar.length) {
            return false;
        }
        for (int i = 0; i < sChar.length; i++) {
            map[sChar[i] - 'a'] += 1;
            map[tChar[i] - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}