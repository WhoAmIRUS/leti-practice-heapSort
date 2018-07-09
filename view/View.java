package heapsort.view;

import java.awt.*;
import heapsort.model.Model;
import heapsort.model.Tree;
import heapsort.model.Node;
import heapsort.swing.ProjectLauncher;

import java.util.ArrayList;

public class View extends Thread{

    private Graphics graphics;
    public static boolean isAutomaticSort = false;
    private int currentSlide;
    private boolean flag = false;

    public void run(){
        draw(Model.getListOfTrees());
    }
    //выходит из цикла, по этому нельзя назад нажать
    public synchronized void draw(ArrayList<Tree> ListOfTrees){
        ProjectLauncher.getProgressBar().setCountOfSlides(ListOfTrees.size());
        for (currentSlide=0; currentSlide<ListOfTrees.size(); currentSlide++){
            ProjectLauncher.getCanvas().update(ProjectLauncher.getCanvas().getGraphics());
            drawTree(ListOfTrees.get(currentSlide).getTree());
            changeExplain(ListOfTrees.get(currentSlide).getExplain());
            ProjectLauncher.getProgressBar().increaseCurrentSlide();
            if (!isAutomaticSort) checkedWait();
            else{
                currentSlide = ListOfTrees.size() - 1;
                //flag = true;
                ProjectLauncher.getCanvas().update(ProjectLauncher.getCanvas().getGraphics());
                drawTree(ListOfTrees.get(currentSlide).getTree());
                changeExplain(ListOfTrees.get(currentSlide).getExplain());
                ProjectLauncher.getProgressBar().setCurrentSlide(currentSlide + 1);
            }
        }
    }
    private void drawTree(Node[] tree) {
        for (int i = 0; i < tree.length; i++) {
            int x = tree[i].getPosition().getX();
            int y = tree[i].getPosition().getY();
            Color oval;
            int centr = tree[i].getValue();
            int step = 0;
            while (centr > 0){
                centr /= 10;
                step++;
            }
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
            graphics.drawText(x - 4*step, y + 4, String.valueOf(tree[i].getValue()), Color.black.getRGB());
        }
    }

    private static void changeExplain(String explain){
        ProjectLauncher.getControls().getLabel().setText("Explain: " + explain);
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    private void checkedWait(){
        try {
             wait();
        } catch (InterruptedException e){
            System.out.println("Error");
        }
    }

    public synchronized void previousStep(){
        if (currentSlide - 1 >= 0){
            currentSlide -= 2;
            ProjectLauncher.getProgressBar().setCurrentSlide(currentSlide + 1);
            notifyAll();
        }
    }
    public synchronized void nextStep(){
        notifyAll();
    }
}
