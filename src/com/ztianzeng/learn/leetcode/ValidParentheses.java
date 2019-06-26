package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>
 * 使用栈,遍历输入字符串
 * 如果当前字符为左半边括号时，则将其压入栈中
 * 如果遇到右半边括号时，分类讨论：
 * 1）如栈不为空且为对应的左半边括号，则取出栈顶元素，继续循环
 * 2）若此时栈为空，则直接返回false
 * 3）若不为对应的左半边括号，反之返回false
 * </p>
 * <a href='https://leetcode.com/problems/valid-parentheses/submissions/'></a>
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-25 21:46
 */
public class ValidParentheses {
    @Test
    public void test() {
        Assert.assertTrue(isValid(""));
        Assert.assertFalse(isValid("["));
    }

    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        Map<String, String> map = new HashMap<>(3);
        map.put("{", "}");
        map.put("[", "]");
        map.put("(", ")");
        String[] forS = s.split("");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < forS.length; i++) {
            String temp = forS[i];
            if ("{[(".contains(temp)) {
                stack.add(temp);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String peek = stack.pop();
                if (!temp.equals(map.get(peek))) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}