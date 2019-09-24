package com.ztianzeng.learn.leetcode;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。
 * 找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 *             3 、9    0、12
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * @author zhaotianzeng
 * @date 2019/9/21 9:15 上午
 * @version V1.0
 */
public class Solution0030 {
    @Test
    public void test1() {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> substring = findSubstring(s, words);
        PrintUtil.print(substring);
    }

    @Test
    public void test2() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
        List<Integer> substring = findSubstring(s, words);
        PrintUtil.print(substring);
    }

    @Test
    public void test3() {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> substring = findSubstring(s, words);
        PrintUtil.print(substring);
    }

    /**
     * 滑动窗口算法
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        int n;
        if (null == words || (n = words.length) == 0) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }

        int m = s.length();
        int len = words[0].length();

        // 滑动
        for (int i = 0; i < len; i++) {
            Map<String, Integer> window = new HashMap<>();
            int left = i;
            int right = i;
            while (right < m - len + 1 && left < m - len * n + 1) {
                String tmpRight = s.substring(right, right + len);
                // 如果不包含截取的字符，比如{"foo","bar"} foo找不到则去寻找第二个窗口
                if (!map.containsKey(tmpRight)) {
                    right += len;
                    left = right;
                    window.clear();
                    continue;
                }
                if (window.containsKey(tmpRight)) {
                    window.put(tmpRight, window.get(tmpRight) + 1);
                } else {
                    window.put(tmpRight, 1);
                }
                // 滑动窗口
                right += len;
                while (window.get(tmpRight) > map.get(tmpRight)) {
                    String tmpLeft = s.substring(left, left + len);
                    window.put(tmpLeft, window.get(tmpLeft) - 1);
                    if (window.get(tmpLeft) == 0) {
                        window.remove(tmpLeft);
                    }
                    left += len;
                }
                if (right - left == n * len) {
                    result.add(left);
                }

            }
        }
        return result;
    }

}