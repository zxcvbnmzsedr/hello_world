package com.ztianzeng.learn.leetcode.pointer;

import com.ztianzeng.learn.leetcode.PrintUtil;
import org.junit.Test;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：['h','e','l','l','o']
 * 输出：['o','l','l','e','h']
 * 示例 2：
 *
 * 输入：['H','a','n','n','a','h']
 * 输出：['h','a','n','n','a','H']
 * @author zhaotianzeng
 * @date 2019/9/24 3:20 下午
 * @version V1.0
 */
public class TwoPointer_反转字符串 {
    @Test
    public void test() {
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        reverseString(c);
        PrintUtil.print(c);
    }

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
    }

    private void swap(char[] s, int a, int b) {
        char c = s[a];
        s[a] = s[b];
        s[b] = c;
    }
}