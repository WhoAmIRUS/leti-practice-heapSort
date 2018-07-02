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
        Node[] i = new HeapSortMax().sort(tree);
        for(Node e: i){
            System.out.println(e.getValue());
        }
    }

    public void sortMin(){
        Node[] i = new HeapSortMin().sort(tree);
        for(Node e: i){
            System.out.println(e.getValue());
        }
    }
}
