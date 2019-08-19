package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author zhaotianzeng
 * @date 2019-07-30 18:33
 * @version V1.0
 */
public class Solution0283 {
    @Test
    public void test() {
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes(ints);
        Assert.assertEquals(Arrays.toString(ints), "[1, 3, 12, 0, 0]");
    }

    @Test
    public void test2() {
        int[] ints2 = {0, 1};
        moveZeroes(ints2);
        Assert.assertEquals(Arrays.toString(ints2), "[1, 0]");
    }

    /**
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = nums.length -1; i >= index; i--) {
            nums[i] = 0;
        }
    }
}