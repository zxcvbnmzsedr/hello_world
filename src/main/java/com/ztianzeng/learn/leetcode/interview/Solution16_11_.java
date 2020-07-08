package com.ztianzeng.learn.leetcode.interview;

import org.junit.Test;

import java.util.Arrays;

/**
 * 你正在使用一堆木板建造跳水板。
 * 有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaotianzeng
 */
public class Solution16_11_ {

    @Test
    public void test() {
        int[] ints = divingBoard(1, 2, 3);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test2() {
        int[] ints = divingBoard(1, 1, 0);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 纯数学的方式求解
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {

        if (k == 0) {
            return new int[0];
        }
        // 当两个相等时，不需要排列组合
        if (shorter == longer) {
            return new int[]{k * longer};
        }
        int[] result = new int[k + 1];
        // 先尽可能用短的多，长的少。。自然就从小到大排列了
        for (int i = 0; i <= k; i++) {
            int sum = (k - i) * shorter + i * longer;
            result[i] = sum;
        }
        return result;
    }
}
