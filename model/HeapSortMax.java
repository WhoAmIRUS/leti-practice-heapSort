package com.etu.heapsort.model;

import com.etu.heapsort.controller.Controller;

public class HeapSortMax extends HeapSort {

    public HeapSortMax(Tree tree, boolean isAutomaticSort){
        super(tree, isAutomaticSort);
    }

    @Override
    void heapify(Tree nodes, int currentNode) {
        int left = left(currentNode);
        int right = right(currentNode);
        int largest = currentNode;
        if (left < heapSize && nodes.getTree()[currentNode].getValue() < nodes.getTree()[left].getValue()) {
            largest = left;
        }
        if (right < heapSize && nodes.getTree()[largest].getValue() < nodes.getTree()[right].getValue()) {
            largest = right;
        }
        if (currentNode != largest) {
            nodes.setExplain("Swap " + currentNode + " and " + largest + " elements");
            Model.addTree((Tree)nodes.clone());
            swap(nodes.getTree(), currentNode, largest);
            heapify(nodes, largest);
        }
    }
}
