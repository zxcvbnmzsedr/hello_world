package com.ztianzeng.learn.leetcode;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * ![](http://pic.ztianzeng.com/20190917114842.png)
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author zhaotianzeng
 * @date 2019/9/17 11:46 上午
 * @version V1.0
 */
public class Solution0017 {
    public static final Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    @Test
    public void test1() {
        List<String> strings = letterCombinations("23");
        PrintUtil.print(strings);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", digits);
        return result;
    }

    private void backtrack(List<String> result, String currentString, String nextDigits) {
        if (nextDigits.length() == 0) {
            result.add(currentString);
        } else {
            // 取第一个字符
            Character digit = nextDigits.charAt(0);
            // 取这个字符的对应的字符集
            String s = map.get(digit);
            for (int i = 0; i < s.length(); i++) {
                // 每次只取第i个字作拼接，递归时删除已经处理过的字符
                String letter = map.get(digit).substring(i, i + 1);
                backtrack(result, currentString + letter, nextDigits.substring(1));
            }

        }

    }
}