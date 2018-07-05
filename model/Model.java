package model;

import java.util.ArrayList;

public class Model {
    private HeapSort heapSort;
    private Tree tree;
    private static ArrayList<Tree> ListOfTrees = new ArrayList<>();

    private Model(Tree tree) {
        this.tree = tree;
    }
    
    
    public static Model restore(ArrayList<Integer> buffer){
        return new Model(Tree.restore(buffer));
    }


    public void sortMax(){
        heapSort = new HeapSortMax(new Tree(tree));
        heapSort.run();
    }

    public void sortMin(){
        heapSort = new HeapSortMin(new Tree(tree));
        heapSort.run();
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

    public static ArrayList<Tree> getListOfTrees() {
        return ListOfTrees;
    }
}
