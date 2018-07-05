package com.etu.heapsort.view;

public interface Graphics {
    void drawOval(int x, int y, int width, int height, int rgb);
    void drawLine(int x1, int y1, int x2, int y2, int rgb);
    void drawText(int x, int y, String text, int rgb);
}
