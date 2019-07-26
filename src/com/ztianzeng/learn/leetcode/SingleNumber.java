package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 链接：https://leetcode-cn.com/problems/single-number
 *
 * @author zhaotianzeng
 * @date 2019-07-26 09:31
 * @version V1.0
 */
public class SingleNumber {
    @Test
    public void test1() {
        int i = singleNumber(new int[]{2, 2, 1});
        Assert.assertEquals(i, 1);
    }

    @Test
    public void test2() {
        int i = singleNumber(new int[]{4, 1, 2, 1, 2});
        Assert.assertEquals(i, 4);
    }

    /**
     * 使用异或处理
     *
     * 异或的性质 两个数字异或的结果a^b是将 a 和 b 的二进制每一位进行运算，得出的数字。 运算的逻辑是 如果同一位的数字相同则为 0，不同则为 1
     *
     * 任何数和本身异或则为0
     *
     * 任何数和 0 异或是本身
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int let = 0;
        // leetcode 显示这样的写法比foreach 少那么1.1 M内存
        for (int i = 0; i < nums.length; i++) {
            let = let ^ nums[i];
        }
        return let;
    }
}