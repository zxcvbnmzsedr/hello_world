package com.ztianzeng.learn.leetcode;

import org.junit.Test;

public class Solution0387 {


    @Test
    public void test() {
        int leetcode = firstUniqChar("leetcode");
        System.out.println(leetcode);
    }

    public int firstUniqChar(String s) {
        int[] noRepeat = new int[256];
        for (int i = 0; i < s.length(); i++) {
            noRepeat[s.charAt(i)] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (noRepeat[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
