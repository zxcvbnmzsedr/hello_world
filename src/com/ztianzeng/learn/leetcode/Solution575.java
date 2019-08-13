package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind.
 * You need to distribute these candies equally in number to brother and sister.
 * Return the maximum number of kinds of candies the sister could gain.
 *
 * Example 1:
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 * The sister has three different kinds of candies.
 *
 * Example 2:
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 * The sister has two different kinds of candies, the brother has only one kind of candies.
 * Note:
 *
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 *
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。
 * 返回妹妹可以获得的最大糖果的种类数。
 *
 *
 * @author zhaotianzeng
 * @date 2019-08-09 18:03
 * @version V1.0
 */
public class Solution575 {

    @Test
    public void test() {
        int[] candies = {1, 1, 2, 2, 3, 3};
        int i = distributeCandies(candies);
        Assert.assertEquals(i, 3);
    }

    /**
     * 当糖果的种类大于一半时，妹妹能够拿到 n / 2 个糖果
     * 如果糖果种类小于一半，妹妹能够拿到n个糖果
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        int length = candies.length;
        int count = (int) Arrays.stream(candies).distinct().count();
        if (count > length / 2) {
            return length / 2;
        } else {
            return count;
        }
    }

}