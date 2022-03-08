package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_2055 {
    @Test
    public void test() {
        int[] res = platesBetweenCandles("**|**|***|", new int[][]{
                {2, 5}, {5, 9}
        });
        Assert.assertEquals(2, res[0]);
        Assert.assertEquals(3, res[1]);
    }

    @Test
    public void test2() {
        int[] res = platesBetweenCandles("***|**|*****|**||**|*", new int[][]{
                {1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}
        });
        Assert.assertEquals(9, res[0]);
        Assert.assertEquals(0, res[1]);
        Assert.assertEquals(0, res[2]);
        Assert.assertEquals(0, res[3]);
        Assert.assertEquals(0, res[4]);
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            res[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return res;
    }
}