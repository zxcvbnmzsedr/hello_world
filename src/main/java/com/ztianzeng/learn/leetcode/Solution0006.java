package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author zhaotianzeng
 * @date 2019/9/11 4:46 下午
 * @version V1.0
 */
public class Solution0006 {
    @Test
    public void test() {
        String leetcodeishiring = convert("LEETCODEISHIRING", 3);
        Assert.assertEquals("LCIRETOESIIGEDHN", leetcodeishiring);
    }

    @Test
    public void test2() {
        String leetcodeishiring = convert("LEETCODEISHIRING", 4);
        Assert.assertEquals("LDREOEIIECIHNTSG", leetcodeishiring);
    }

    @Test
    public void test3() {
        String leetcodeishiring = convert("A", 3);
        Assert.assertEquals("A", leetcodeishiring);
    }

    /**
     *
     * 从左到右按箭头方向迭代 s ，将每个字符添加到合适的行。之后从上到下遍历行即可。
     *
     * 首先不能把这个排列当成Z看，要当成竖起来的N来看.
     * 字母方向是这样子哒:
     * |  /|  /|
     * | / | / |
     * |/  |/  |
     * 当row=3时, 3、1、3、1、3。。。2、4、6、8、10。。。 处转折
     * 当row=4时, 4、2、4、2、4 。。。 3 、6、 9 、12。。。 处转折
     * 当row=n时, n、n-2、n、n-2。。。n-1、2n -2、3n-3，4n-4 处转折
     *
     * 还能够发现，也就是说坐标换算成数组中下标就是在n处或者x(n-1)转折
     * ——————————————>
     *
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int curRow = 0;
        String[] rowString = new String[Math.min(s.length(), numRows)];
        boolean go = false;
        for (char c : s.toCharArray()) {
            rowString[curRow] = (rowString[curRow] == null ? "" : rowString[curRow]) + c;
            // 当前行curRow为0或numRows -1时，箭头发生反向转折
            if (curRow == 0 || curRow == numRows - 1) {
                go = !go;
            }
            curRow += go ? 1 : -1;
        }
        return String.join("", rowString);
    }
}