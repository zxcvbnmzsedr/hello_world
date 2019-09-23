package com.ztianzeng.learn.leetcode.array;

import com.ztianzeng.learn.leetcode.PrintUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @author zhaotianzeng
 * @date 2019/9/23 3:56 下午
 * @version V1.0
 */
public class Array_杨辉三角 {
    @Test
    public void test() {
        List<List<Integer>> generate = generate(5);
        for (int i = 0; i < generate.size(); i++) {
            PrintUtil.print(generate.get(i));
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows >= 1) {
            result.add(Collections.singletonList(1));
        }

        for (int i = 1; i < numRows; i++) {
            LinkedList<Integer> currentList = new LinkedList<>();
            currentList.addFirst(1);

            List<Integer> pre = result.get(i - 1);
            for (int j = 1; j < pre.size(); j++) {
                currentList.add(pre.get(j) + pre.get(j - 1));
            }
            currentList.addLast(1);
            result.add(currentList);
        }


        return result;
    }

}