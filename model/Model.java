package com.etu.heapsort.model;

import java.util.ArrayList;

public class Model {
    private Node[] tree;
    private HeapSort heapSort;
    public static boolean isAutomaticSort;
    private final static int step_x = 6, step_y = 40;

    private Model(Node[] tree) {
        this.tree = tree;
    }
    
    
    public static Model restore(ArrayList<Integer> buffer){
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
        return new Model(tree);
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


    public Node[] getTree() {
        return tree;
    }


    public void sortMax(){
        if (heapSort != null){
            heapSort = null;
        }
        heapSort = new HeapSortMax(tree, isAutomaticSort);
        heapSort.start();
    }

    public void sortMin(){
        if (heapSort != null){
            heapSort = null;
        }
        heapSort = new HeapSortMin(tree, isAutomaticSort);
        heapSort.start();
    }

    public void nextStep(){
        if (heapSort != null) heapSort.nextStep();
        //heapSort = null;
    }

    public Model reedFromTextField(String text){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<text.length(); i++){
            if (text.charAt(i) == ' ') continue;
            list.add(text.charAt(i) - '0');
        }
        return restore(list);
    }
}
