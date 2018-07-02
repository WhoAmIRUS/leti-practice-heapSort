package com.etu.heapsort.model;

abstract class HeapSort {
    /**
     * Изначальное построение дерева
     * @param nodes - массив значений вершин дерева
     */
    int heapSize;

    Node[] sort(Node[] nodes){
        //TODO алгоритм сортировки массива используя bildHeap and heapify
        buildHeap(nodes);
        while (heapSize > 1) {
            swap(nodes, 0, heapSize - 1);
            heapSize--;
            heapify(nodes, 0);
        }
        return nodes;
    }

    void buildHeap(Node[] nodes){
        heapSize = nodes.length;
        for (int i = nodes.length / 2; i >= 0; i--) {
            heapify(nodes, i);
        }
    }

    /**
     * Возвращает индекс правого потомка текущего узла
     *
     * @param i индекс текущего узла кучи
     * @return индекс правого потомка
     */
    int right(int i) {
        return 2 * i + 1;
    }

    /**
     * Возвращает индекс левого потомка текущего узла
     *
     * @param i индекс текущего узла кучи
     * @return индекс левого потомка
     */
    int left(int i) {
        return 2 * i + 2;
    }

    /**
     * Построение дерева так, чтобы потомки текущей вершины были больше(меньше) родителя
     * @param nodes - массив значений вершин дерева
     * @param currentNode - текущая рассматриваемая вершина
     */
    abstract void heapify(Node[] nodes, int currentNode);

    void swap(Node[] nodes, int i, int j) {
        Node temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }
}
