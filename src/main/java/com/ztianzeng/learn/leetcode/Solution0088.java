package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-07-19 14:18
 */
public class Solution0088 {
	@Test
	public void test1() {
		int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
		int m = 3;
		int[] nums2 = new int[]{4, 5, 6};
		int n = 3;
		
		merge(nums1, m, nums2, n);
		int[] res = new int[]{1, 2, 3, 4, 5, 6};
		for (int i = 0; i < nums1.length; i++) {
			Assert.assertEquals(nums1[i], res[i]);
		}
	}
	
	@Test
	public void test2() {
		int[] nums1 = new int[]{0};
		int m = 0;
		int[] nums2 = new int[]{1};
		int n = 1;
		
		merge(nums1, m, nums2, n);
		int[] res = new int[]{1};
		for (int i = 0; i < nums1.length; i++) {
			Assert.assertEquals(nums1[i], res[i]);
		}
	}
	
	/**
	 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
	 * <p>
	 * nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
	 * <p>
	 * 从nums1的数组最后开始往前插入
	 *
	 * @param nums1 num1
	 * @param m     m
	 * @param nums2 nums2
	 * @param n     n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1;
		int p2 = n - 1;
		int current = nums1.length - 1;
		
		while (p1 >= 0 || p2 >= 0) {
			if (p1 < 0) {
				nums1[current--] = nums2[p2--];
				continue;
			}
			if (p2 < 0) {
				nums1[current--] = nums1[p1--];
				continue;
			}
			if (nums1[p1] < nums2[p2]) {
				nums1[current--] = nums2[p2--];
			} else {
				nums1[current--] = nums1[p1--];
			}
		}
		
	}
}