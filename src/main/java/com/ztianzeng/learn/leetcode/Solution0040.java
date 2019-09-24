package com.ztianzeng.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * @author zhaotianzeng
 * @date 2019/9/4 4:51 下午
 * @version V1.0
 */
public class Solution0040 {
    @Test
    public void test() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = combinationSum2(candidates, 8);
        for (List<Integer> subset : lists) {

            for (Integer integer : subset) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    @Test
    public void test2() {
        int[] candidates = {3, 1, 3, 5, 1, 1};
        List<List<Integer>> lists = combinationSum2(candidates, 8);
        for (List<Integer> subset : lists) {

            for (Integer integer : subset) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, new boolean[candidates.length], 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int target, boolean[] used, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
        } else if (target < 0) {
            return;
        } else {
            for (int i = index; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(list, tempList, nums, target - nums[i], used, i + 1);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}