package com.ztianzeng.learn.leetcode.code;

/**
 * @link https://www.nowcoder.com/practice/74475ee28edb497c8aa4f8c370f08c30?tpId=85&tqId=29836&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 */
public class 藏宝图 {
    public static final void main(String[] args) {
        String str1 = "ooxxoo";
        String str2 = "oxoxoxox";
        boolean result = isContain(str1, str2);
        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    /**
     * 回答 t 是否是 s 的子序列
     * 例如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种
     */
    public static boolean isContain(String s, String t) {
        if ("".equals(t)) {
            return true;
        }
        int a = 0, b = 0;
        String[] sA = s.split("");
        String[] sB = t.split("");
        while (a < s.length() && b < t.length()) {
            if (sA[a++].equals(sB[b])) {
                b++;
            }
        }
        return b == t.length();
    }
}
