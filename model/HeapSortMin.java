package com.etu.heapsort.model;

import com.etu.heapsort.controller.Controller;

public class HeapSortMin extends HeapSort {

    public HeapSortMin(Node[] tree, boolean isAutomaticSort){
        super(tree, isAutomaticSort);
    }

    @Override
    void heapify(Node[] nodes, int currentNode) {
        int left = left(currentNode);
        int right = right(currentNode);
        int largest = currentNode;
        if (left < heapSize && nodes[currentNode].getValue() > nodes[left].getValue()) {
            largest = left;
        }
        if (right < heapSize && nodes[largest].getValue() > nodes[right].getValue()) {
            largest = right;
        }
        if (currentNode != largest) {
            Controller.changeExplain("Swap " + currentNode + " and " + largest + " elements");
            checkedWait();
            swap(nodes, currentNode, largest);
            heapify(nodes, largest);
        }
    }
}
