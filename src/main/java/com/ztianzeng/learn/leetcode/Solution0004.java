package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author zhaotianzeng
 * @date 2019/9/10 3:18 下午
 * @version V1.0
 */
public class Solution0004 {
    @Test
    public void test() {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        Assert.assertEquals(medianSortedArrays, 2.0, 0);
    }

    @Test
    public void test1() {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        Assert.assertEquals(medianSortedArrays, 2.5, 0);
    }

    /**
     * 暴力解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            a[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            a[i + nums1.length] = nums2[i];
        }
        Arrays.sort(a);

        double j;
        if (a.length % 2 == 0) {
            j = (a[a.length / 2 - 1] + a[a.length / 2]) / 2d;
        } else {
            j = a[a.length / 2];
        }
        return j;
    }
}