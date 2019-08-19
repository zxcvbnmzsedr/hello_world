package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序
 *
 * @author zhaotianzeng
 * @date 2019-08-07 13:21
 * @version V1.0
 */
public class Solution0349 {
    @Test
    public void test() {
        int[] one = {1, 2, 2, 1};
        int[] two = {2, 2};
        int[] intersection = intersection(one, two);
        Assert.assertEquals(intersection.length, 1);
        Assert.assertEquals(intersection[0], 2);
    }

    @Test
    public void test2() {
        int[] one = {};
        int[] two = {1, 1};
        int[] intersection = intersection(one, two);
        Assert.assertEquals(intersection.length, 0);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums1) {
            hashSet.add(i);
        }
        Set<Integer> list = new HashSet<>();
        for (int i : nums2) {
            if (hashSet.contains(i)) {
                list.add(i);
            }
        }
        Integer[] boxedArray = list.toArray(new Integer[]{});
        int len = boxedArray.length;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            // checkNotNull for GWT (do not optimize)
            array[i] = boxedArray[i];
        }
        return array;
    }
}