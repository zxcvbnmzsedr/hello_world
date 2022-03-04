package com.ztianzeng.learn.polymorphism;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-04 14:57
 */
public class B implements A{
    @Override
    public void print() {
        System.out.println("I am com.ztianzeng.learn.polymorphism.B");
    }
}