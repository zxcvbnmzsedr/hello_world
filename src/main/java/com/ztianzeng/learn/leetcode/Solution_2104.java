package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_2104 {
    @Test
    public void t() {
        Assert.assertEquals(subArrayRanges(new int[]{1, 2, 3}), 4);
    }

    @Test
    public void t2() {
        Assert.assertEquals(subArrayRanges(new int[]{4, -2, -3, 4, 1}), 59);
    }

    public long subArrayRanges(int[] nums) {
//        int left = 0;
//        int right = 1;
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        long res = 0;
        for (int left = 0; left < n; left++) {
            int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
            for (int right = left; right < n; right++) {
                minVal = Math.min(minVal, nums[right]);
                maxVal = Math.max(maxVal, nums[right]);
                System.out.println(maxVal + "-" + minVal);
                res += maxVal - minVal;
            }
        }
        return res;
    }
}