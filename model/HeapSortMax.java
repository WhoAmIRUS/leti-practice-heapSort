package model;

import controller.Controller;

import com.etu.heapsort.controller.Controller;

public class HeapSortMax extends HeapSort {

    public HeapSortMax(Tree tree){
        super(tree);
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
            changecolor(nodes.getTree(),currentNode,largest,true);
            Model.addTree(new Tree(nodes));
            swap(nodes.getTree(), currentNode, largest);
            heapify(nodes, largest);
        }
    }
}
