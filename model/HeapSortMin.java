package com.etu.heapsort.model;

import com.etu.heapsort.controller.Controller;

public class HeapSortMin extends HeapSort {

    public HeapSortMin(Tree tree, boolean isAutomaticSort){
        super(tree, isAutomaticSort);
    }

    @Override
    void heapify(Tree nodes, int currentNode) {
        int left = left(currentNode);
        int right = right(currentNode);
        int largest = currentNode;
        if (left < heapSize && nodes.getTree()[currentNode].getValue() > nodes.getTree()[left].getValue()) {
            largest = left;
        }
        if (right < heapSize && nodes.getTree()[largest].getValue() > nodes.getTree()[right].getValue()) {
            largest = right;
        }
        if (currentNode != largest) {
            nodes.setExplain("Swap " + currentNode + " and " + largest + " elements");
            Model.addTree(new Tree(nodes));
            swap(nodes.getTree(), currentNode, largest);
            heapify(nodes, largest);
        }
    }
}
