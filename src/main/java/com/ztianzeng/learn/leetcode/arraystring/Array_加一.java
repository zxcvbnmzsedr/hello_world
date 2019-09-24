package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @author zhaotianzeng
 * @date 2019/9/23 1:24 下午
 * @version V1.0
 */
public class Array_加一 {
    @Test
    public void test1() {
        int[] ints = plusOne(new int[]{9});
        PrintUtil.print(ints);
    }

    @Test
    public void test2() {
        int[] ints = plusOne(new int[]{1, 2, 3});
        PrintUtil.print(ints);
    }

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int addNumber = 1;
        for (int i = result.length - 2; i >= 0; i--) {
            int tempNumber = digits[i] + addNumber;
            if (tempNumber >= 10) {
                result[i] = tempNumber % 10;
            } else {
                result[i] = tempNumber;
                addNumber = 0;
            }
        }
        if (addNumber != 0) {
            result[0] = result[0] + 1;
        } else {
            result = Arrays.copyOf(result, result.length - 1);
        }
        return result;
    }
}