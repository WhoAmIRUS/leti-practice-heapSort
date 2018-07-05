package com.etu.heapsort.swing;

import com.etu.heapsort.view.Graphics;
import java.awt.*;

public class SwingGraphicsAdapter implements Graphics{

    private final java.awt.Graphics graphics;

    public SwingGraphicsAdapter(java.awt.Graphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public void drawOval(int x, int y, int width, int height, int rgb) {
        graphics.setColor(new Color(rgb));
        graphics.fillOval(x, y, width, height);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, int rgb){
        graphics.setColor(new Color(rgb));
        graphics.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void drawText(int x, int y, String text, int rgb) {
        char[] symbols = text.toCharArray();
        graphics.setColor(new Color(rgb));
        graphics.setFont(new Font("Serif", Font.BOLD, 11));
        graphics.drawChars(symbols, 0, symbols.length, x, y);
    }
}
