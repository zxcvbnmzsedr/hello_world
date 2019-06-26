package com.ztianzeng.learn.leetcode.code;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 每个输入包含 1 个测试用例。
 * 每个测试用例的第 i 行，
 * 表示完成第 i 件料理需要哪些材料，
 * 各个材料用空格隔开，
 * 输入只包含大写英文字母和空格，输入文件不超过 50 行，每一行不超过 50 个字符。
 *
 *
 * 咋觉得是在考察Scanner的使用
 */
public class 下厨房 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while (in.hasNext()){
            String str = in.nextLine();
            String arr[] = str.split(" ");
            for(int i=0; i<arr.length; i++){
                set.add(arr[i]);
            }
        }
        System.out.println(set.size());
    }
}
