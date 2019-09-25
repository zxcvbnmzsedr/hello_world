package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @author zhaotianzeng
 * @date 2019/9/25 10:35 上午
 * @version V1.0
 */
public class All_移动零 {

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        PrintUtil.print(nums);
    }

    public void moveZeroes(int[] nums) {
        int target = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}