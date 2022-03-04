package com.ztianzeng.learn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestHash {
    @Test
    public void test(){
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
    }

    @Test
    public void test2(){
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < 2000000; i++) {
            Integer h = new Object().hashCode();
            h = h.hashCode();
            if (    hashSet.contains(h)){
                System.out.println("重复的hashcode: "+ h +" 次数："+i);
            }else {
                hashSet.add(h);
            }

        }
    }
}
