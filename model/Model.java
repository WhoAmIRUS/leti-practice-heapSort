package com.etu.heapsort.model;

import java.util.ArrayList;

public class Model {
    private Node[] tree;

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
        HeapSortMax.sort(new int[]{1, 2 ,3});
    }

    public void sortMin(){
        HeapSortMin.sort(new int[]{1, 2 ,3});
    }
}
