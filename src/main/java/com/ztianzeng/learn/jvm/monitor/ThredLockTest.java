package com.ztianzeng.learn.jvm.monitor;

public class ThredLockTest {

    public static void main(String[] args) {

        AModel model = new AModel("1", "2");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (model.s1) {
                    System.out.println("t1 has model.s1");
                    synchronized (model.s2) {
                        System.out.println("t1 has model.s2");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (model.s2) {
                    System.out.println("t2 has model.s2");
                    synchronized (model.s1) {
                        System.out.println("t2 has model.s1");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}

class AModel {
    public String s1;
    public String s2;

    public AModel(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
}
