package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author zhaotianzeng
 * @date 2019/9/25 1:53 下午
 * @version V1.0
 */
public class Array_两个数组的交集2 {
    @Test
    public void test1() {
        int[] intersect = intersect(new int[]{1, 2, 2, 1}, new int[]{2});
        PrintUtil.print(intersect);
    }

    @Test
    public void test2() {
        int[] intersect = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        PrintUtil.print(intersect);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] m = new int[nums1.length];
        int j = 0;
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int i : nums1) {
            if (numCount.containsKey(i)) {
                numCount.replace(i, numCount.get(i) + 1);
            } else {
                numCount.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (numCount.containsKey(i)) {
                m[j++] = i;
                Integer integer = numCount.get(i);
                if (integer > 1) {
                    numCount.replace(i, integer - 1);
                } else {
                    numCount.remove(i);
                }
            }
        }
        return Arrays.copyOf(m, j);
    }
}