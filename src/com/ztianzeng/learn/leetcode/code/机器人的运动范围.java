package com.ztianzeng.learn.leetcode.code;

import org.junit.Test;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class 机器人的运动范围 {
    @Test
    public void test() {
        System.out.println(movingCount(10, 1, 100));
    }

    /**
     * @param threshold 阈值k
     * @param rows      行
     * @param cols      列
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        int[][] record = new int[rows][cols];

        return help(0, 0, rows, cols, record, threshold);
    }

    /**
     * @param i         当前行
     * @param j         当前要走的列
     * @param rows      行
     * @param cols      列
     * @param record    已经行走过的记录
     * @param threshold 阈值
     * @return
     */
    public int help(int i, int j, int rows, int cols, int[][] record, int threshold) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || getSum(i) + getSum(j) > threshold || record[i][j] == 1) {
            return 0;
        }
        record[i][j] = 1;
        // 向上下左右走的数量 + 1
        // 因为走到这里肯定就能走，计步器+1
        return help(i - 1, j, rows, cols, record, threshold)
                + help(i + 1, j, rows, cols, record, threshold)
                + help(i, j - 1, rows, cols, record, threshold)
                + help(i, j + 1, rows, cols, record, threshold) + 1;
    }

    int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

}
