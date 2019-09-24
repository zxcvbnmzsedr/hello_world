package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * @author zhaotianzeng
 * @date 2019/9/24 7:47 下午
 * @version V1.0
 */
public class All_杨辉三角2 {
    @Test
    public void test() {
        PrintUtil.print(getRow(0));
    }

    public List<Integer> getRow(int numRows) {
        List<Integer> pre = new ArrayList<>();
        if (numRows == 0) {
            return Collections.singletonList(1);
        }
        for (int i = 0; i < numRows; i++) {
            LinkedList<Integer> currentList = new LinkedList<>();
            currentList.addFirst(1);

            for (int j = 1; j < pre.size(); j++) {
                currentList.add(pre.get(j) + pre.get(j - 1));
            }
            currentList.addLast(1);
            pre = currentList;
        }
        return pre;
    }
}