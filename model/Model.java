package com.etu.heapsort.model;

import java.util.ArrayList;

public class Model {
    private HeapSort heapSort;
    private Tree tree;
    public static boolean isAutomaticSort;
    private static ArrayList<Tree> ListOfTrees = new ArrayList<>();

    private Model(Tree tree) {
        this.tree = tree;
    }
    
    
    public static Model restore(ArrayList<Integer> buffer){
        return new Model(Tree.restore(buffer));
    }


    public void sortMax(){
        if (heapSort != null){
            heapSort = null;
        }
        heapSort = new HeapSortMax(tree, isAutomaticSort);
        heapSort.run();
    }

    public void sortMin(){
        if (heapSort != null){
            heapSort = null;
        }
        heapSort = new HeapSortMin(tree, isAutomaticSort);
        heapSort.run();
    }

    public void nextStep(){
        if (heapSort != null) heapSort.nextStep();
        //heapSort = null;
    }

    public Model reedFromTextField(String text){
        ArrayList<Integer> list = new ArrayList<>();
        for (String i : text.split(" ")){
            list.add(Integer.parseInt(i));
        }
        return restore(list);
    }

    public static void addTree(Tree tree){
        ListOfTrees.add(tree);
    }

    public static void clearListOfTrees(){
        ListOfTrees.clear();
    }
}
