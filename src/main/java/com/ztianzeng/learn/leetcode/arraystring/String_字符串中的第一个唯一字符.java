package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author zhaotianzeng
 * @date 2019/9/25 8:31 下午
 * @version V1.0
 */
public class String_字符串中的第一个唯一字符 {
    @Test
    public void test1() {
        int leetcode = firstUniqChar("leetcode");
        Assert.assertEquals(leetcode, 0);
    }

    @Test
    public void test2() {
        int leetcode = firstUniqChar("loveleetcode");
        Assert.assertEquals(leetcode, 2);
    }

    @Test
    public void test3() {
        int leetcode = firstUniqChar("cc");
        Assert.assertEquals(leetcode, -1);
    }

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return -1;
        }
        int[] map = new int[256];
        for (char aChar : chars) {
            map[aChar] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}