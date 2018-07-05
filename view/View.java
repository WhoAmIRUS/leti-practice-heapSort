package view;

import model.Model;
import model.Node;
import model.Tree;
import swing.ProjectLauncher;

import java.awt.*;
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
            int x = tree[i].getPosition().getX();
            int y = tree[i].getPosition().getY();
            Color oval;
            if (tree[i].getClr()){
                oval = Color.red;
            } else {
                oval = Color.white;
            }
            if (2*i + 1 < tree.length){
                graphics.drawLine(x, y,tree[2*i + 1].getPosition().getX(),tree[2*i + 1].getPosition().getY(),Color.black.getRGB());
            }
            if (2*i + 2 < tree.length) {
                graphics.drawLine(x, y,tree[2*i + 2].getPosition().getX(),tree[2*i + 2].getPosition().getY(), Color.black.getRGB());
            }
            graphics.drawOval(x - 15, y - 15, 30, 30, oval.getRGB());
            graphics.drawText(x - 3, y + 4, String.valueOf(tree[i].getValue()), Color.black.getRGB());
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

    public synchronized void previousStep(){
    }

    public synchronized void nextStep(){
        notifyAll();
    }
}
