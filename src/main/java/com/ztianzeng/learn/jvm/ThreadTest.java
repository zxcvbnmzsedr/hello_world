package com.ztianzeng.learn.jvm;

public class ThreadTest {
    public static void main(String[] args) {
        while (true){
            new Thread(() ->{
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
