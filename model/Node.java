package com.etu.heapsort.model;

public class Node {
    private int value;
    private Point position;

    private Node(int value, Point position) {
        this.value = value;
        this.position = position;
    }

    static Node restore(int value){
        Point position = new Point(10, 10);
        return new Node(value, position);
    }

    int getValue() {
        return value;
    }

    public Point getPosition() {
        return position;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
