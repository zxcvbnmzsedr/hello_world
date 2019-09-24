package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * @author zhaotianzeng
 * @date 2019/9/24 6:17 下午
 * @version V1.0
 */
public class QMPointer_长度最小的子数组 {
    @Test
    public void test1() {
        int i = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        Assert.assertEquals(i, 2);
    }

    public int minSubArrayLen(int s, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 1;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while (currentSum >= s) {
                minLength = Math.min(i + 1 - left, minLength);
                left++;
                currentSum -= nums[left];
            }

        }
        return minLength;

    }
}