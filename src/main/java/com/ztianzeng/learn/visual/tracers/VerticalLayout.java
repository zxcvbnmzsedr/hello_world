package com.ztianzeng.learn.visual.tracers;

import java.util.LinkedList;
import java.util.List;

public class VerticalLayout extends Layout {

    private static AlgoFrame frame = new AlgoFrame("算法");

    private static List<Tracer> tracers = new LinkedList<>();

    public VerticalLayout(Tracer... children) {
        for (Tracer tracer : children) {
            frame.addPanel(tracer);
            tracers.add(tracer);
        }
    }

    public static void delay() {
        for (Tracer tracer : tracers) {
            tracer.repaint();
        }
    }
}