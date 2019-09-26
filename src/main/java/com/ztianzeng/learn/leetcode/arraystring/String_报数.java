package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 * @author zhaotianzeng
 * @date 2019/9/26 2:22 下午
 * @version V1.0
 */
public class String_报数 {
    @Test
    public void test1() {
        String s = countAndSay(1);
        Assert.assertEquals(s, "1");
    }

    @Test
    public void test2() {
        String s = countAndSay(6);
        Assert.assertEquals(s, "312211");
    }

    public String countAndSay(int n) {
        String[] strings = new String[31];
        strings[0] = "1";

        for (int i = 1; i < n; i++) {
            String ts = strings[i - 1], rs = "";
            char tc = ts.charAt(0);
            int cnt = 0;
            for (char c : ts.toCharArray()) {
                if (c == tc) {
                    cnt++;
                } else {
                    rs = rs + cnt + tc;
                    tc = c;
                    cnt = 1;
                }
            }
            rs = rs + cnt + tc;
            strings[i] = rs;
        }
        return strings[n - 1];
    }
}