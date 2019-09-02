package com.ztianzeng.learn.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 非重复数组，返回所有有可能的排列组合
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @author zhaotianzeng
 * @date 2019/9/2 11:07 上午
 * @version V1.0
 */
public class Solution0046 {
    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = permute(nums);

        for (List<Integer> subset : subsets) {

            for (Integer integer : subset) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        backtrack(list, new LinkedList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new LinkedList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}