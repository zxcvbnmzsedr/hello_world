package com.ztianzeng.learn.jvm.memory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaotianzeng
 */
public class TestMemory {


    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("totalMemory === " + Runtime.getRuntime().totalMemory() / 1024.0 / 1024);
        System.out.println("freeMemory === " + Runtime.getRuntime().freeMemory() / 1024.0 / 1024);
        System.out.println("maxMemory === " + Runtime.getRuntime().maxMemory() / 1024.0 / 1024);

        Thread.sleep(10 * 1000);
        List<A> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new A());
            if (i % 20 == 0) {
                Thread.sleep(100);
            }
        }

        System.gc();
        System.out.println("over============>");

        System.out.println("totalMemory === " + Runtime.getRuntime().totalMemory() / 1024.0 / 1024);
        System.out.println("freeMemory === " + Runtime.getRuntime().freeMemory() / 1024.0 / 1024);
        System.out.println("maxMemory === " + Runtime.getRuntime().maxMemory() / 1024.0 / 1024);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();


    }
}

class A {
    private byte[] bs = new byte[10 * 1024];
}
