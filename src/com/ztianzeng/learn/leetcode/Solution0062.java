package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 *
 * Input: m = 7, n = 3
 * Output: 28
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * @author zhaotianzeng
 * @date 2019/9/9 3:56 下午
 * @version V1.0
 */
public class Solution0062 {
    @Test
    public void test() {
        int i = uniquePaths(3, 2);
        Assert.assertEquals(i, 3);
    }

    @Test
    public void test1() {
        int i = uniquePaths(7, 3);
        Assert.assertEquals(i, 28);
    }

    public int uniquePaths(int m, int n) {
        return uniquePaths(m, n, new int[m + 1][n + 1]);
    }

    public int uniquePaths(int m, int n, int[][] a) {
        if (m == 0 && n == 0) {
            return 0;
        } else if (m == 1 || n == 1) {
            //只能一直向右走或者一直向下走，所以路径数为 1
            return 1;
        } else if (((m == 2 && n >= 2) || (n == 2 && m >= 2))) {
            return Math.max(m, n);

        }
        // 使用数组记录重复计算的值
        if (a[m][n] > 0) {
            return a[m][n];
        }

        a[m - 1][n] = uniquePaths(m - 1, n, a);
        a[m][n - 1] = uniquePaths(m, n - 1, a);
        a[m][n] = a[m - 1][n] + a[m][n - 1];
        return a[m][n];
    }

}