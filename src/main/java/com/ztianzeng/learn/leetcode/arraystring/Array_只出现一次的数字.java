package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @author zhaotianzeng
 * @date 2019/9/25 11:39 上午
 * @version V1.0
 */
public class Array_只出现一次的数字 {
    @Test
    public void test1() {
        int i = singleNumber(new int[]{2, 2, 1});
        Assert.assertEquals(1, i);
    }

    @Test
    public void test2() {
        int i = singleNumber(new int[]{1, 2, 4, 1, 2});
        Assert.assertEquals(4, i);
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int j = nums[0];
        for (int i = 1; i < nums.length; i++) {
            j = j ^ nums[i];
        }
        return j;
    }
}