package com.ztianzeng.learn.leetcode.code;

import com.ztianzeng.learn.leetcode.PrintUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author: 赵天增
 * @date: 2018 -04-03
 * @描述: 删除重复元素
 */
public class ReptMember {
    /**
     * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
     * <p>
     * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
     */
    @Test
    public void test() {
        PrintUtil.print(containsNearbyAlmostDuplicate(new int[]{-1,-1}, 1, 0));
    }


    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
     * 使 nums [i] 和 nums [j] 的绝对差值最大为 t，
     * 并且 i 和 j 之间的绝对差值最大为 ķ。
     */
    // TODO: 这题不会做
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> in = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            in.put(nums[i], i);
        }



        return false;
    }

    /**
     * 给定一个整数数组和一个整数 k，
     * 判断数组中是否存在两个不同的索引 i 和 j
     * <p>
     * 使 nums [i] = nums [j]，
     * <p>
     * 并且 i 和 j 的绝对差值最大为 k。
     */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> in = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (in.containsKey(nums[i])) {
                if ((i - in.get(nums[i])) <= k) {
                    return true;
                }
            }
            in.put(nums[i], i);

        }
        return false;


    }

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * <p>
     * 如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet h = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!h.add(nums[i])) {
                return true;
            }
        }
        return false;
    }


    /**
     * 假设有一个数组，它的第 i 个元素是一个给定的股票在第 i 天的价格。
     * <p>
     * 设计一个算法来找到最大的利润。你可以完成尽可能多的交易（多次买卖股票）。
     * 然而，你不能同时参与多个交易（你必须在再次购买前出售股票）。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 如果后一天的价格大于前一天的价格
            if (prices[i] > prices[i - 1]) {
                // 利润则是，当天价格减去前一天的价格
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

    public int removeDuplicates(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[length] != nums[i]) {
                length++;
                nums[length] = nums[i];

            }
        }
        return ++length;
    }


}
