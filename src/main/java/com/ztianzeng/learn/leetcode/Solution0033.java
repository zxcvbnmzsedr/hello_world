package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Suppose an array sorted in ascending order is rotated at somepivot  unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * @author zhaotianzeng
 * @date 2019/8/30 2:19 下午
 * @version V1.0
 */
public class Solution0033 {

    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(4, search(nums, 0));
    }

    @Test
    public void test2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(-1, search(nums, 3));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int last = nums[nums.length - 1];
        int first = nums[0];


        if (target >= first) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
        } else if (target > last) {
            return -1;
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    return i;
                }
            }
        }
        return -1;
    }
}