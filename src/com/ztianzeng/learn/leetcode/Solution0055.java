package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 *
 * @author zhaotianzeng
 * @date 2019/9/7 4:44 下午
 * @version V1.0
 */
public class Solution0055 {
    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean can = canJump(nums);
        Assert.assertTrue(can);
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 1, 0, 4};
        boolean can = canJump(nums);
        Assert.assertFalse(can);
    }

    @Test
    public void test3() {
        int[] nums = {2, 0};
        boolean can = canJump(nums);
        Assert.assertTrue(can);
    }

    /**
     * 查询每一个元素说能够跳跃的最远的位置
     * # 3, 2, 1, 0, 4。
     * 3 -> 0+3
     * 2 -> 1+1
     * 1 -> 2+1
     * 0 -> 3+0
     * 4 -> 4+4
     * 到0的时候max最大为3，永远走不到4
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }

        return true;
    }
}
