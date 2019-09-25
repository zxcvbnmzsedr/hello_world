package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @author zhaotianzeng
 * @date 2019/9/25 9:56 上午
 * @version V1.0
 */
public class All_反转字符串中的单词3 {
    @Test
    public void test() {
        String s = reverseWords("Let's take LeetCode contest");
        PrintUtil.print(s);
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reversal(chars, start, i - 1);
                start = i + 1;
            }
        }
        reversal(chars, start, chars.length - 1);
        return new String(chars);
    }

    private void reversal(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}