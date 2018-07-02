package com.etu.heapsort.view;

import java.awt.*;

public class View{

    private Graphics graphics;

    public void draw(){
        drawTree();
    }
    private void drawTree(){
        graphics.drawOval(1, 1, 50, 50, java.awt.Color.GREEN.getRGB());
        graphics.drawLine(1, 1, 100, 100, java.awt.Color.RED.getRGB());
        graphics.drawText(10, 10, "jsgjshgjasjh", java.awt.Color.RED.getRGB());
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
