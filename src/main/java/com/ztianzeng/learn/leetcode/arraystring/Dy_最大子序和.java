package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author zhaotianzeng
 * @date 2019/9/28 8:03 下午
 * @version V1.0
 */
public class Dy_最大子序和 {
    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        PrintUtil.print(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = 0;
        for (int num : nums) {
            if (current < 0) {
                current = num;
            } else {
                current += num;
            }

            max = Math.max(current, max);
        }
        return max;
    }
}