package com.etu.heapsort.model;

import java.util.ArrayList;

public class Model {
    private Node[] tree;
    private HeapSort heapSort;
    public boolean isAutomaticSort = false;

    private Model(Node[] tree) {
        this.tree = tree;
    }

    public static Model restore(ArrayList<Integer> buffer){
        Node[] tree = new Node[buffer.size()];
        for (int i=0; i<buffer.size(); i++){
            tree[i] = Node.restore(buffer.get(i));
        }
        return new Model(tree);
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
}
