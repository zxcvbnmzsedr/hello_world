package com.ztianzeng.learn.leetcode.code;

import com.ztianzeng.leetcode.util.PrintUtil;
import org.junit.Test;

/**
 * 在数组中找到连续的子数组（至少包含一个数字），这个数组的总和最大。
 * <p>
 * [-2,1,-3,4,-1,2,1,-5,4]
 * <p>
 * [4,-1,2,1]
 * <p>
 * 最大是6
 */
public class MaxLength {
    @Test
    public void test() {
        PrintUtil.print(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 可以连续加，如果相加的数小于被加的那个数，则后续无论怎么加都会比从当前数加上去来的小
            sum = sum + nums[i];
            if (sum < nums[i]){
                sum = nums[i];
            }
            if (maxSum < sum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
