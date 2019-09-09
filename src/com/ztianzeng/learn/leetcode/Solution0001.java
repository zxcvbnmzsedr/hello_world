package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author zhaotianzeng
 * @date 2019/9/9 5:05 下午
 * @version V1.0
 */
public class Solution0001 {
    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        Assert.assertEquals(ints[0], 1);
        Assert.assertEquals(ints[1], 0);
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 3};
        int[] ints = twoSum(nums, 6);
        Assert.assertEquals(ints[0], 2);
        Assert.assertEquals(ints[1], 0);
    }

    @Test
    public void test3() {
        int[] nums = {3, 2, 4};
        int[] ints = twoSum(nums, 6);
        Assert.assertEquals(ints[0], 2);
        Assert.assertEquals(ints[1], 1);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer != null) {
                return new int[]{i, integer};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}