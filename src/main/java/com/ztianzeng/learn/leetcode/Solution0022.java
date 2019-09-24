package com.ztianzeng.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * @author zhaotianzeng
 * @date 2019/9/19 2:08 下午
 * @version V1.0
 */
public class Solution0022 {
    @Test
    public void test1() {
        List<String> strings = generateParenthesis(1);
        PrintUtil.print(strings);
    }

    @Test
    public void test2() {
        List<String> strings = generateParenthesis(2);
        PrintUtil.print(strings);
    }

    @Test
    public void test3() {
        List<String> strings = generateParenthesis(3);
        PrintUtil.print(strings);
    }

    /**
     * n = 1 ,()
     * n = 2 ,()() 、(())
     * n = 3 , ()()() 、(()())、  (())() 、()(())、  ((()))
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, "", res);
        return res;
    }

    /**
     * 定义两个变量left和right分别表示剩余左右括号的个数，
     * 如果在某次递归时，左括号的个数大于右括号的个数，
     * 说明此时生成的字符串中右括号的个数大于左括号的个数，即会出现')('这样的非法串，所以这种情况直接返回，不继续处理。
     * 如果left和right都为0，则说明此时生成的字符串已有3个左括号和3个右括号，且字符串合法，则存入结果中后返回。
     * 如果以上两种情况都不满足，若此时left大于0，则调用递归函数，注意参数的更新，若right大于0，则调用递归函数，同样要更新参数。
     *
     * @param left
     * @param right
     * @param out
     * @param res
     */
    void helper(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        helper(left - 1, right, out + "(", res);
        helper(left, right - 1, out + ")", res);
    }
}