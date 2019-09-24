package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each
 * of them is that adjacent houses have security system connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 *
 *https://leetcode-cn.com/problems/house-robber
 * @author zhaotianzeng
 * @date 2019-07-27 16:09
 * @version V1.0
 */
public class Solution0198 {

    @Test
    public void test1() {
        int rob = rob(new int[]{1, 2, 3, 1});
        Assert.assertEquals(4, rob);
    }

    @Test
    public void test2() {
        int rob = rob(new int[]{2, 7, 9, 3, 1});
        Assert.assertEquals(12, rob);
    }

    @Test
    public void test3() {
        int rob = rob1(new int[]{2, 1, 1, 2});
        Assert.assertEquals(4, rob);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < nums.length + 2; i++) {
            dp[i] = Math.max(nums[i - 2] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length + 1];
    }

    /**
     * 按照追原始的方法
     * 如果一间房 f1 = num[1]
     * 两间房 f2 = num[2],
     * 三间房要看是抢第一间房和当前相加，还是说保留当前最大值 f2
     * 三间房 f3 = max(f1+num[3],f2)
     *
     * 推导出:
     * fk = max(f(k-2)+num[k],f[k-1])
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        return f(nums.length - 1, nums);
    }

    public int f(int k, int[] nums) {
        if (k < 0) {
            return 0;
        }
        return Math.max(f(k - 2, nums) + nums[k], f((k - 1), nums));
    }
}