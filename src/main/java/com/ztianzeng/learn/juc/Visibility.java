package com.ztianzeng.learn.juc;

public class Visibility {
    int x = 1;

    public void write() {
        x = 1;
    }
    public void read() {
        int y = x;
    }
}
