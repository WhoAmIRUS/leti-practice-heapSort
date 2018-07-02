package com.etu.heapsort.model;

abstract class HeapSort {
    /**
     * Изначальное построение дерева
     * @param nodes - массив значений вершин дерева
     */
    abstract void buildHeap(int[] nodes);

    /**
     * Построение дерева так, чтобы потомки текущей вершины были больше(меньше) родителя
     * @param nodes - массив значений вершин дерева
     * @param currentNode - текущая рассматриваемая вершина
     */
    abstract void heapify(int[] nodes, int currentNode);

    static void sort(int[] nodes){
        System.out.println("lalka");
        //TODO алгоритм сортировки массива используя bildHeap and heapify
    }
}
