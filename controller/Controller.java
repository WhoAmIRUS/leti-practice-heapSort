package controller;

import model.Model;
import swing.SwingGraphicsAdapter;
import view.View;
import swing.ProjectLauncher;

public class Controller{
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void sortMax(){
        if (ProjectLauncher.getControls().getTextField().getText().length() != 0){
            this.model = model.reedFromTextField(ProjectLauncher.getControls().getTextField().getText());
        }
        model.sortMax();
        restartView();
    }

    public void sortMin(){
        if (ProjectLauncher.getControls().getTextField().getText().length() != 0){
            this.model = model.reedFromTextField(ProjectLauncher.getControls().getTextField().getText());
        }
        model.sortMin();
        restartView();
    }

    public void previousStep(){
        this.view.previousStep();
    }

    public void nextStep(){
        this.view.nextStep();
    }

    public void automaticSort(){
        View.isAutomaticSort = !View.isAutomaticSort;
    }

    public Model getModel() {
        return model;
    }

    public static void changeAnswer(String answer){
        ProjectLauncher.getControls().getLabel().setText("Answer: " + answer);
    }

    private void restartView(){
        if (this.view.isAlive()) this.view = null;
        this.view = new View();
        this.view.setGraphics(new SwingGraphicsAdapter(ProjectLauncher.getCanvas().getGraphics()));
        this.view.start();
    }
}
