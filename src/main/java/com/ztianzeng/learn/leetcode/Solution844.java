package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以用 O(N)的时间复杂度 和 O(1) 的空间复杂度解决该问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("all")
public class Solution844 {
    @Test
    public void test1() {
        String S = "ab#c", T = "ad#c";
        Assert.assertTrue(backspaceCompare(S, T));
    }
    @Test
    public void test2() {
        String S = "ab##", T = "c#d#";
        Assert.assertTrue(backspaceCompare(S, T));
    }
    @Test
    public void test3() {
        String S = "a##c", T = "#a#c";
        Assert.assertTrue(backspaceCompare(S, T));
    }
    @Test
    public void test4() {
        String S = "a#c", T = "b";
        Assert.assertFalse(backspaceCompare(S, T));
    }
    @Test
    public void test5() {
        String S = "xywrrmp", T = "xywrrmu#p";
        Assert.assertTrue(backspaceCompare(S, T));
    }
    @Test
    public void test6() {
        String S = "bxj##tw", T = "bxj###tw";
        Assert.assertFalse(backspaceCompare(S, T));
    }

    public boolean backspaceCompare(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int i = sChar.length - 1, j = tChar.length - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (sChar[i] == '#') {
                    i--;
                    skipS++;
                } else if (skipS > 0) {
                    i--;
                    skipS--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (tChar[j] == '#') {
                    j--;
                    skipT++;
                } else if (skipT > 0) {
                    j--;
                    skipT--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (sChar[i] != tChar[j]) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;
            j--;

        }


        return true;


    }

    private void deleteChar(char[] sChar) {
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] == '#') {
                // 这个时候肯定要删除本身
                sChar[i] = '-';
                for (int temp = i; temp >= 0; temp--) {
                    if (sChar[temp] == '-') {
                        continue;
                    } else {
                        sChar[temp] = '-';
                        break;
                    }
                }
            }
        }
    }
}
