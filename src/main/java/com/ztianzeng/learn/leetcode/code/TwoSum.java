package com.ztianzeng.learn.leetcode.code;


import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * 给了一个int的数组，返回两个数的索引他们相加到一个特定的目标
 * 你可以假定每个输入都有一个确定的解决方案，不能使用一个相同的元素两次
 * <p>
 * 测试用例：
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        PrintUtil.print(twoSum1(nums, target));
        PrintUtil.print(twoSum2(nums, target));
        PrintUtil.print(twoSum3(nums, target));
    }

    /**
     * 在这种情况下，时间复杂度是O(n^2)
     * 空间复杂度，由于没有借助其他的空间所以空间复杂度是O(1)
     * @param nums 数组
     * @param target 目标值
     * @return 解决方案
     */
    int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1;j<nums.length;j++){
                if(nums[j] == target-nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("没有解决方案");
    }

    /**
     * 时间复杂度为O(n)
     * 空间复杂度O(n)
     * @param nums 数组
     * @param target 目标值
     * @return 解决方案
     */
    int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("没有解决方案");
    }

    /**
     * 时间复杂度为O(n)
     * 空间复杂度O(n)
     * @param nums 数组
     * @param target 目标值
     * @return 解决方案
     */
    int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("没有解决方案");
    }

}
