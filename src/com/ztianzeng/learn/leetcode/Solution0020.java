package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-25 21:46
 */
public class Solution0020 {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    @Test
    public void test1() {
        Assert.assertTrue(isValid(""));
    }

    @Test
    public void test2() {
        Assert.assertFalse(isValid("["));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isValid("()"));
    }

    @Test
    public void test4() {
        Assert.assertTrue(isValid("()[]{}"));
    }

    @Test
    public void test5() {
        Assert.assertFalse(isValid("(]"));
    }

    @Test
    public void test6() {
        Assert.assertFalse(isValid("([)]"));
    }

    @Test
    public void test7() {
        Assert.assertTrue(isValid("{[]}"));
    }

    /**
     * <p>
     *  * 使用栈,遍历输入字符串
     *  * 如果当前字符为左半边括号时，则将其压入栈中
     *  * 如果遇到右半边括号时，分类讨论：
     *  * 1）如栈不为空且为对应的左半边括号，则取出栈顶元素，继续循环
     *  * 2）若此时栈为空，则直接返回false
     *  * 3）若不为对应的左半边括号，反之返回false
     *  * </p>
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length + 1];
        int top = 1;
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (map.get(currentChar) != null) {
                stack[top++] = currentChar;
            } else {
                if (top == 1) {
                    return false;
                }
                Character pop = stack[--top];
                if (map.get(pop) != currentChar) {
                    return false;
                }
            }
        }
        return top == 1;
    }
}