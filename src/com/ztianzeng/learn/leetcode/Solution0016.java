package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @author zhaotianzeng
 * @date 2019/9/17 11:06 上午
 * @version V1.0
 */
public class Solution0016 {
    @Test
    public void test1() {
        // -4，-1，1，2
        int[] nums = {-1, 2, 1, -4};
        int i = threeSumClosest(nums, 1);
        Assert.assertEquals(i, 2);
    }

    @Test
    public void test2() {
        int[] nums = {0, 1, 2};
        int i = threeSumClosest(nums, 3);
        Assert.assertEquals(i, 3);
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, -1};
        int i = threeSumClosest(nums, 2);
        Assert.assertEquals(i, 1);
    }

    @Test
    public void test4() {
        int[] nums = {1, 1, 1, 0};
        int i = threeSumClosest(nums, -100);
        Assert.assertEquals(i, 2);
    }

    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);

        // 固定指针k
        for (int k = 0; k < nums.length; k++) {
            int leftLink = k + 1;
            int rightLink = nums.length - 1;

            while (leftLink < rightLink) {
                // 三个数相加必须最接近target
                int sum = nums[leftLink] + nums[rightLink] + nums[k];
                int offset = Math.abs(target - sum);

                if (offset <= min) {
                    result = sum;
                    min = offset;
                }
                if (sum > target) {
                    rightLink--;
                } else {
                    leftLink++;
                }

            }
        }
        return result;
    }
}