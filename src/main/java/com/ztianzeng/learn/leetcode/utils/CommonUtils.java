package com.ztianzeng.learn.leetcode.utils;

/**
 * @author zhaotianzeng
 * @date 2019/9/24 7:25 下午
 * @version V1.0
 */
public final class CommonUtils {
    private CommonUtils() {
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}