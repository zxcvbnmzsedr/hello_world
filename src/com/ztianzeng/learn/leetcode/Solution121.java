package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author zhaotianzeng
 * @date 2019-07-22 18:03
 * @version V1.0
 */
public class Solution121 {
    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        Assert.assertEquals(i, 5);
    }

    @Test
    public void test2() {
        int[] prices = new int[]{};
        int i = maxProfit(prices);
        Assert.assertEquals(i, 0);
    }

    @Test
    public void test3() {
        int[] prices = new int[]{1, 2};
        int i = maxProfit(prices);
        Assert.assertEquals(i, 1);
    }

    /**
     * 最大利润计算
     * 波峰 - 波谷
     *
     * @param prices 价格表
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max = Math.max(prices[i] - min, max);
            } else {
                min = Math.min(min, prices[i]);
            }
        }
        return max;
    }
}