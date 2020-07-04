package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A <= 30000
 * 1 <= A[i] <= 30000
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Todo_Solution907 {
    @Test
    public void test() {
        int[] A = {3, 1, 2, 4};
        int i = sumSubarrayMins(A);
        Assert.assertEquals(i, 17);
    }

    @Test
    public void test2() {
        int[] A = {3, 1, 2, 4};
        long i = sumSubarrayMins(A);
        Assert.assertEquals(i, 109);
    }

    /**
     * 无法解决溢出的问题
     *
     * @param A
     * @return
     */
    public int sumSubarrayMins(int[] A) {

        if (A.length == 1) {
            return A[0];
        }

        int minIndex = minIndex(A);

        int leftLength = minIndex;
        int rightLength = A.length - minIndex - 1;
        int sum = (leftLength + 1) * (rightLength + 1) * A[minIndex];
        if (minIndex > 0) {
            sum += sumSubarrayMins(Arrays.copyOfRange(A, 0, minIndex));
        }
        if (minIndex + 1 < A.length) {
            sum += sumSubarrayMins(Arrays.copyOfRange(A, minIndex + 1, A.length));
        }
        return sum % 1000000007;
    }

    /**
     * 求出数组最小值的Index
     *
     * @param A
     * @return
     */
    public int minIndex(int[] A) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
                index = i;
            }
        }
        return index;
    }
}
