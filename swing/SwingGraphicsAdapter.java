package heapsort.swing;

import heapsort.view.Graphics;
import java.awt.*;

public class SwingGraphicsAdapter implements Graphics{

    private final java.awt.Graphics graphics;

    public SwingGraphicsAdapter(java.awt.Graphics graphics) {
        this.graphics = graphics;
    }

    public void drawOval(int x, int y, int width, int height, int rgb) {
        graphics.setColor(Color.black);
        graphics.fillOval(x - 2, y - 2, width + 4,height + 4);
        graphics.setColor(new Color(rgb));
        graphics.fillOval(x, y, width, height);
    }

    public void drawLine(int x1, int y1, int x2, int y2, int rgb){
        graphics.setColor(new Color(rgb));
        graphics.drawLine(x1, y1, x2, y2);
    }

    public void drawText(int x, int y, String text, int rgb) {
        char[] symbols = text.toCharArray();
        graphics.setColor(new Color(rgb));
        graphics.setFont(new Font("Serif", Font.BOLD, 15));
        graphics.drawChars(symbols, 0, symbols.length, x, y);
    }
}
