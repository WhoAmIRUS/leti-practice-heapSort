package com.etu.heapsort.view;

import com.etu.heapsort.model.Node;

public class View{

    private Graphics graphics;

    public void draw(Node[] tree){
        drawTree(tree);
    }
    private void drawTree(Node[] tree) {
        for (int i = 0; i < tree.length; i++) {
            if (2*i + 1 < tree.length){
                graphics.drawLine(tree[i].getPosition().getX(), tree[i].getPosition().getY(),tree[2*i + 1].getPosition().getX(),tree[2*i + 1].getPosition().getY(),java.awt.Color.RED.getRGB());
            }
            if (2*i + 2 < tree.length) {
                graphics.drawLine(tree[i].getPosition().getX(), tree[i].getPosition().getY(),tree[2*i + 2].getPosition().getX(),tree[2*i + 2].getPosition().getY(), java.awt.Color.RED.getRGB());
            }
            graphics.drawOval(tree[i].getPosition().getX() - 7, tree[i].getPosition().getY() - 7 , 14, 14, java.awt.Color.GREEN.getRGB());
            graphics.drawText(tree[i].getPosition().getX()-2, tree[i].getPosition().getY()+2, String.valueOf(tree[i].getValue()), java.awt.Color.RED.getRGB());
        }
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
