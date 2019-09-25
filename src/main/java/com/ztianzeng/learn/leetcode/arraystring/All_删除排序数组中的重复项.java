package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * @author zhaotianzeng
 * @date 2019/9/25 10:24 上午
 * @version V1.0
 */
public class All_删除排序数组中的重复项 {
    @Test
    public void test() {
        int[] ints = {1, 1, 2};
        int i = removeDuplicates(ints);
        for (int j = 0; j < i; j++) {
            PrintUtil.print(ints[j]);
        }
    }

    @Test
    public void test2() {
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(ints);
        for (int j = 0; j < i; j++) {
            PrintUtil.print(ints[j]);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int target = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > target) {
                nums[j++] = nums[i];
                target = nums[i];
            }
        }
        return j;
    }
}