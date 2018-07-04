package com.etu.heapsort.model;

public class Node {
    private int value;
    private Point position;

    private Node(int value, Point position) {
        this.value = value;
        this.position = position;
    }

    static Node restore(int value, int x, int y){
        Point position = new Point(x,y);
        return new Node(value, position);
    }

    public int getValue() {
        return value;
    }

    public Point getPosition() {
        return position;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
