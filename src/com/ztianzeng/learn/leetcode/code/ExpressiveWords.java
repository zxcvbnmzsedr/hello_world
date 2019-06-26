package com.ztianzeng.learn.leetcode.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/expressive-words/description/">情感丰富的文字</a>
 * <p>
 * 有时候人们会用额外的字母来表示额外的情感，
 * 比如 "hello" -> "heeellooo", "hi" -> "hiii"。
 * <p>
 * 我们将连续的相同的字母分组，并且相邻组的字母都不相同。
 * <p>
 * 我们将一个拥有三个或以上字母的组定义为扩张状态（extended），如第一个例子中的 "e" 和" o" 以及第二个例子中的 "i"。
 * <p>
 * 此外，"abbcccaaaa" 将有分组 "a" , "bb" , "ccc" , "dddd"；其中 "ccc" 和 "aaaa" 处于扩张状态。
 * <p>
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。
 * 我们允许选择一个字母组（如包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * 注意，我们不能将一个只包含一个字母的字母组，如 "h"，扩张到一个包含两个字母的组，如 "hh"；所有的扩张必须使该字母组变成扩张状态（至少包含三个字母）。
 */
public class ExpressiveWords {

    @Test
    public void test() {
        String s = "heeellooo";
        String[] words = new String[]{
                "helo"};
        System.out.println(expressiveWords(s, words));
    }

    public int expressiveWords(String S, String[] words) {
        RLE R = new RLE(S);
        int ans = 0;

        search:
        for (String word : words) {
            RLE R2 = new RLE(word);
            if (!R.key.equals(R2.key)) {
                continue;
            }
            for (int i = 0; i < R.counts.size(); ++i) {
                int c1 = R.counts.get(i);
                int c2 = R2.counts.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2) {
                    continue search;
                }
            }
            ans++;
        }
        return ans;
    }

    class RLE {
        String key;
        List<Integer> counts;

        public RLE(String S) {
            StringBuilder sb = new StringBuilder();
            counts = new ArrayList();

            char[] ca = S.toCharArray();
            int N = ca.length;
            int prev = -1;
            for (int i = 0; i < N; ++i) {
                if (i == N - 1 || ca[i] != ca[i + 1]) {
                    sb.append(ca[i]);
                    counts.add(i - prev);
                    prev = i;
                }
            }

            key = sb.toString();
        }
    }
//    public int expressiveWords(String s, String[] words) {
//        int expressiveWords = 0;
//        Map<String, List<Integer>> originMap = new HashMap<>();
//        String tempS = s.split("")[0];
//        for (String s1 : s.split("")) {
//            List<Integer> queue = originMap.get(s1) == null ? new ArrayList<Integer>() : originMap.get(s1);
//            if (tempS.equals(s1)) {
//                if (queue.isEmpty()) {
//                    queue.add(1);
//                } else {
//                    queue.set(queue.size() - 1, queue.get(queue.size() - 1) + 1);
//                }
//            } else {
//                queue.add(1);
//            }
//            originMap.put(s1, queue);
//            tempS = s1;
//        }
//        for (int i = 0; i < words.length; i++) {
//
//            String[] sa = words[i].split("");
//            StringBuilder sb = new StringBuilder();
//            // 计数器
//            Map<String, Integer> indexMap = new HashMap<>();
//
//            for (int j = 0; j < sa.length; j++) {
//                String present = sa[j];
//                sb.append(present);
//                if (originMap.get(sa[j]) != null) {
//                    int num = 1;
//                    while (j + 1 < sa.length) {
//                        if (!sa[j + 1].equals(present)) {
//                            break;
//                        }
//                        j++;
//                        num++;
//                        sb.append(present);
//                    }
//                    Integer keyNum;
//
//                    if (originMap.get(present).size() > 0) {
//                        indexMap.put(present, indexMap.get(present) == null ? 0 : indexMap.get(present) + 1);
//                        keyNum = originMap.get(present).get(indexMap.get(present));
//                    } else {
//                        keyNum = 0;
//                    }
//                    if (keyNum == num) {
//                        num = 1;
//                    }
//                    for (int d = 1; d <= keyNum - num && keyNum > 2; d++) {
//                        sb.append(present);
//                    }
//                }
//            }
//            if (sb.toString().equals(s)) {
//                expressiveWords++;
//            }
//        }
//        return expressiveWords;
//    }


}

