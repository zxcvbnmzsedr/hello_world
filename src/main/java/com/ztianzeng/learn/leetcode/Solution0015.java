package com.ztianzeng.learn.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author zhaotianzeng
 * @date 2019-08-20 09:47
 * @version V1.0
 */
public class Solution0015 {
    @Test
    public void test() {
        List<List<Integer>> result = new TwoLink().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test2() {
        List<List<Integer>> result = new TwoLink().threeSum(new int[]{-2, 0, 0, 2, 2});
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /**
     * 双指针
     */
    public static class TwoLink extends Solution0015 {

        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();
            // 排序数组
            Arrays.sort(nums);
            // 固定指针k
            for (int k = 0; k < nums.length - 2; k++) {
                int j = nums.length - 1;
                int i = k + 1;
                // 当 nums[k] > 0 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即 33 个数字都大于 00 ，在此固定指针 k 之后不可能再找到结果了。
                if (nums[k] > 0) {
                    break;
                }
                // 当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                while (i < j) {
                    int s = nums[i] + nums[k] + nums[j];
                    if (s == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        System.out.println("" + i + j + k);
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        result.add(temp);
                        i++;
                        j--;
                    } else if (s < 0) {
                        i++;
                    } else {
                        j--;
                    }
                }

            }
            return new ArrayList<>(result);
        }
    }

    /**
     * 暴力搜索法
     */
    public static class Baoli extends Solution0015 {
        /**
         * 暴力搜索法
         * @param nums
         * @return
         */
        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            result.add(temp);
                        }
                    }
                }
            }
            return result;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

}