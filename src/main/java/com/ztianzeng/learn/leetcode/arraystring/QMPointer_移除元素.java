package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Test;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author zhaotianzeng
 * @date 2019/9/24 4:13 下午
 * @version V1.0
 */
public class QMPointer_移除元素 {

    @Test
    public void test1() {
        int[] nums = {3, 2, 2, 3};
        int i = removeElement(nums, 3);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int i = removeElement(nums, 1);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    @Test
    public void test3() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = removeElement(nums, 2);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            } else {
                length--;
            }
        }
        return length;
    }
}