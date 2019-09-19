package com.ztianzeng.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * @author zhaotianzeng
 * @date 2019/9/19 10:14 上午
 * @version V1.0
 */
public class Solution0018 {
    @Test
    public void test1() {
        int[] nums = {-2, -1, 0, 0, 1, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        for (List<Integer> list : lists) {
            PrintUtil.print(list);
        }
    }

    @Test
    public void test2() {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> lists = fourSum(nums, 0);
        for (List<Integer> list : lists) {
            PrintUtil.print(list);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4) {
            return result;
        }
        int size = nums.length;
        for (int i = 0; i < size - 3; i++) {
            // 排序后，如果相邻两数相同，则第二个数运算的结果，是第一个数运算结果的一个子集，可以排除
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 如果四个数之和已经大于目标值，后面永远是不可能有解的
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 当前数和后面最大的数相加都比目标值小，直接进入下一次循环
            if (nums[i] + nums[size - 1] + nums[size - 2] + nums[size - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < size - 2; j++) {
                //去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int leftLink = j + 1;
                int rightLink = size - 1;
                while (leftLink < rightLink) {
                    int sum = nums[leftLink] + nums[rightLink] + nums[i] + nums[j];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[leftLink], nums[rightLink]));
                        while (leftLink < rightLink && nums[rightLink] == nums[--rightLink]) ;
                        while (leftLink < rightLink && nums[leftLink] == nums[++leftLink]) ;

                    } else if (sum > target) {
                        // 右指针向左移动
                        while (leftLink < rightLink && nums[rightLink] == nums[--rightLink]) ;

                    } else {
                        // 左指针向右移动
                        while (leftLink < rightLink && nums[leftLink] == nums[++leftLink]) ;
                    }
                }

            }
        }
        return result;

    }


    /**
     * 回溯法，列举所有组合。。。数据多就直接超时
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums, 0, target);
        return result.stream().distinct().collect(Collectors.toList());
    }

    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start, int target) {
        if (target == 0 && tempList.size() == 4) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {

                tempList.add(nums[i]);

                backTrack(result, tempList, nums, i + 1, target - nums[i]);

                tempList.remove(tempList.size() - 1);
            }
        }
    }
}