package com.ztianzeng.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * 给予一个不同数字的数组，返回所有可能的子集
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @author zhaotianzeng
 * @date 2019/9/2 10:44 上午
 * @version V1.0
 */
public class Solution0078 {
    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);

        for (List<Integer> subset : subsets) {

            for (Integer integer : subset) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();

        backtrack(list, new LinkedList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        // new 出一个对象用于解除引用
        list.add(new LinkedList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}