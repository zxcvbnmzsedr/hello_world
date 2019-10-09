package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 *   Your Solution object will be instantiated and called as such:
 *   Solution obj = new Solution(nums);
 *   int[] param_1 = obj.reset();
 *   int[] param_2 = obj.shuffle();
 *
 * @author zhaotianzeng
 * @date 2019/10/9 3:00 下午
 * @version V1.0
 */
public class De_打乱一个没有重复元素的数组 {

    @Test
    public void test() {
        Solution obj = new Solution(new int[]{1, 2, 3});
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
        PrintUtil.print(param_1);
        PrintUtil.print(param_2);
    }

    class Solution {
        int[] nums;
        Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] newNums = Arrays.copyOf(nums, nums.length);

            for (int i = 0; i < newNums.length; i++) {
                int r = random.nextInt(newNums.length - i) + i;
                int s = newNums[i];
                newNums[i] = newNums[r];
                newNums[r] = s;
            }
            return newNums;
        }
    }
}