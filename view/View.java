package com.etu.heapsort.view;

import com.etu.heapsort.model.Model;
import com.etu.heapsort.model.Tree;
import com.etu.heapsort.model.Node;
import com.etu.heapsort.swing.ProjectLauncher;

import java.util.ArrayList;

public class View extends Thread{

    private Graphics graphics;
    public static boolean isAutomaticSort = false;

    public void run(){
        draw(Model.getListOfTrees());
    }

    public synchronized void draw(ArrayList<Tree> ListOfTrees){
        for (int i=0; i<ListOfTrees.size(); i++){
            ProjectLauncher.getCanvas().update(ProjectLauncher.getCanvas().getGraphics());
            drawTree(ListOfTrees.get(i).getTree());
            changeExplain(ListOfTrees.get(i).getExplain());
            if (!isAutomaticSort) checkedWait();
            else{
                i = ListOfTrees.size() - 1;
                ProjectLauncher.getCanvas().update(ProjectLauncher.getCanvas().getGraphics());
                drawTree(ListOfTrees.get(i).getTree());
                changeExplain(ListOfTrees.get(i).getExplain());
            }
        }
        Model.clearListOfTrees();
    }
    private void drawTree(Node[] tree) {
        for (int i = 0; i < tree.length; i++) {
            if (2*i + 1 < tree.length){
                graphics.drawLine(tree[i].getPosition().getX(), tree[i].getPosition().getY(),tree[2*i + 1].getPosition().getX(),tree[2*i + 1].getPosition().getY(),java.awt.Color.RED.getRGB());
            }
            if (2*i + 2 < tree.length) {
                graphics.drawLine(tree[i].getPosition().getX(), tree[i].getPosition().getY(),tree[2*i + 2].getPosition().getX(),tree[2*i + 2].getPosition().getY(), java.awt.Color.RED.getRGB());
            }
            graphics.drawOval(tree[i].getPosition().getX() - 7, tree[i].getPosition().getY() - 7 , 14, 14, java.awt.Color.GREEN.getRGB());
            graphics.drawText(tree[i].getPosition().getX()-2, tree[i].getPosition().getY()+2, String.valueOf(tree[i].getValue()), java.awt.Color.RED.getRGB());
        }
    }

    public static void changeExplain(String explain){
        ProjectLauncher.getControls().getLabel().setText("Explain: " + explain);
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    void checkedWait(){
        try {
             wait();
        } catch (InterruptedException e){
            System.out.println("Error");
        }
    }

    public synchronized void nextStep(){
        notifyAll();
    }
}
