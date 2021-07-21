package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组nums ，除某个元素仅出现一次外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums中，除某个元素仅出现一次外，其余每个元素都恰出现三次
 * <p>
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0157 {
    @Test
    public void test() {
        Assert.assertEquals(singleNumber(new int[]{2, 2, 3, 2}), 3);
    }



    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        final Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (map.get(integer) == 1) {
                return integer;
            }
        }
        return 0;
    }
}
