package com.ztianzeng.learn.leetcode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * @author zhaotianzeng
 * @date 2019/9/4 5:27 下午
 * @version V1.0
 */
public class Solution0131 {
    @Test
    public void test() {
        List<List<String>> subset = partition("aab");

        System.out.println(JSONObject.toJSONString(subset));

    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = new LinkedList<>();
        backtrack(list, new LinkedList<>(), s, 0);
        return list;
    }

    private void backtrack(List<List<String>> list, List<String> templeList, String s, int start) {
        if (start == s.length()) {
            list.add(new ArrayList<>(templeList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    templeList.add(s.substring(start, i+1));
                    backtrack(list, templeList, s, i + 1);
                    templeList.remove(templeList.size() - 1);
                }

            }

        }
    }

    public boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}