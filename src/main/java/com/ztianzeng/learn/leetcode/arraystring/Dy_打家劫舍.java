package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author zhaotianzeng
 * @date 2019/9/28 8:22 下午
 * @version V1.0
 */
public class Dy_打家劫舍 {
    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 1};
        Assert.assertEquals(rob(nums), 4);
    }

    @Test
    public void test2() {
        int[] nums = {2, 1};
        Assert.assertEquals(rob(nums), 2);
    }

    @Test
    public void test3() {
        int[] nums = {2, 1, 1, 2};
        Assert.assertEquals(rob(nums), 4);
    }

    /**
     * 动态规范
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < nums.length + 2; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }
        return dp[nums.length + 1];
    }


}