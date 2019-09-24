package com.ztianzeng.learn.leetcode.arraystring;

import com.alibaba.fastjson.JSONObject;
import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author zhaotianzeng
 * @date 2019/9/23 2:54 下午
 * @version V1.0
 */
public class Array_螺旋矩阵 {
    @Test
    public void test1() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> diagonalOrder = spiralOrder(matrix);
        PrintUtil.print(diagonalOrder);
        Assert.assertEquals("[1,2,3,6,9,8,7,4,5]", JSONObject.toJSONString(diagonalOrder));
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> diagonalOrder = spiralOrder(matrix);
        PrintUtil.print(diagonalOrder);
        Assert.assertEquals("[1,2,3,4,8,12,11,10,9,5,6,7]", JSONObject.toJSONString(diagonalOrder));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        int top = 0;
        int left = 0;
        int bottom = m - 1;
        int right = n - 1;
        String d = "right";
        for (int i = 0; i < m * n; i++) {
            result.add(matrix[x][y]);
            if (d.equals("right") && y == right) {
                top++;
                d = "down";
            } else if (d.equals("down") && x == bottom) {
                right--;
                d = "left";
            } else if (d.equals("left") && y == left) {
                bottom--;
                d = "up";
            } else if (d.equals("up") && x == top) {
                left++;
                d = "right";
            }
            switch (d) {
                case "up":
                    x--;
                    break;
                case "down":
                    x++;
                    break;
                case "left":
                    y--;
                    break;
                case "right":
                    y++;
                    break;
            }
        }
        return result;
    }
}