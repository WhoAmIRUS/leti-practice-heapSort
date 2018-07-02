package com.etu.heapsort.model;

public class HeapSortMin extends HeapSort {
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
            swap(nodes, currentNode, largest);
            heapify(nodes, largest);
        }
    }
}
