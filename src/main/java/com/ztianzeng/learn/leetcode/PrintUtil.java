package com.ztianzeng.learn.leetcode;

import com.alibaba.fastjson.JSON;

public class PrintUtil {
    public static void print(Object object){
        System.out.println(JSON.toJSONString(object));
    }
}
