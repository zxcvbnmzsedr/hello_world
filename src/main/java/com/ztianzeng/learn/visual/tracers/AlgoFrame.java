package com.ztianzeng.learn.visual.tracers;

import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame {
    private JPanel mainPanel = new JPanel();

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {

        super(title);

        setSize(canvasWidth, canvasHeight);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        setContentPane(mainPanel);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title) {

        this(title, 1024, 768);
    }

    public void addPanel(Component comp) {
        mainPanel.add(comp);
    }


}


