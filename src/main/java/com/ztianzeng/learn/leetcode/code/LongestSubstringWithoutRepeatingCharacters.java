package com.ztianzeng.learn.leetcode.code;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * 给了一个字符串，找出最长的没有重复的字符串
 * <p>
 * 例如：
 * abcabcbb 最长的没有重复的字符串是abc 所以最长是3
 * bbbbb 最长不重复字符串是b 所以最长是1
 * pwwkew 最长不重复字符串是wke 所以最长是3
 * 提示，答案必须是一个子链，pwke是一个后继，不是一个
 */
public class LongestSubstringWithoutRepeatingCharacters {
    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * Suppose we have a function boolean allUnique(String substring) which will return true if the characters in the substring are all unique, otherwise false.
     * We can iterate through all the possible substrings of the given string s and call the function allUnique.
     * If it turns out to be true, then we update our answer of the maximum length of substring without duplicate characters.
     *
     * Now let's fill the missing parts:
     *
     * 1.To enumerate all substrings of a given string,we enumerate the start and end indices of them.
     * Suppose the start and end indices are i and j, respectively.
     * Then we have 0 \leq i \lt j \leq n0≤i<j≤n (here end index j is exclusive by convention).
     * Thus, using two nested loops with i from 0 to n - 1 and j from i+1 to n, we can enumerate all the substrings of s.
     *
     * 2.To check if one string has duplicate characters, we can use a set.
     * We iterate through all the characters in the string and put them into the set one by one.
     * Before putting one character, we check if the set already contains it.
     * If so, we return false. After the loop, we return true.
     *
     * 假定我们有一个可以检测子字符串中的字符都是唯一的方法allUnique(String substring),如果是就是true，否则就是false
     * 我们可以迭代所有可能出现的字符子串，并且调用allUnique方法进行检测
     * 如果allUnique返回的是true，那么我们就更新没有重复字符的子字符串的最大长度的答案。
     *
     * 现在我们来填充缺失的部分:
     * 1.去列举所有的子字符串，我们列举开始和结束的指针
     * 列举的开始和结束的指针各自是i和j
     * 我们有0小于i小于等于j小于等于n，这里的索引j是唯一的
     * 因此使用两个循环i从0循环到n-1然后j从i+1循环到n，这样我们可以列举出所有的s的字串。
     *
     * 2.要检查如果字符串还有重复的字符，我们使用集合。
     * 在这个字符串内迭代所有的字符，并且把他们一个一个放入到set中去。
     * 在放之前需要检查一下set中是否含有这个字符，如果有了可以直接返回false，整个都迭代完之后，返回true
     *
     *
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(min(n,m))
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
    /**
     * The above solution requires at most 2n steps.
     * In fact, it could be optimized to require only n steps.
     * Instead of using a set to tell if a character exists or not,
     * we could define a mapping of the characters to its index.
     * Then we can skip the characters immediately when we found a repeated character.
     * The reason is that if s[j]s[j] have a duplicate in the range [i, j) with index j'
     * we don't need to increase i little by little.
     * We can skip all the elements in the range [i, j'][i,j] and let i to be j' + 1 directly.
     *
     * 上面的解决方案最多需要2n个步骤。
     * 事实上，它的最佳解决方案只需要n步。
     * 替代使用set去检测字符串是否存在，我们能以定义一个map去存储字符串的索引。
     * 因此我们一旦发现有重复的字符，那么我可以立即的跳过他。
     * 原因是因为s[j]有一个重复值s[j‘]在[i,j)的范围内,那么我们就不需要逐渐去增加i的值
     * 我们能够跳过所有的在范围[i,j']并且快速的让i变成j'+1
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)), j);
            }
            ans = Math.max(ans, i - j + 1);
            map.put(s.charAt(i), i + 1);
        }
        return ans;
    }
}
