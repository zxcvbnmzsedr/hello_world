package com.ztianzeng.learn.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二维数组交叉组合算法
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019/9/2 1:36 下午
 */
public class Solution0047_1 {
    public static void main(String[] args) {
        String[][] arrayStr = new String[3][];
        arrayStr[0] = new String[]{"1", "2", "3"};
        arrayStr[1] = new String[]{"2", "3", "4"};
        arrayStr[2] = new String[]{"5", "6", "7"};
        List<String[]> groups = calculation(arrayStr);
        for (int i = 0; i < groups.size(); i++) {
            System.out.println(JSON.toJSONString(groups.get(i)));
        }
    }

    /**
     * <p>重组完成最终分组</p>
     *
     * @param arrayStr 属性列表
     * @return 组集合
     */
    public static List<String[]> calculation(String[][] arrayStr) {

        List<List<String>> columns = new ArrayList<>();
        calculation(arrayStr, columns);
        List<String> column = columns.get(0);
        List<String[]> groups = new ArrayList<>();

        for (int i = 0; i < column.size(); i++) {

            String[] group = new String[columns.size()];
            group[0] = column.get(i);

            for (int j = 1; j < columns.size(); j++) {

                List<String> values = columns.get(j);
                group[j] = values.get(i % values.size());
            }
            groups.add(group);
        }
        return groups;
    }

    /**
     * <p>列填充，递归</p>
     *
     * @param arrayStr
     * @param columns
     */
    public static void calculation(String[][] arrayStr, List<List<String>> columns) {
        List<String> column = new ArrayList<>();
        int k = columns.size();
        for (int i = 0; i < arrayStr[k].length; i++) {
            int times = 1;
            for (int j = k + 1; j < arrayStr.length; j++) {
                int valCount = arrayStr[j].length;
                times = times * valCount;
            }
            for (int j = 0; j < times; j++) {
                column.add(arrayStr[k][i]);
            }
        }
        columns.add(column);
        if (arrayStr.length > columns.size()) {
            calculation(arrayStr, columns);
        }
    }

}