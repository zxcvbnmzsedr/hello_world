package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 *
 *
 * @author zhaotianzeng
 * @date 2019-07-26 14:28
 * @version V1.0
 */
public class Solution0167 {
    @Test
    public void test() {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertEquals(ints[0], 1);
        Assert.assertEquals(ints[1], 2);
    }

    /**
     * 双重暴力循环
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right && numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{left + 1, right + 1};
    }

    /**
     * 双重暴力循环
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int one = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int two = numbers[j];
                if (one + two == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{};
    }

}