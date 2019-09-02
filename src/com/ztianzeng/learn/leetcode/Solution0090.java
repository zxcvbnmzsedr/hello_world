package com.ztianzeng.learn.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * @author zhaotianzeng
 * @date 2019/9/2 10:55 上午
 * @version V1.0
 */
public class Solution0090 {
    @Test
    public void test() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = subsetsWithDup(nums);

        for (List<Integer> subset : subsets) {

            for (Integer integer : subset) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(list, new LinkedList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        // new 出一个对象用于解除引用
        list.add(new LinkedList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            // 去除重复数组
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}