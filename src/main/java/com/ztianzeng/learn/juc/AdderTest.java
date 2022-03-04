package com.ztianzeng.learn.juc;

import java.util.concurrent.atomic.LongAdder;

public class AdderTest {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.add(10);
        longAdder.add(10);
        longAdder.add(10);
        System.out.println(longAdder.sum());
    }


}
