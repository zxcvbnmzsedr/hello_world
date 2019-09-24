package com.ztianzeng.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author zhaotianzeng
 * @date 2019/9/7 5:17 下午
 * @version V1.0
 */
public class Solution0056 {
    @Test
    public void test() {
        int[][] intervals = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        int[][] merge = merge(intervals);
        for (int[] interval : merge) {
            System.out.println(Arrays.toString(interval));
        }
    }

    @Test
    public void test2() {
        int[][] intervals = new int[][]{
                {1, 4}, {2, 3}
        };
        int[][] merge = merge(intervals);
        for (int[] interval : merge) {
            System.out.println(Arrays.toString(interval));
        }
    }

    @Test
    public void test3() {
        int[][] intervals = new int[][]{
                {0, 2}, {1, 4}, {3, 5}
        };
        int[][] merge = merge(intervals);
        for (int[] interval : merge) {
            System.out.println(Arrays.toString(interval));
        }
    }

    /**
     * 合并数组
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 对数组每个数组排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 排序后的数组瞅瞅
//        for (int[] interval : intervals) {
//            System.out.println(Arrays.toString(interval));
//        }
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] current = intervals[i];
            if (i == intervals.length - 1) {
                result.add(new int[]{current[0], current[1]});
                break;
            }
            int right = current[1];
            // 向后寻找右边的闭合区间
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            result.add(new int[]{current[0], right});

            i++;
        }


        return result.toArray(new int[][]{});
    }
}