package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 * <p>
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 3
 * 解释:
 * 最初, 我们只有一个字符 'A'。
 * 第 1 步, 我们使用 Copy All 操作。
 * 第 2 步, 我们使用 Paste 操作来获得 'AA'。
 * 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 * 说明:
 * <p>
 * n 的取值范围是 [1, 1000] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2-keys-keyboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaotianzeng
 */
public class Solution0650 {

    /**
     * 输入: 3
     * 输出: 3
     * 解释:
     * 最初, 我们只有一个字符 'A'。
     * 第 1 步, 我们使用 Copy All 操作。
     * 第 2 步, 我们使用 Paste 操作来获得 'AA'。
     * 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
     */
    @Test
    public void test1() {
        int i = minSteps(3);
        Assert.assertEquals(i, 3);
    }

    /**
     * 如果N是一个素数，必须得一个一个粘贴
     * 如果N不是一个素数，则结果就是分解因式的和
     *
     * @param n n
     * @return
     */
    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            // 从2开始 因式分解
            while (n % d == 0) {
                // 因式分解的和
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
