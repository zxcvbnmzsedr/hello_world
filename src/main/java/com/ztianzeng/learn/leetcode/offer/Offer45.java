package com.ztianzeng.learn.leetcode.offer;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * 提示:
 * <p>
 * 0 < nums.length <= 100
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer45 {

    @Test
    public void test() {
        System.out.println(minNumber(new int[]{2, 10}));
        System.out.println(minNumber(new int[]{3, 5, 30, 34, 9}));
        System.out.println(minNumber(new int[]{20, 1}));
    }

    /**
     * 1. 如果将每个数字都请求出来进行比较，时间复杂度是O(n!) ,难以接受这个方案。
     * 2. 或者说，先都对10取余，然后在进行排列
     *
     * @param nums
     * @return
     */

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        String tmp = strs[i];

        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) {
                j--;
            }
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) {
                i++;
            }
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;

        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }


    /**
     * 取巧，利用java8新特性
     *
     * @param nums
     * @return
     */
    public String minNumber2(int[] nums) {
        return Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
                .collect(Collectors.joining());
    }
}
