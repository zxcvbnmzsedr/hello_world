package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * @author zhaotianzeng
 * @date 2019/9/25 11:16 上午
 * @version V1.0
 */
public class Array_存在重复 {
    @Test
    public void test1() {
        boolean b = containsDuplicate(new int[]{1, 2, 3, 1});
        Assert.assertTrue(b);
    }

    @Test
    public void test2() {
        boolean b = containsDuplicate(new int[]{1, 2, 3, 4});
        Assert.assertFalse(b);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}