package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 *
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 * @author zhaotianzeng
 * @date 2019/9/24 3:25 下午
 * @version V1.0
 */
public class TwoPointer_数组拆分1 {
    @Test
    public void test() {
        int[] nums = {1, 4, 3, 2};
        int i = arrayPairSum(nums);
        Assert.assertEquals(i, 4);
    }

    @Test
    public void test2() {
        int[] nums = {1, 1};
        int i = arrayPairSum(nums);
        Assert.assertEquals(i, 1);
    }

    public int arrayPairSum(int[] nums) {
        int result = 0;
        qsort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }

    public void qsort(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && nums[j] > pivot) {
                j--;
            }
            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j && nums[i] == nums[j]) {
                i++;
            } else {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (i - 1 > start) {
            qsort(nums, start, i - 1);
        }
        if (j + 1 < end) {
            qsort(nums, j + 1, end);
        }
    }
}