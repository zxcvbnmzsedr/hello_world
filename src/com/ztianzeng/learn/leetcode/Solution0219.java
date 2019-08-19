package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 *：https://leetcode-cn.com/problems/contains-duplicate-ii
 *
 * @author zhaotianzeng
 * @date 2019-07-30 16:46
 * @version V1.0
 */
public class Solution0219 {
    @Test
    public void test() {
        Assert.assertTrue(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        Assert.assertTrue(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        Assert.assertFalse(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    @Test
    public void test2() {
        Assert.assertTrue(containsNearbyDuplicate(new int[]{99, 99}, 2));
    }

    @Test
    public void test3() {
        Assert.assertFalse(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 数，index
        Map<Integer, Integer> kP = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (kP.containsKey(nums[i])){
                if (Math.abs(i - kP.get(nums[i])) <= k) {
                    return true;
                }
            }
            kP.put(nums[i], i);
        }
        return false;
    }

}