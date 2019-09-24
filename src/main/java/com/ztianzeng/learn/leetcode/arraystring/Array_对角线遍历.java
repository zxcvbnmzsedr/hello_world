package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 *
 *
 * 示例:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * @author zhaotianzeng
 * @date 2019/9/23 1:43 下午
 * @version V1.0
 */
public class Array_对角线遍历 {
    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] diagonalOrder = findDiagonalOrder(matrix);
        PrintUtil.print(diagonalOrder);
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{{3}, {2}};
        int[] diagonalOrder = findDiagonalOrder(matrix);
        PrintUtil.print(diagonalOrder);
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int x = 0;
        int y = 0;
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[x][y];
            if ((x + y) % 2 == 0) {
                if (x == 0 && y != n) {
                    y++;
                } else if (y == n) {
                    x++;
                } else {
                    x--;
                    y++;
                }
            } else {
                if (y == 0 && x != m) {
                    x++;
                } else if (x == m) {
                    y++;
                } else {
                    x++;
                    y--;
                }
            }
        }


        return result;
    }
}