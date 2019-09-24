package com.ztianzeng.learn.leetcode.code;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * @author: 赵天增
 * @date: 2018 -04-28
 */
public class SpiralMatrix {
    @Test
    public void test() {
        int[][] data1 = new int[3][4];
        data1[0][0] = 1;
        data1[0][1] = 2;
        data1[0][2] = 3;
        data1[0][3] = 4;

        data1[1][0] = 5;
        data1[1][1] = 6;
        data1[1][2] = 7;
        data1[1][3] = 8;

        data1[2][0] = 9;
        data1[2][1] = 10;
        data1[2][2] = 11;
        data1[2][3] = 12;


        System.out.println(spiralOrder(data1));

        int[][] data2 = new int[3][3];
        data2[0][0] = 1;
        data2[0][1] = 2;
        data2[0][2] = 3;

        data2[1][0] = 4;
        data2[1][1] = 5;
        data2[1][2] = 6;

        data2[2][0] = 7;
        data2[2][1] = 8;
        data2[2][2] = 9;
//        System.out.println(spiralOrder(data2));


    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix.length == 0) {
            return list;
        }
        // 位置坐标
        int x = 0, y = 0;
        int m = matrix.length, n = matrix[0].length;
        // 总量
        int total = m * n;
        // 定义上下左右的边界
        int top = 0, left = 0, bottom = m - 1, right = n - 1;
        // 方向，初始方向向右
        String direction = "right";
        for (int i = 0; i < total; i++) {
            list.add(matrix[y][x]);
            // 如果x走到尽头
            if (x == right && direction.equals("right")) {
                top++;
                direction = "down";
            } else if (y == bottom && direction.equals("down")) {
                right--;
                direction = "left";
            } else if (x == left && direction.equals("left")) {
                bottom--;
                direction = "up";
            } else if (y == top && direction.equals("up")) {
                left++;
                direction = "right";
            }

            switch (direction) {
                case "right":
                    x++;
                    break;
                case "down":
                    y++;
                    break;
                case "left":
                    x--;
                    break;
                case "up":
                    y--;
                    break;
                default:
                    break;
            }


        }

        return list;
    }
}
