package com.etu.heapsort.model;

public class Node {
    private int value;
    private Point position;

    public Node(int value, Point position) {
        this.value = value;
        this.position = position;
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
