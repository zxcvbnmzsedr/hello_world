package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @author zhaotianzeng
 * @date 2019/9/28 5:42 下午
 * @version V1.0
 */
public class Sort_合并两个有序数组 {
    @Test
    public void test1() {
        int[] source = {1, 2, 3, 0, 0, 0};
        merge(source, 3, new int[]{2, 5, 6}, 3);
        PrintUtil.print(source);

    }

    @Test
    public void test2() {
        int[] source = {1, 2, 4, 5, 6, 0};
        merge(source, 5, new int[]{3}, 1);
        PrintUtil.print(source);

    }

    @Test
    public void test3() {
        int[] source = {0};
        merge(source, 0, new int[]{1}, 1);
        PrintUtil.print(source);

    }


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
            int p1Num = nums1[p1];
            int p2Num = nums2[p2];
            if (p1Num > p2Num) {
                nums1[current--] = nums1[p1--];
            } else {
                nums1[current--] = nums2[p2--];
            }

        }

    }
}