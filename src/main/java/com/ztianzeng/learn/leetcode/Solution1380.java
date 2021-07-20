package com.ztianzeng.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * 示例 1：
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 * <p>
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <=matrix[i][j]<= 10^5
 * 矩阵中的所有元素都是不同的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1380 {

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println(luckyNumbers(matrix));
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println(luckyNumbers(matrix));
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[][] minIndex = new int[matrix.length][matrix[0].length];
        int[][] maxIndex = new int[matrix.length][matrix[0].length];
        for (int y = 0; y < matrix.length; y++) {
            int min = matrix[y][0];
            // 找到同行的最小的一个元素和索引
            int minX = 0, minY = 0;
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] <= min) {
                    min = matrix[y][x];
                    minX = x;
                    minY = y;
                }
            }
            minIndex[minY][minX] = 1;
        }

        for (int x = 0; x < matrix[0].length; x++) {
            int max = matrix[0][x];
            int maxX = 0, maxY = 0;

            for (int y = 0; y < matrix.length; y++) {
                if (matrix[y][x] >= max) {
                    max = matrix[y][x];
                    maxX = x;
                    maxY = y;
                }
            }
            maxIndex[maxY][maxX] = 1;
        }

        for (int y = 0; y < minIndex.length; y++) {
            for (int x = 0; x < minIndex[y].length; x++) {
                if ((minIndex[y][x] == 1) && (maxIndex[y][x] == 1)) {
                    result.add(matrix[y][x]);
                }
            }
        }
        return result;
    }
}
