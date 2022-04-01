package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class All_五数之和 {
    /**
     * 10.91
     * [2.3, 1.2, 0.21, 5.3, 3.3, 2, 1.02, 0.88, 10]
     * 数组里找几个数的组合最接近并大于10.91的，最多组合5个数，最完美就一个
     */
    @Test
    public void test() {
        List<List<Double>> closest = findClosest(new double[]{2.3, 1.2, 0.21, 5.3, 3.3, 2, 1.02, 0.88, 10}, 10.91);
        for (List<Double> i : closest) {
            System.out.println(i);
        }
    }


    List<List<Double>> res = new LinkedList<>();
    Double min = Double.MAX_VALUE;

    public List<List<Double>> findClosest(double[] arr, double target) {
        dfs(arr, 0, target, 0, new LinkedList<>());
        return res;
    }


    public void dfs(double[] arr, double cur, double target, int start, List<Double> curList) {
        if (curList.size() == 5) {
            if (cur >= target && cur < min) {
                min = cur;
                res.add(new LinkedList<>(curList));
            }
        } else {
            for (int i = start; i < arr.length; i++) {
                double nextCur = arr[i] + cur;
                if (nextCur > target && nextCur > min) {
                    break;
                }
                curList.add(arr[i]);
                dfs(arr, nextCur, target, i + 1, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }

}
