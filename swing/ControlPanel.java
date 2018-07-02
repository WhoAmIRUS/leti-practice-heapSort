package com.etu.heapsort.swing;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private final JButton refresh = createButton("refresh", 0, 10, 50, 30);
    private final JButton sortMax = createButton("sort from min to max", 60, 10, 190, 30);
    private final JButton sortMin = createButton("sort from max to min", 250, 10, 190, 30);
    private final JButton nextStep = createButton("next", 450, 10, 50, 30);

    public ControlPanel() {
        add(refresh);
        add(sortMax);
        add(sortMin);
        add(nextStep);
    }

    public void addSortMaxButtonListener(ActionListener listener){
        sortMax.addActionListener(listener);
    }

    public void addSortMinButtonListener(ActionListener listener){
        sortMin.addActionListener(listener);
    }

    public void addNextStepButtonListener(ActionListener listener){
        nextStep.addActionListener(listener);
    }

    public void addRefreshButtonListener(ActionListener listener){
        refresh.addActionListener(listener);
    }

    private JButton createButton(String text, int x, int y, int width, int height){
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        return button;
    }
}


