package com.ztianzeng.learn.visual.tracers;

import java.awt.*;

public class LogTracer extends Tracer {
    private String log;

    public LogTracer(String title) {
        super(title);
    }

    public LogTracer() {
        super();
    }

    public void set(String log) {
        this.log = log;
        super.set();
    }

    public void print(Object message) {
        this.log += message;

    }

    public void println(String message) {
        this.print(message + '\n');
    }

    @Override
    public void paint(Graphics graphics) {
        // 必须先调用父类的paint方法
        super.paint(graphics);
        graphics.drawString(log, 20, 20);
    }

}