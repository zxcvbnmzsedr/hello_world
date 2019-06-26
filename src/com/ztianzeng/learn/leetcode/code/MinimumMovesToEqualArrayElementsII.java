package com.ztianzeng.learn.leetcode.code;

import org.junit.Test;

/**
 * 最少移动次数使数组元素相等 II
 *
 * @author: 赵天增
 * @date: 2018 -05-07
 * @see <a href="https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/description/">最少移动次数使数组元素相等</a>
 */
public class MinimumMovesToEqualArrayElementsII {
    @Test
    public void test() {
        System.out.println(minMoves2(new int[]{1, 2}));
    }

    public int minMoves2(int[] nums) {

        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
        int middle = 0;
        // 偶数个
        if (length % 2 == 0) {
            middle = (nums[length / 2] + nums[length / 2 - 1]) / 2;
        } else {
            middle = nums[length / 2];
        }
        int ret = 0;
        for (int num : nums) {
            ret += Math.abs(num - middle);
        }
        return ret;
    }
}
