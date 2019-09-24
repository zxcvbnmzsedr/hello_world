package com.ztianzeng.learn.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * @author zhaotianzeng
 * @date 2019/9/24 6:10 下午
 * @version V1.0
 */
public class Array_最大连续1的个数 {
    @Test
    public void test() {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        Assert.assertEquals(maxConsecutiveOnes, 3);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currMax++;
            } else {
                max = Math.max(currMax, max);

                currMax = 0;
            }
        }
        max = Math.max(currMax, max);

        return max;
    }
}