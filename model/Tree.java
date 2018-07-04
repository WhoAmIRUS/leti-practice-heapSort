package com.etu.heapsort.model;

import java.util.ArrayList;

public class Tree  implements Cloneable{
    private Node[] tree;
    private String explain;
    private final static int step_x = 6, step_y = 40;

    private Tree(Node[] tree){
        this.tree = tree;
    }

    public static Tree restore(ArrayList<Integer> buffer){
        Node[] tree = new Node[buffer.size()];
        int x_root = 450, y_root = 10, i = 0;
        int level = heightheap(buffer.size());
        tree[i] = Node.restore(buffer.get(i),x_root,y_root);
        if (i*2+2 < buffer.size()){
            makeright(level,i * 2 + 2, x_root, y_root, buffer,tree);
        }
        if (i*2+1 < buffer.size()) {
            makeleft(level,i * 2 + 1,x_root,y_root,buffer,tree);
        }
        return new Tree(tree);
    }

    public static void makeleft(int level, int i, int parent_x, int parent_y, ArrayList<Integer>buffer, Node[]tree){
        level--;
        int x = (int) (parent_x - step_x*Math.pow(2,level));
        int y = parent_y + step_y;
        tree[i] = Node.restore(buffer.get(i),x,y);
        if (i*2+2 < buffer.size()){
            makeright(level,i * 2 + 2, x, y, buffer,tree);
        }
        if (i*2+1 < buffer.size()) {
            makeleft(level,i*2 + 1,x,y,buffer,tree);
        }
    }

    public static void makeright(int level, int i, int parent_x, int parent_y, ArrayList<Integer>buffer, Node[]tree){
        level--;
        int x = (int) (parent_x + step_x*Math.pow(2,level));
        int y = parent_y + step_y;
        tree[i] = Node.restore(buffer.get(i),x,y);
        if (i*2+1 < buffer.size()) {
            makeleft(level,i * 2 + 1, x, y, buffer, tree);
        }
        if (i*2+2 < buffer.size()) {
            makeright(level,i * 2 + 2, x, y, buffer,tree);
        }
    }


    public static int heightheap(int x) {
        int t = 1, index = 0;
        while (x >= t){
            t <<= 1;
            index++;
        }
        return index;
    }

    protected Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e){
            System.out.println("Error");
            return null;
        }

    }

    public Node[] getTree() {
        return tree;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
