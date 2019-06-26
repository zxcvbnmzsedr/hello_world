package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static com.ztianzeng.learn.leetcode.PrintUtil.print;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * <a href='https://github.com/zxcvbnmzsedr/leetcode/blob/master/problems/26.remove-duplicates-from-sorted-array.md'></a>
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-26 21:53
 */
public class RemoveDuplicatesFromSortArray {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 2, 3};
        int len = removeDuplicates(nums);
        Assert.assertEquals(len, 3);
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        // 快指针
        int pre = 0;
        // 慢指针
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[pre] == nums[cur]) {
                pre++;
            } else {
                cur++;
                nums[cur] = nums[pre];
                pre++;
            }
        }
        return cur + 1;
    }
}