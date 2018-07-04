package com.etu.heapsort.model;

import com.etu.heapsort.controller.Controller;

abstract class HeapSort{
    /**
     * Изначальное построение дерева
     *
     * @param nodes - массив значений вершин дерева
     */
    int heapSize;
    private Tree tree;
    private boolean isAutomaticSort;
    public static String answer;

    HeapSort(Tree tree, boolean isAutomaticSort){
        this.tree = tree;
        this.isAutomaticSort = isAutomaticSort;
    }

    public void run(){
        this.tree = sort(tree);
        answer = "";
        for(Node e: tree.getTree()){
            System.out.println(e.getValue());
            answer = answer + " " + e.getValue();
        }
        this.tree.setExplain(answer);
        Model.addTree((Tree)tree.clone());
    }

    private Tree sort(Tree nodes){
        nodes.setExplain("Start first part of sort");
        Model.addTree((Tree)nodes.clone());
        buildHeap(nodes);
        nodes.setExplain("Start second part of sort");
        Model.addTree((Tree)nodes.clone());
        while (heapSize > 1) {
            nodes.setExplain("Swap " + 0 + " and " + (heapSize - 1) + " elements");
            Model.addTree((Tree)nodes.clone());
            swap(nodes.getTree(), 0, heapSize - 1);
            heapSize--;
            nodes.setExplain("Start heapify");
            Model.addTree((Tree)nodes.clone());
            heapify(nodes, 0);
        }
        return nodes;
    }

    void buildHeap(Tree nodes) {
        heapSize = nodes.getTree().length;
        for (int i = nodes.getTree().length / 2; i >= 0; i--) {
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
     *
     * @param nodes       - массив значений вершин дерева
     * @param currentNode - текущая рассматриваемая вершина
     */
    abstract void heapify(Tree nodes, int currentNode);

    void swap(Node[] nodes, int i, int j) {
        int temp = nodes[i].getValue();
        nodes[i].setValue(nodes[j].getValue());
        nodes[j].setValue(temp);
    }

    synchronized void nextStep(){
        notifyAll();
    }


    void checkedWait(){
        try {
            if (!isAutomaticSort) {
                wait();
            } else {
                //Thread.sleep(300);
            }
        } catch (InterruptedException e){
            System.out.println("Error");
        }
    }
}
