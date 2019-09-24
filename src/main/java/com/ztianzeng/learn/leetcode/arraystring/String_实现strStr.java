package com.ztianzeng.learn.leetcode.arraystring;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * @author zhaotianzeng
 * @date 2019/9/23 8:15 下午
 * @version V1.0
 */
public class String_实现strStr {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        return new KMP(needle).search(haystack);
    }

    public static class KMP {
        private String pat;
        private int[][] dp;

        public KMP(String pat) {
            this.pat = pat;
            this.dp = new int[pat.length()][256];
            dp[0][pat.charAt(0)] = 1;
            int X = 0;
            for (int i = 1; i < pat.length(); i++) {
                for (int c = 0; c < 255; c++) {
                    if (c == pat.charAt(i)) {
                        dp[i][c] = i + 1;
                    } else {
                        dp[i][c] = dp[X][c];
                    }
                }
                X = dp[X][pat.charAt(i)];
            }
        }

        public int search(String txt) {
            int N = txt.length();
            int M = pat.length();
            int j = 0;
            for (int i = 0; i < N; i++) {
                j = dp[j][txt.charAt(i)];
                if (j == pat.length()) {
                    return i - M + 1;
                }
            }
            return -1;
        }
    }
}